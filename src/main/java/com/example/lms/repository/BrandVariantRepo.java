package com.example.lms.repository;

import com.example.lms.domain.BrandVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandVariantRepo extends JpaRepository<BrandVariant,Long> {

	BrandVariant findByName(String name);

}
