package com.example.lms.repository;

import com.example.lms.domain.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepo extends JpaRepository<Opportunity,Long> {
	Opportunity findByName(String name);
}
