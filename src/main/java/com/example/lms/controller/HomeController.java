package com.example.lms.controller;

import com.example.lms.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	private OpportunityService opportunityService;

	@RequestMapping({"","/","home","/home"})
	public String getHome(ModelMap modelMap)
	{
		modelMap.put("opportunities",opportunityService.getAllOpportunities());
//		modelMap.put("oppsByBrand",opportunityService.getOpportunitiesByBrand());
		return "home";
	}
}
