package com.soses.hris.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeBenefitsSearchResponse;
import com.soses.hris.bo.BenefitsEmployeeBO;
import com.soses.hris.dto.EmployeeBenefitsTO;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.service.BaseEmployeeService;

@Service("BenefitsEmployeeServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class BenefitsEmployeeServiceImpl implements BaseEmployeeService {

	private BenefitsEmployeeBO employeeBenefitsBO;
	
	@Autowired
	public BenefitsEmployeeServiceImpl(BenefitsEmployeeBO employeeBenefitsBO) {
		super();
		this.employeeBenefitsBO = employeeBenefitsBO;
	}

	@Override
	public BaseEmployeeResponse getEmployeeDetails(String employeeId) {
		
		EmployeeBenefitsSearchResponse resp = new EmployeeBenefitsSearchResponse();
		EmployeeBenefitsTO employeeBenefitsTO = employeeBenefitsBO.retrieveEmployeeBenefits(employeeId);
		if (employeeBenefitsTO != null) {
			resp.setEmployeeBenefits(employeeBenefitsTO);
		} else {
			ErrorPageDTO error = new ErrorPageDTO();
			error.setMessage("Employee ID not found: " + employeeId);
			resp.setError(error);
		}
		resp.setEmployeeId(employeeId);
		return resp;
	}

	@Override
	public BaseEmployeeResponse updateEmployeeDetails() {
		// TODO Auto-generated method stub
		return null;
	}


}
