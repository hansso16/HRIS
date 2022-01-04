package com.soses.hris.service;

import com.soses.hris.api.EmployeeProfileRequest;

public interface EmployeeProfileService extends BaseEmployeeService {

	boolean updateEmployeeDetails(EmployeeProfileRequest request);
}
