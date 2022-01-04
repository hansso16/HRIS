package com.soses.hris.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeDependentRequest;
import com.soses.hris.api.EmployeeDependentResponse;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.dto.EmployeeDependentTO;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.entity.EmployeeDependent;
import com.soses.hris.repository.EmployeeDependentRepository;
import com.soses.hris.service.EmployeeDependentService;

@Service("EmployeeDependentServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeDependentServiceImpl implements EmployeeDependentService {

	private EmployeeDependentRepository employeeDependentRepo;
	
	@Autowired
	public EmployeeDependentServiceImpl(EmployeeDependentRepository employeeDependentRepo) {
		super();
		this.employeeDependentRepo = employeeDependentRepo;
	}

	@Override
	public BaseEmployeeResponse getEmployeeDetails(String employeeId) {
		
		EmployeeDependentResponse resp = new EmployeeDependentResponse();
		
		List<EmployeeDependent> empDependentList = employeeDependentRepo.findByIdEmployeeId(employeeId);
		List<EmployeeDependentTO> empDependentTOList = new ArrayList<>();
		if (!GeneralUtil.isListEmpty(empDependentList)) {
			for (EmployeeDependent empDependent : empDependentList) {
				EmployeeDependentTO empDependentTO = EmployeeTransformerUtil.transformEmployeeDependentEntity(empDependent);
				empDependentTOList.add(empDependentTO);
			}
		}
		
		if (!GeneralUtil.isListEmpty(empDependentTOList)) {
			resp.setEmployeeDependentList(empDependentTOList);
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
	public boolean updateEmployeeDetails(EmployeeDependentRequest request) {

		List<EmployeeDependent> employeeDependentList = request.getEmployeeDependent();
		boolean isSaved = false;
		if (!GeneralUtil.isListEmpty(employeeDependentList)) {
			employeeDependentList = employeeDependentRepo.saveAll(employeeDependentList);
			isSaved = true;
		}
		
		return isSaved;
	}

}
