package com.soses.hris.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.EmployeeSearchResponse;
import com.soses.hris.bo.SearchEmployeeBO;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.service.EmployeeService;

@Service("EmployeeSearchServiceImpl")
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeSearchServiceImpl implements EmployeeService {

	private SearchEmployeeBO searchEmpBo;
	
	@Autowired
	public void setGenEmpBo(SearchEmployeeBO searchEmpBo) {
		this.searchEmpBo = searchEmpBo;
	}

	@Override
	public EmployeeSearchResponse getEmployeeDetails(String employeeId) {
		
		EmployeeSearchResponse resp = new EmployeeSearchResponse();
		List<EmployeeTO> employeeTOList = searchEmpBo.searchEmployeeDetailsById(employeeId);
		if (!GeneralUtil.isListEmpty(employeeTOList)) {
			resp.setEmployeeList(employeeTOList);
		} else {
			ErrorPageDTO error = new ErrorPageDTO();
			error.setMessage("Employee ID not found: " + employeeId);
			resp.setError(error);
		}
		return resp;
	}

}
