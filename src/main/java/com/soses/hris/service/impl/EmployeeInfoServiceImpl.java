package com.soses.hris.service.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeInfoRequest;
import com.soses.hris.api.EmployeeInfoResponse;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.dto.EmployeeInfoTO;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.entity.EmployeeInfo;
import com.soses.hris.repository.EmployeeInfoRepository;
import com.soses.hris.service.EmployeeInfoService;

@Service("EmployeeInfoServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	private EmployeeInfoRepository employeeInfoRepo;
	
	@Autowired
	public EmployeeInfoServiceImpl(EmployeeInfoRepository employeeInfoRepo) {
		super();
		this.employeeInfoRepo = employeeInfoRepo;
	}

	@Override
	public BaseEmployeeResponse getEmployeeDetails(String employeeId) {
		
		EmployeeInfoResponse resp = new EmployeeInfoResponse();
		
		EmployeeInfo employeeInfo = employeeInfoRepo.findByEmployeeId(employeeId);
		EmployeeInfoTO employeeInfoTO = null;
		if (employeeInfo != null) {
			employeeInfoTO = EmployeeTransformerUtil.transformEmployeeInfoEntity(employeeInfo);
			if (employeeInfoTO != null) {
				resp.setEmployeeInfo(employeeInfoTO);
			} else {
				ErrorPageDTO error = new ErrorPageDTO();
				error.setMessage("Employee Information not found for employee ID: " + employeeId);
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
	public boolean updateEmployeeDetails(EmployeeInfoRequest request) {
		
		boolean isSaved = false;
		EmployeeInfo employeeInfo = request.getEmployeeInfo();
		if (employeeInfo != null) {
			employeeInfo = employeeInfoRepo.save(employeeInfo);
			isSaved = true;
		}
		
		return isSaved;
	}
}
