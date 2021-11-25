package com.soses.hris.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.EmployeeInfoSearchResponse;
import com.soses.hris.bo.InfoEmployeeBO;
import com.soses.hris.dto.EmployeeDependentTO;
import com.soses.hris.dto.EmployeeInfoTO;
import com.soses.hris.service.EmployeeService;

@Service("InfoEmployeeServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class InfoEmployeeServiceImpl implements EmployeeService  {

	private InfoEmployeeBO employeeInfoBO;

	@Autowired
	public InfoEmployeeServiceImpl(InfoEmployeeBO employeeInfoBO) {
		super();
		this.employeeInfoBO = employeeInfoBO;
	}

	@Override
	public EmployeeInfoSearchResponse getEmployeeDetails(String employeeId) {
		EmployeeInfoSearchResponse resp = new EmployeeInfoSearchResponse();
		EmployeeInfoTO employeeInfoTO = employeeInfoBO.retrieveEmployeeInfo(employeeId);
		if(employeeInfoTO == null) {
			//throw error
		}
		resp.setEmployeeInfo(employeeInfoTO);
		
		List<EmployeeDependentTO> employeeDependentTOList = employeeInfoBO.retrieveEmployeeDependent(employeeId);
		
		resp.setEmployeeDependentList(employeeDependentTOList);

		return resp;
	}


}
