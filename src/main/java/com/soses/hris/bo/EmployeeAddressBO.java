package com.soses.hris.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.GeneralUtil;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.repository.EmployeeAddressRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeAddressBO {

	private EmployeeAddressRepository employeeAddressRepository;
	
	@Autowired
	public EmployeeAddressBO(EmployeeAddressRepository employeeAddressRepository) {
		this.employeeAddressRepository = employeeAddressRepository;
	}
	
	public boolean insertList(List<EmployeeAddress> employeeAddressList) {
		
		if (!GeneralUtil.isListEmpty(employeeAddressList)) {
			for (EmployeeAddress address : employeeAddressList) {
				employeeAddressRepository.saveAll(employeeAddressList);
			}
		}
		
		return true;
	}
}
