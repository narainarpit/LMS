package com.example.lms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LeadStatus {

	@Id
	@GeneratedValue
	private Long id;

	private String label;
	private String value;

	public LeadStatus() {
	}

	public LeadStatus(String value, String label) {
		this.label = label;
		this.value = value;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
