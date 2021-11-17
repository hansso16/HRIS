package com.soses.hris.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.EmployeeSearchResponse;
import com.soses.hris.bo.GeneralEmployeeBO;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.entity.Employee;
import com.soses.hris.service.EmployeeService;

@Service("GeneralEmployeeSerivceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GeneralEmployeeSerivceImpl implements EmployeeService {

	@Autowired
	private GeneralEmployeeBO genEmpBo;
	
	@Override
	public Employee findEmployeeById(int employeeId) {
		return null;
	}

	@Override
	public EmployeeSearchResponse getEmployeeDetails(int employeeId) {
		
		EmployeeSearchResponse resp = new EmployeeSearchResponse();
		EmployeeTO employeeTO = genEmpBo.retrieveEmployeeDetails(employeeId);
		if (employeeTO != null) {
			resp.setEmployee(employeeTO);
		}
		
		List<EmployeeAddressTO> empAddressList = genEmpBo.retrieveEmployeeAddress(employeeId);
		if (!GeneralUtil.isListEmpty(empAddressList)) {
			resp.setEmployeeAddressList(empAddressList);
		}
		
		return resp;
	}

}
