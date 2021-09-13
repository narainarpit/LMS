package com.example.lms.controller;

import com.example.lms.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LeadListController {
	@Autowired
	LeadService leadService;

	@RequestMapping("/leadList")
	public String getLeadList(ModelMap modelMap){
		modelMap.put("leads",leadService.getLeads());
		return "leadList";
	}
}
