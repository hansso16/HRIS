package com.soses.hris.service;

import com.soses.hris.api.EmployeeBenefitsRequest;

public interface EmployeeBenefitsService extends BaseEmployeeService {

	boolean updateEmployeeDetails(EmployeeBenefitsRequest request);
}