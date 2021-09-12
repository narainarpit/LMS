package com.example.lms.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	public Brand() {
	}

	public Brand(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
	private Set<BrandVariant> brandVariants;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BrandVariant> getBrandVariants() {
		return brandVariants;
	}

	public void setBrandVariants(Set<BrandVariant> brandVariants) {
		this.brandVariants = brandVariants;
	}

}
