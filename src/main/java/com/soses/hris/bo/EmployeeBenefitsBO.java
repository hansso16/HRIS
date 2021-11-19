package com.soses.hris.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.dto.EmployeeBenefitsTO;
import com.soses.hris.entity.EmployeeBenefits;
import com.soses.hris.repository.EmployeeBenefitsRepository;

public class EmployeeBenefitsBO {

	private EmployeeBenefitsRepository employeeBenefitsRepo;

	@Autowired
	public EmployeeBenefitsBO(EmployeeBenefitsRepository employeeBenefitsRepo) {
		super();
		this.employeeBenefitsRepo = employeeBenefitsRepo;
	}

	public EmployeeBenefitsTO retrieveEmployeeBenefits(String employeeId) {
		
		EmployeeBenefitsTO employeeBenefitsTO = null;
		EmployeeBenefits employeeBenefits = employeeBenefitsRepo.findByEmployeeId(employeeId);
		if (employeeBenefits != null) {
			employeeBenefitsTO = EmployeeTransformerUtil.transformEmployeeBenefits(employeeBenefits);
		}
		
		return employeeBenefitsTO;
	}
	
	
}
