package com.example.lms.dto;

public class LeadUpdateStatusRequest {
	private Long id;
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LeadUpdateStatusRequest{" +
				"id=" + id +
				", status='" + status + '\'' +
				'}';
	}
}
