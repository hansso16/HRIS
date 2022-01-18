package com.soses.hris.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeAddressRequest;
import com.soses.hris.api.EmployeeAddressResponse;
import com.soses.hris.common.AddressTypeEnum;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.repository.EmployeeAddressRepository;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.EmployeeAddressService;

@Service("EmployeeAddressServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

	private EmployeeAddressRepository employeeAddressRepo;
	
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeAddressServiceImpl(EmployeeAddressRepository employeeAddressRepo, EmployeeRepository employeeRepo) {
		super();
		this.employeeAddressRepo = employeeAddressRepo;
		this.employeeRepo = employeeRepo;
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
		} else {
			if (employeeRepo.existsById(employeeId)) {
				empAddressTOList.add(new EmployeeAddressTO("1", AddressTypeEnum.valueOfAddressType("1").getAddressTypeName()));
				empAddressTOList.add(new EmployeeAddressTO("2", AddressTypeEnum.valueOfAddressType("2").getAddressTypeName()));
				empAddressTOList.add(new EmployeeAddressTO("3", AddressTypeEnum.valueOfAddressType("3").getAddressTypeName()));
			} else {
				//return error;
			}
		}
		
		
		resp.setEmployeeAddressList(empAddressTOList);
		
		return resp;
	}

	@Override
	public boolean updateEmployeeDetails(BaseEmployeeRequest formReq) {

		EmployeeAddressRequest request = (EmployeeAddressRequest) formReq;
		
		List<EmployeeAddress> employeeAddressList = request.getEmployeeAddress();
		boolean isSaved = false;
		if (!GeneralUtil.isListEmpty(employeeAddressList)) {
			employeeAddressList = employeeAddressRepo.saveAll(employeeAddressList);
			isSaved = true;
		}

		return isSaved;
	}

}
