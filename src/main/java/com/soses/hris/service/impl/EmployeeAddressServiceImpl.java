package com.soses.hris.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeAddressRequest;
import com.soses.hris.api.EmployeeAddressResponse;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.repository.EmployeeAddressRepository;
import com.soses.hris.service.EmployeeAddressService;

@Service("EmployeeAddressServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

	private EmployeeAddressRepository employeeAddressRepo;
	
	@Autowired
	public EmployeeAddressServiceImpl(EmployeeAddressRepository employeeAddressRepo) {
		super();
		this.employeeAddressRepo = employeeAddressRepo;
	}

	@Override
	public BaseEmployeeResponse getEmployeeDetails(String employeeId) {
		
		EmployeeAddressResponse resp = new EmployeeAddressResponse();
		
		List<EmployeeAddress> empAddressList = employeeAddressRepo.findByIdEmployeeId(employeeId);
		List<EmployeeAddressTO> empAddressTOList = new ArrayList<>();
		if (!GeneralUtil.isListEmpty(empAddressList)) {
			for (EmployeeAddress empAddress : empAddressList) {
				EmployeeAddressTO empAddressTO = EmployeeTransformerUtil.transformEmployeeAddress(empAddress);
				empAddressTOList.add(empAddressTO);
			}
		}
		
		if (!GeneralUtil.isListEmpty(empAddressTOList)) {
			resp.setEmployeeAddressList(empAddressTOList);
		} else {
			ErrorPageDTO error = new ErrorPageDTO();
			error.setMessage("Employee Address not found for employee ID: " + employeeId);
			resp.setError(error);
			return resp;
		}
		
		return resp;
	}

	@Override
	public BaseEmployeeResponse updateEmployeeDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployeeDetails(EmployeeAddressRequest request) {

		List<EmployeeAddress> employeeAddressList = request.getEmployeeAddress();
		boolean isSaved = false;
		if (!GeneralUtil.isListEmpty(employeeAddressList)) {
			employeeAddressList = employeeAddressRepo.saveAll(employeeAddressList);
			isSaved = true;
		}
		
		return isSaved;
	}

}
