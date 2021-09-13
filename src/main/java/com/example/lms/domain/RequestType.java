package com.example.lms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "RequestTypes")
public class RequestType {

	@Id
	@GeneratedValue
	private Long id;

	private String value;
	private String label;

	public RequestType() {
	}

	public RequestType(String value, String label) {
		this.value = value;
		this.label = label;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
