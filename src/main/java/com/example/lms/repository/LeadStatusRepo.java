package com.example.lms.repository;

import com.example.lms.domain.LeadStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadStatusRepo extends JpaRepository<LeadStatus, Long> {

	LeadStatus findByValue(String value);
}
