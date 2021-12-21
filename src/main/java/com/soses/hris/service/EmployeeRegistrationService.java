package com.soses.hris.service;

import com.soses.hris.api.AddEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;

public interface EmployeeRegistrationService {

	BaseEmployeeResponse registerEmployee(AddEmployeeRequest request);
}
