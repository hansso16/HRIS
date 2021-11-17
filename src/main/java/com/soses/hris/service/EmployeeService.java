package com.soses.hris.service;

import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.entity.Employee;

public interface EmployeeService {

	Employee findEmployeeById(int employeeId);
	
	//get details
	BaseEmployeeResponse getEmployeeDetails(int employeeId); // what is the return type??
	
	//update details
	
}
