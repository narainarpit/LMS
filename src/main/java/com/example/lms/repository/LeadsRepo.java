package com.example.lms.repository;

import com.example.lms.domain.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadsRepo extends JpaRepository<Leads,Long> {
}
