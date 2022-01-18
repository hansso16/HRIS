package com.soses.hris.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeBenefitsRequest;
import com.soses.hris.api.EmployeeBenefitsResponse;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.dto.EmployeeBenefitsTO;
import com.soses.hris.entity.EmployeeBenefits;
import com.soses.hris.repository.EmployeeBenefitsRepository;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.EmployeeBenefitsService;

@Service("EmployeeBenefitsServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeBenefitsServiceImpl implements EmployeeBenefitsService {

	private EmployeeBenefitsRepository employeeBenefitsRepo;
	
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeBenefitsServiceImpl(EmployeeBenefitsRepository employeeBenefitsRepo, EmployeeRepository employeeRepo) {
		super();
		this.employeeBenefitsRepo = employeeBenefitsRepo;
		this.employeeRepo = employeeRepo;
	}
	
	@Override
	public BaseEmployeeResponse getEmployeeDetails(String employeeId) {

		EmployeeBenefitsResponse resp = new EmployeeBenefitsResponse();
		
		EmployeeBenefits employeeBenefits = employeeBenefitsRepo.findByEmployeeId(employeeId);
		EmployeeBenefitsTO employeeBenefitsTO = null;
		if (employeeBenefits != null) {
			employeeBenefitsTO = EmployeeTransformerUtil.transformEmployeeBenefits(employeeBenefits);
		} else {
			if (employeeRepo.existsById(employeeId)) {
				employeeBenefitsTO = new EmployeeBenefitsTO();
			} else {
				//error
			}
		}

		resp.setEmployeeBenefits(employeeBenefitsTO);
		return resp;
	}

	@Override
	public boolean updateEmployeeDetails(BaseEmployeeRequest formReq) {

		EmployeeBenefitsRequest request = (EmployeeBenefitsRequest) formReq;
		boolean isSaved = false;
		EmployeeBenefits employeeBenefits = request.getEmployeeBenefits();
		if (employeeBenefits != null) {
			employeeBenefits = employeeBenefitsRepo.save(employeeBenefits);
			isSaved = true;
		}
		
		return isSaved;
	}

}
