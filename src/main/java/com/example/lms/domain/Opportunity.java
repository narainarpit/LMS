package com.example.lms.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Opportunity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToOne
	private Lead latestLead;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "opportunity")
	private Set<Lead> leads;

	public Opportunity() {
	}

	public Opportunity(String name) {
		this.name = name;
	}

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

	public Lead getLatestLead() {
		return latestLead;
	}

	public void setLatestLead(Lead latestLead) {
		this.latestLead = latestLead;
	}

	public Set<Lead> getLeads() {
		return leads;
	}

	public void setLeads(Set<Lead> leads) {
		this.leads = leads;
	}
}
