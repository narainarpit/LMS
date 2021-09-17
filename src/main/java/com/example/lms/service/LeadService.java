package com.example.lms.service;

import com.example.lms.domain.Lead;
import com.example.lms.repository.LeadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

	@Autowired
	LeadRepo leadRepo;

	public List<Lead> getLeads() {
		return leadRepo.findAll();
	}

	public Optional<Lead> getLead(Long id) {
		return leadRepo.findById(id);
	}

	;
}
