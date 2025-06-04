package com.student.service.dto;

import jakarta.validation.constraints.NotEmpty;

public class FiliaireDto {

	@NotEmpty	
    private String designation;
	@NotEmpty	
    private String code;
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
