package com.soses.hris.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.dto.EmployeeBenefitsTO;
import com.soses.hris.entity.EmployeeBenefits;
import com.soses.hris.repository.EmployeeBenefitsRepository;

@Component
public class BenefitsEmployeeBO {

	private EmployeeBenefitsRepository employeeBenefitsRepo;

	@Autowired
	public BenefitsEmployeeBO(EmployeeBenefitsRepository employeeBenefitsRepo) {
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
