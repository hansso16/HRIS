package com.soses.hris.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeSearchResponse;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.entity.Employee;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepo; 
	
	@Autowired
	public void setEmployeeRepo(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee findEmployeeById(int employeeId) {
		
		EmployeeSearchResponse resp = new EmployeeSearchResponse();
		EmployeeTO employeeTO = null;
		Employee employee = employeeRepo.findByEmployeeId(employeeId);
		
		if (employee != null) {
			employeeTO = new EmployeeTO();
			employeeTO.setEmployeeId(employee.getEmployeeId());
			employeeTO.setLastName(employee.getLastName());
			employeeTO.setFirstName(employee.getFirstName());
			employeeTO.setMiddleName(employee.getMiddleName());
			employeeTO.setSuffix(employee.getSuffix());
			employeeTO.setNickname(employee.getNickname());
			employeeTO.setCellNo(employee.getCellNo());
			employeeTO.setTeleNo(employee.getTelNo());
			employeeTO.setEmailAddress(employee.getEmailAddress());
			employeeTO.setGender(employee.getGender()); //derive
			employeeTO.setBirthdate(employee.getBirthdate()); //date format
			employeeTO.setMaritalStatus(employee.getMaritalStatus()); //derive
			employeeTO.setHiringDate(employee.getHiringDate()); //date format
			employeeTO.setTerminationDate(employee.getTerminationDate()); //date format
			employeeTO.setRegularizationDate(employee.getRegularizationDate()); //date format
			employeeTO.setDivision(employee.getDivision()); // derive
			employeeTO.setPosition(employee.getPosition()); // derive
			
			resp.setEmployee(employeeTO);
		}
		
		
		return employee;
	}

	@Override
	public BaseEmployeeResponse getEmployeeDetails(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}
}
