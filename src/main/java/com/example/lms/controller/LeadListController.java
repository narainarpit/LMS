package com.example.lms.controller;

import com.example.lms.service.LeadService;
import com.example.lms.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LeadListController {
	@Autowired
	OpportunityService opportunityService;

	@RequestMapping("/leadList")
	public String getLeadList(ModelMap modelMap){
		modelMap.put("leads",opportunityService.getAllOpportunities());
		return "leadList";
	}
}
