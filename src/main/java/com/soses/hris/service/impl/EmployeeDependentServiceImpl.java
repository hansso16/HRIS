package com.soses.hris.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeDependentRequest;
import com.soses.hris.api.EmployeeDependentResponse;
import com.soses.hris.common.ActivityHistoryConstants;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.EmployeeDependentTO;
import com.soses.hris.entity.ActivityHistory;
import com.soses.hris.entity.EmployeeDependent;
import com.soses.hris.entity.EmployeeDependentPK;
import com.soses.hris.repository.EmployeeDependentRepository;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.ActivityHistoryService;
import com.soses.hris.service.EmployeeDependentService;

/**
 * The Class EmployeeDependentServiceImpl.
 *
 * @author hso
 * @since Mar 10, 2022
 */
@Service("EmployeeDependentServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeDependentServiceImpl implements EmployeeDependentService {

	/** The employee dependent repo. */
	private EmployeeDependentRepository employeeDependentRepo;
	
	/** The employee repo. */
	private EmployeeRepository employeeRepo;
	
	/** The activity history service. */
	private ActivityHistoryService activityHistoryService;
	
	/**
	 * Instantiates a new employee dependent service impl.
	 *
	 * @param employeeDependentRepo the employee dependent repo
	 * @param employeeRepo the employee repo
	 * @param activityHistoryService the activity history service
	 */
	@Autowired
	public EmployeeDependentServiceImpl(EmployeeDependentRepository employeeDependentRepo, EmployeeRepository employeeRepo
			, ActivityHistoryService activityHistoryService) {
		super();
		this.employeeDependentRepo = employeeDependentRepo;
		this.employeeRepo = employeeRepo;
		this.activityHistoryService = activityHistoryService;
	}

	/**
	 * Gets the employee details.
	 *
	 * @param employeeId the employee id
	 * @return the employee details
	 */
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

	/**
	 * Update employee details.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
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

	/**
	 * Delete employee dependent.
	 *
	 * @param employeeId the employee id
	 * @param dependentId the dependent id
	 * @return true, if successful
	 */
	@Override
	public boolean deleteEmployeeDependent(String employeeId, short dependentId) {
		
		boolean isDeleted = false;
		if (!StringUtils.isEmpty(employeeId) && dependentId >= 0) {
			EmployeeDependentPK employeeDependentPK = new EmployeeDependentPK();
			employeeDependentPK.setDependentId(dependentId);
			employeeDependentPK.setEmployeeId(employeeId);
			employeeDependentRepo.deleteById(employeeDependentPK);
			
			ActivityHistory activityHistory = new ActivityHistory();
			activityHistory.setEmployeeId(employeeId);
			activityHistory.setActivityText(ActivityHistoryConstants.DELETE_EMPLOYEE_DEPENDENT);
			activityHistory.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			activityHistory.setEntryTimestamp(LocalDateTime.now());
			activityHistoryService.saveActivity(activityHistory);
			
			isDeleted = true;
		}
		
		return isDeleted;
	}

	/**
	 * Adds the employee dependents.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	@Override
	public boolean addEmployeeDependents(EmployeeDependentRequest request) {
		
		boolean isSaved = false;
		String employeeId = request.getEmployeeId();
		if (request != null && !StringUtil.isEmpty(employeeId)) {
			List<EmployeeDependent> employeeDependentList = request.getEmployeeDependent();
			int requestListSize = employeeDependentList.size();
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
				
				ActivityHistory activityHistory = new ActivityHistory();
				activityHistory.setEmployeeId(employeeId);
				activityHistory.setActivityText(++requestListSize + ActivityHistoryConstants.ADD_EMPLOYEE_DEPENDENT);
				activityHistory.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
				activityHistory.setEntryTimestamp(LocalDateTime.now());
				activityHistoryService.saveActivity(activityHistory);
				
				isSaved = true;
			}
		}
		
		return isSaved;
	}

	/**
	 * Update employee details.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	@Override
	public boolean updateEmployeeDetails(BaseEmployeeRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

}
