package com.soses.hris.service;

import com.soses.hris.api.BaseEmployeeResponse;

public interface BaseEmployeeService {

	//get details
	BaseEmployeeResponse getEmployeeDetails(String employeeId); // what is the return type??
	
	//update details
	BaseEmployeeResponse updateEmployeeDetails();
	
}
