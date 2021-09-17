package com.example.lms.service;

import com.example.lms.domain.Lead;
import com.example.lms.domain.Opportunity;
import com.example.lms.repository.OpportunityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OpportunityService {
	@Autowired
	private OpportunityRepo opportunityRepo;

	public List<Opportunity> getAllOpportunities(){
		return opportunityRepo.findAll();
	}

	public Optional<Opportunity> getOpportunity(Long id) {
		return opportunityRepo.findById(id);
	}
	public Opportunity save(Opportunity opportunity){
		return opportunityRepo.save(opportunity);
	}
	public Collection<Opportunity> getOpportunitiesByBrand(){
		return opportunityRepo.getOpportunitiesByBrand();
	}
	public Collection<Opportunity> getOpportunitiesByStatus(){
		return opportunityRepo.getOpportunitiesByStatus();
	}
}
