package com.example.lms.domain;

import javax.persistence.*;

@Entity
public class Leads {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToOne
	private Contact contact;
	@OneToOne
	BrandVariant brandVariant;

	public Leads() {
	}

	public Leads(String name, Contact contact, BrandVariant brandVariant) {
		this.name = name;
		this.contact = contact;
		this.brandVariant = brandVariant;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public BrandVariant getBrandVariant() {
		return brandVariant;
	}

	public void setBrandVariant(BrandVariant brandVariant) {
		this.brandVariant = brandVariant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
