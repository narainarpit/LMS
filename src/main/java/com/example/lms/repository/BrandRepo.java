package com.example.lms.repository;

import com.example.lms.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepo  extends JpaRepository<Brand,Long> {
	Brand findByName (String name);

}
