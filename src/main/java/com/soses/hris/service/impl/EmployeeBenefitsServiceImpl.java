package com.soses.hris.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeBenefitsRequest;
import com.soses.hris.api.EmployeeBenefitsResponse;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.dto.EmployeeBenefitsTO;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.entity.EmployeeBenefits;
import com.soses.hris.repository.EmployeeBenefitsRepository;
import com.soses.hris.service.EmployeeBenefitsService;

@Service("EmployeeBenefitsServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeBenefitsServiceImpl implements EmployeeBenefitsService {

	private EmployeeBenefitsRepository employeeBenefitsRepo;
	
	@Autowired
	public EmployeeBenefitsServiceImpl(EmployeeBenefitsRepository employeeBenefitsRepo) {
		super();
		this.employeeBenefitsRepo = employeeBenefitsRepo;
	}
	
	@Override
	public BaseEmployeeResponse getEmployeeDetails(String employeeId) {

		EmployeeBenefitsResponse resp = new EmployeeBenefitsResponse();
		
		EmployeeBenefits employeeBenefits = employeeBenefitsRepo.findByEmployeeId(employeeId);
		EmployeeBenefitsTO employeeBenefitsTO = null;
		if (employeeBenefits != null) {
			employeeBenefitsTO = EmployeeTransformerUtil.transformEmployeeBenefits(employeeBenefits);
			if (employeeBenefitsTO != null) {
				resp.setEmployeeBenefits(employeeBenefitsTO);
			} else {
				ErrorPageDTO error = new ErrorPageDTO();
				error.setMessage("Employee Benefits Information not found for employee ID: " + employeeId);
				resp.setError(error);
			}
		}
		
		return resp;
	}

	@Override
	public BaseEmployeeResponse updateEmployeeDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployeeDetails(EmployeeBenefitsRequest request) {

		boolean isSaved = false;
		EmployeeBenefits employeeBenefits = request.getEmployeeBenefits();
		if (employeeBenefits != null) {
			employeeBenefits = employeeBenefitsRepo.save(employeeBenefits);
			isSaved = true;
		}
		
		return isSaved;
	}

}
