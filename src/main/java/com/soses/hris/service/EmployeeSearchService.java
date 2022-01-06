package com.soses.hris.service;

import org.springframework.data.domain.Page;

import com.soses.hris.api.employee.EmployeeSearchRequest;
import com.soses.hris.entity.Employee;

public interface EmployeeSearchService {

	Page<Employee> searchEmployee(EmployeeSearchRequest request);
}
