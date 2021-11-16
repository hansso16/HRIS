package com.soses.hris.api;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;

public class BaseEmployeeRequest {

	@Digits(fraction = 0, integer = Integer.MAX_VALUE)
	@Positive
	private String employeeId;




	public String getEmployeeId() {
		return employeeId;
	}




	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}




	@Override
	public String toString() {
		return "BaseEmployeeRequest [employeeId=" + employeeId + "]";
	}
	
}
