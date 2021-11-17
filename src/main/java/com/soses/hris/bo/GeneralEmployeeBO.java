package com.soses.hris.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.GeneralUtil;
import com.soses.hris.common.TransformerUtil;
import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.entity.Employee;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.repository.EmployeeAddressRepository;
import com.soses.hris.repository.EmployeeRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GeneralEmployeeBO {

	private EmployeeRepository employeeRepo;
	private EmployeeAddressRepository employeeAddressRepo;
	
	@Autowired
	public GeneralEmployeeBO(EmployeeRepository employeeRepo, EmployeeAddressRepository employeeAddressRepo) {
		this.employeeRepo = employeeRepo;
		this.employeeAddressRepo = employeeAddressRepo;
	}
	
	public EmployeeTO retrieveEmployeeDetails(int employeeId) {
		
		Employee employee = employeeRepo.findByEmployeeId(employeeId);
		EmployeeTO employeeTO = TransformerUtil.transformEmployeeEntity(employee);
		
		return employeeTO;
	}
	
	public List<EmployeeAddressTO> retrieveEmployeeAddress(int employeeId) {

		List<EmployeeAddress> empAddressList = employeeAddressRepo.findByIdEmployeeId(employeeId);
		List<EmployeeAddressTO> empAddressTOList = new ArrayList<>();
		
		if (!GeneralUtil.isListEmpty(empAddressList)) {
			for (EmployeeAddress empAddress : empAddressList) {
				// transform
				EmployeeAddressTO empAddressTO = TransformerUtil.transformEmployeeAddress(empAddress);
				
				empAddressTOList.add(empAddressTO);
			}
		}
		
		
		
		return empAddressTOList;
	}
}
