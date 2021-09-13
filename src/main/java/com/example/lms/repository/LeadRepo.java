package com.example.lms.repository;

import com.example.lms.domain.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepo extends JpaRepository<Lead,Long> {
}
