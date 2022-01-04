package com.soses.hris.service;

import com.soses.hris.api.EmployeeAddressRequest;

public interface EmployeeAddressService extends BaseEmployeeService {

	boolean updateEmployeeDetails(EmployeeAddressRequest request);
}
