package com.soses.hris.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.entity.Employee;
import com.soses.hris.repository.EmployeeRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeBO {

	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeBO(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	public EmployeeTO retrieveEmployee(String employeeId) {
		
		Employee employee = employeeRepo.findByEmployeeId(employeeId);
		EmployeeTO employeeTO = null;
		if (employee != null) {
			employeeTO = EmployeeTransformerUtil.transformEmployeeEntity(employee);
		}
		return employeeTO;
	}
}
