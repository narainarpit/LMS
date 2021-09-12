package com.example.lms.service;

import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import com.example.lms.domain.Leads;
import com.example.lms.repository.LeadsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadsService {

	@Autowired
	LeadsRepo leadsRepo;

	public List<Leads> getLeads(){
		return leadsRepo.findAll();
	}
}
