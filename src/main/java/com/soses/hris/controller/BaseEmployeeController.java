package com.soses.hris.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.soses.hris.entity.Employee;
import com.soses.hris.repository.UserRepository;

public class BaseEmployeeController extends BaseSearchController {

	private UserRepository userRepo;

	@Autowired
	public BaseEmployeeController(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	boolean isUser(String employeeId) {
		
		Employee emp = new Employee();
		emp.setEmployeeId(employeeId);
		return userRepo.existsByEmployee(emp);
	}


}
