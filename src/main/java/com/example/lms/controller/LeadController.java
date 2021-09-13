package com.example.lms.controller;

import com.example.lms.domain.Lead;
import com.example.lms.domain.Opportunity;
import com.example.lms.service.LeadService;
import com.example.lms.service.LeadStatusService;
import com.example.lms.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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
}
