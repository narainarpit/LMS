package com.example.lms.controller;

import com.example.lms.domain.Leads;
import com.example.lms.service.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class LeadsController {
	@Autowired
	LeadsService leadsService;

	@RequestMapping("/leads")
	public String getLeads(ModelMap modelMap){
		modelMap.put("leads",leadsService.getLeads());
		return "leads";
	}
}
