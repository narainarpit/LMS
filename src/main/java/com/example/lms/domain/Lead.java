package com.example.lms.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "Leads")
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToOne
	private Contact contact;
	@OneToOne
	private BrandVariant brandVariant;

	@OneToOne
	private RequestType requestType;

	@OneToOne
	private LeadStatus leadStatus;

	@ManyToOne
	Opportunity opportunity;

	@CreationTimestamp
	private LocalDateTime createDateTime;

	private String source;

	public Lead() {
	}

	public Lead(String name, Contact contact, BrandVariant brandVariant) {
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

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public Date getCreateDateTime() {
		return java.sql.Timestamp.valueOf(createDateTime);
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LeadStatus getLeadStatus() {
		return leadStatus;
	}

	public void setLeadStatus(LeadStatus leadStatus) {
		this.leadStatus = leadStatus;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
