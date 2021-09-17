package com.example.lms.controller;

import com.example.lms.domain.LeadStatus;
import com.example.lms.domain.Opportunity;
import com.example.lms.dto.LeadUpdateStatusRequest;
import com.example.lms.dto.LeadUpdateStatusResponse;
import com.example.lms.service.LeadStatusService;
import com.example.lms.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//@RestController
@Controller
public class LeadController {
	@Autowired
	OpportunityService opportunityService;

	@Autowired
	LeadStatusService leadStatusService;

	@RequestMapping("/lead")
	public String getLead(@RequestParam Long id, ModelMap modelMap){
		Optional<Opportunity> opportunity = opportunityService.getOpportunity(id);
		if(opportunity.isPresent()){
			modelMap.put("opportunity",opportunity.get());
		}
		modelMap.put("leadStatuses",leadStatusService.getAllLeadStatus());

		 return "lead";
	}

	@RequestMapping(value = "/leads/update",method = RequestMethod.POST)
	@ResponseBody
	public LeadUpdateStatusResponse updateLeadStatus(@RequestBody LeadUpdateStatusRequest requestBody){
		LeadUpdateStatusResponse leadUpdateStatusResponse = new LeadUpdateStatusResponse();
		Optional<Opportunity> opportunity = opportunityService.getOpportunity(requestBody.getId());
		if(opportunity.isPresent()){
			LeadStatus leadStatus = leadStatusService.getLeadByValue(requestBody.getStatus());
			opportunity.get().getLatestLead().setLeadStatus(leadStatus);
			opportunityService.save(opportunity.get());
			leadUpdateStatusResponse.setStatus("success");
		}else{
			leadUpdateStatusResponse.setStatus("failure");
		}
		return leadUpdateStatusResponse;
	}
}
