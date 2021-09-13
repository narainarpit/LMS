package com.example.lms.repository;

import com.example.lms.domain.RequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestTypeRepo extends JpaRepository<RequestType,Long> {
	RequestType findByValue(String value);
}
