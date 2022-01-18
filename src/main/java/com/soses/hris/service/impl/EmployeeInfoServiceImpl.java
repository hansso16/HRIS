package com.soses.hris.service.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeInfoRequest;
import com.soses.hris.api.EmployeeInfoResponse;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.dto.EmployeeInfoTO;
import com.soses.hris.entity.EmployeeInfo;
import com.soses.hris.repository.EmployeeInfoRepository;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.EmployeeInfoService;

@Service("EmployeeInfoServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	private EmployeeInfoRepository employeeInfoRepo;
	
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeInfoServiceImpl(EmployeeInfoRepository employeeInfoRepo, EmployeeRepository employeeRepo) {
		super();
		this.employeeInfoRepo = employeeInfoRepo;
		this.employeeRepo = employeeRepo;
	}

	@Override
	public BaseEmployeeResponse getEmployeeDetails(String employeeId) {
		
		EmployeeInfoResponse resp = new EmployeeInfoResponse();
		
		EmployeeInfo employeeInfo = employeeInfoRepo.findByEmployeeId(employeeId);
		EmployeeInfoTO employeeInfoTO = null;
		if (employeeInfo != null) {
			employeeInfoTO = EmployeeTransformerUtil.transformEmployeeInfoEntity(employeeInfo);
		} else {
			if (employeeRepo.existsById(employeeId)) {
				employeeInfoTO = new EmployeeInfoTO();
			} else {
				//error
			}
		}
		
		resp.setEmployeeInfo(employeeInfoTO);
		return resp;
	}

	@Override
	public boolean updateEmployeeDetails(BaseEmployeeRequest formReq) {

		EmployeeInfoRequest request = (EmployeeInfoRequest) formReq;
		boolean isSaved = false;
		EmployeeInfo employeeInfo = request.getEmployeeInfo();
		if (employeeInfo != null) {
			employeeInfo = employeeInfoRepo.save(employeeInfo);
			isSaved = true;
		}
		
		return isSaved;
	}
}
