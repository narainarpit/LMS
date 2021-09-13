package com.example.lms.controller;

import com.example.lms.domain.Lead;
import com.example.lms.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LeadController {
	@Autowired
	LeadService leadService;
	@RequestMapping("/lead")
	public String getLead(@RequestParam Long id, ModelMap modelMap){
		Lead lead = null;
		Optional<Lead> leadOptional = leadService.getLead(id);
		if(leadOptional.isPresent()){
			lead = leadOptional.get();
		}
		modelMap.put("lead",lead);

		 return "lead";


	}

}
