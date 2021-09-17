package com.example.lms.repository;

import com.example.lms.domain.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OpportunityRepo extends JpaRepository<Opportunity,Long> {
	Opportunity findByName(String name);

	@Query("SELECT o.id,o.name,o.latestLead.brandVariant.brand.name FROM Opportunity o")
	Collection<Opportunity> getOpportunitiesByBrand();

	@Query("SELECT o.id,o.name,o.latestLead.leadStatus.label FROM Opportunity o")
	Collection<Opportunity> getOpportunitiesByStatus();
}
