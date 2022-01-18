package com.soses.hris.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeDependentRequest;
import com.soses.hris.api.EmployeeDependentResponse;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.EmployeeDependentTO;
import com.soses.hris.entity.EmployeeDependent;
import com.soses.hris.entity.EmployeeDependentPK;
import com.soses.hris.repository.EmployeeDependentRepository;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.EmployeeDependentService;

@Service("EmployeeDependentServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeDependentServiceImpl implements EmployeeDependentService {

	private EmployeeDependentRepository employeeDependentRepo;
	
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeDependentServiceImpl(EmployeeDependentRepository employeeDependentRepo, EmployeeRepository employeeRepo) {
		super();
		this.employeeDependentRepo = employeeDependentRepo;
		this.employeeRepo = employeeRepo;
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
		} else {
			if (!employeeRepo.existsById(employeeId)) {
				// error
			}
		}
		
		resp.setEmployeeDependentList(empDependentTOList);
		return resp;
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

	@Override
	public boolean deleteEmployeeDependent(String employeeId, short dependentId) {
		
		boolean isDeleted = false;
		if (!StringUtils.isEmpty(employeeId) && dependentId >= 0) {
			EmployeeDependentPK employeeDependentPK = new EmployeeDependentPK();
			employeeDependentPK.setDependentId(dependentId);
			employeeDependentPK.setEmployeeId(employeeId);
			employeeDependentRepo.deleteById(employeeDependentPK);
			isDeleted = true;
		}
		
		return isDeleted;
	}

	@Override
	public boolean addEmployeeDependents(EmployeeDependentRequest request) {
		
		boolean isSaved = false;
		if (request != null) {
			List<EmployeeDependent> employeeDependentList = request.getEmployeeDependent();
			if (!GeneralUtil.isListEmpty(employeeDependentList)) {
				List<EmployeeDependent> employeeDependentEntityList = new ArrayList<>();
				short maxDependentId = employeeDependentRepo.getMaxDependentIdByEmployee(request.getEmployeeId());
				for (EmployeeDependent employeeDependent : employeeDependentList) {
					if (employeeDependent != null && !StringUtil.isEmpty(employeeDependent.getDependentName())
							&& employeeDependent.getId() != null && !StringUtil.isEmpty(employeeDependent.getId().getEmployeeId())) {
						employeeDependent.getId().setDependentId(++maxDependentId);
						employeeDependentEntityList.add(employeeDependent);
					}
				}
				employeeDependentEntityList = employeeDependentRepo.saveAll(employeeDependentEntityList);
				isSaved = true;
			}
		}
		
		return isSaved;
	}

	@Override
	public boolean updateEmployeeDetails(BaseEmployeeRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
