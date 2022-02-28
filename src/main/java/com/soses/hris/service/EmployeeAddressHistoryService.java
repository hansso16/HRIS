package com.soses.hris.service;

import com.soses.hris.api.EmployeeAddressHistoryResponse;

public interface EmployeeAddressHistoryService {

	EmployeeAddressHistoryResponse getEmployeeDetails(String employeeId, String addressType);
}
