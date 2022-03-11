package com.soses.hris.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.soses.hris.api.AddEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.common.ActivityHistoryConstants;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.controller.EmployeeRegistrationController;
import com.soses.hris.entity.ActivityHistory;
import com.soses.hris.entity.Employee;
import com.soses.hris.entity.EmployeeAddress;
import com.soses.hris.entity.EmployeeBenefits;
import com.soses.hris.entity.EmployeeDependent;
import com.soses.hris.entity.EmployeeDependentPK;
import com.soses.hris.entity.EmployeeInfo;
import com.soses.hris.repository.EmployeeAddressRepository;
import com.soses.hris.repository.EmployeeBenefitsRepository;
import com.soses.hris.repository.EmployeeDependentRepository;
import com.soses.hris.repository.EmployeeInfoRepository;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.ActivityHistoryService;
import com.soses.hris.service.EmployeeRegistrationService;

/**
 * The Class EmployeeRegistrationServiceImpl.
 *
 * @author hso
 * @since Dec 21, 2021
 */
@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(EmployeeRegistrationController.class);

	/** The employee repository. */
	private EmployeeRepository employeeRepository;
	
	/** The employee address repository. */
	private EmployeeAddressRepository employeeAddressRepository;
	
	/** The employee info repository. */
	private EmployeeInfoRepository employeeInfoRepository;
	
	/** The employee dependent repository. */
	private EmployeeDependentRepository employeeDependentRepository;
	
	/** The employee benefits repository. */
	private EmployeeBenefitsRepository employeeBenefitsRepository;
	
	private ActivityHistoryService activityHistoryService;

	/**
	 * Instantiates a new employee registration service impl.
	 *
	 * @param employeeRepository the employee repository
	 * @param employeeAddressRepository the employee address repository
	 * @param employeeInfoRepository the employee info repository
	 * @param employeeDependentRepository the employee dependent repository
	 * @param employeeBenefitsRepository the employee benefits repository
	 */
	@Autowired
	public EmployeeRegistrationServiceImpl(EmployeeRepository employeeRepository,
			EmployeeAddressRepository employeeAddressRepository, EmployeeInfoRepository employeeInfoRepository,
			EmployeeDependentRepository employeeDependentRepository,
			EmployeeBenefitsRepository employeeBenefitsRepository, ActivityHistoryService activityHistoryService) {
		super();
		this.employeeRepository = employeeRepository;
		this.employeeAddressRepository = employeeAddressRepository;
		this.employeeInfoRepository = employeeInfoRepository;
		this.employeeDependentRepository = employeeDependentRepository;
		this.employeeBenefitsRepository = employeeBenefitsRepository;
		this.activityHistoryService = activityHistoryService;
	}



	/**
	 * Register employee.
	 *
	 * @param request the request
	 * @return the base employee response
	 */
	@Override
	public BaseEmployeeResponse registerEmployee(AddEmployeeRequest request) {

		BaseEmployeeResponse response = new BaseEmployeeResponse();
		String employeeId = employeeRepository.getNextEmployeeId().toString();
		log.info("EmployeeId: " + employeeId);
		
		// Employee
		Employee employee = request.getEmployee();
		if (employee == null) {
			//throw error
		}
		employee.setEmployeeId(employeeId);
		employee.setEntryTimestamp(LocalDateTime.now());
		employee = employeeRepository.save(employee);
		
		//permanent address
		List<EmployeeAddress> empAddressList = request.getEmployeeAddress();
		if (!GeneralUtil.isListEmpty(empAddressList)) {
			for (EmployeeAddress empAddress : empAddressList) {
				if (empAddress != null && empAddress.getId() != null) {
					empAddress.getId().setEmployeeId(employeeId);
				}
			}
			empAddressList = employeeAddressRepository.saveAll(empAddressList);
		}
		
		//employee info
		EmployeeInfo employeeInfo = request.getEmployeeInfo();
		if (employeeInfo != null) {
			employeeInfo.setEmployeeId(employeeId);
			employeeInfo = employeeInfoRepository.save(employeeInfo);
		}
		
		//employee dependents
		List<EmployeeDependent> empDependentList = request.getEmployeeDependent();
		if (!GeneralUtil.isListEmpty(empDependentList)) {
			short dependentId = 0;
			for (EmployeeDependent empDependent : empDependentList) {
				if (empDependent != null) {
					EmployeeDependentPK empDependentPK = empDependent.getId();
					if (empDependentPK == null) {
						empDependentPK = new EmployeeDependentPK();
					}
					empDependentPK.setEmployeeId(employeeId);
					empDependentPK.setDependentId(++dependentId);
					empDependent.setId(empDependentPK);
				}
			}
			employeeDependentRepository.saveAll(empDependentList);
		}
		
		//employee benefits
		EmployeeBenefits employeeBenefits = request.getEmployeeBenefits();
		if (employeeBenefits != null) {
			employeeBenefits.setEmployeeId(employeeId);
			employeeBenefits = employeeBenefitsRepository.save(employeeBenefits);
		}
		
		ActivityHistory activityHistory = new ActivityHistory();
		activityHistory.setEmployeeId(employeeId);
		activityHistory.setActivityText(ActivityHistoryConstants.EMPLOYEE_REGISTER);
		activityHistory.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		activityHistory.setEntryTimestamp(LocalDateTime.now());
		activityHistoryService.saveActivity(activityHistory);
		
		response.setEmployeeId(String.valueOf(employeeId));
		return response;
	}

}
