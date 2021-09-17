package com.example.lms.service;

import com.example.lms.domain.LeadStatus;
import com.example.lms.repository.LeadStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadStatusService {
	@Autowired
	LeadStatusRepo leadStatusRepo;

	public List<LeadStatus> getAllLeadStatus(){
		return leadStatusRepo.findAll();
	}
	public LeadStatus getLeadByValue(String value){
		return leadStatusRepo.findByValue(value);
	}
}
