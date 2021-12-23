package com.soses.hris.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.GeneralUtil;
import com.soses.hris.common.EmployeeTransformerUtil;
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
		super();
		this.employeeRepo = employeeRepo;
		this.employeeAddressRepo = employeeAddressRepo;
	}

	public EmployeeTO retrieveEmployee(String employeeId) {
		
		Employee employee = employeeRepo.findByEmployeeId(employeeId);
		EmployeeTO employeeTO = null;
		if (employee != null) {
			employeeTO = EmployeeTransformerUtil.transformEmployeeEntity(employee);
		}
		return employeeTO;
	}
	
	public List<EmployeeAddressTO> retrieveEmployeeAddress(String employeeId) {

		List<EmployeeAddress> empAddressList = employeeAddressRepo.findByIdEmployeeId(employeeId);
		List<EmployeeAddressTO> empAddressTOList = new ArrayList<>();
		if (!GeneralUtil.isListEmpty(empAddressList)) {
			for (EmployeeAddress empAddress : empAddressList) {
				EmployeeAddressTO empAddressTO = EmployeeTransformerUtil.transformEmployeeAddress(empAddress);
				empAddressTOList.add(empAddressTO);
			}
		}
		return empAddressTOList;
	}
	
	public boolean updateEmployee(Employee employee) {
		
		if(employee != null) {
			employeeRepo.save(employee);
			return true;
		}
		return false;
	}
	
	public boolean updateEmployeeAddress(EmployeeAddress employeeAddress) {
		
		if (employeeAddress != null) {
			employeeAddressRepo.save(employeeAddress);
			return true;
		}
		return false;
	}
}
