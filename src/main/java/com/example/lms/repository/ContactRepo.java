package com.example.lms.repository;

import com.example.lms.domain.Brand;
import com.example.lms.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Long> {
	Contact findByEmail (String email);

}
