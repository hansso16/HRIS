package com.soses.hris.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeProfileRequest;
import com.soses.hris.api.EmployeeProfileResponse;
import com.soses.hris.bo.EmployeeBO;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.entity.Employee;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.EmployeeProfileService;

/**
 * The Class EmployeeProfileServiceImpl.
 *
 * @author hso
 * @since Mar 17, 2022
 */
@Service("EmployeeProfileServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

	/** The employee BO. */
	private EmployeeBO employeeBO;
	
	/** The employee repo. */
	private EmployeeRepository employeeRepo;
	
	/**
	 * Instantiates a new employee profile service impl.
	 *
	 * @param employeeBO the employee BO
	 * @param employeeRepo the employee repo
	 */
	@Autowired
	public EmployeeProfileServiceImpl(EmployeeBO employeeBO, EmployeeRepository employeeRepo) {
		super();
		this.employeeBO = employeeBO;
		this.employeeRepo = employeeRepo;
	}

	/**
	 * Gets the employee details.
	 *
	 * @param employeeId the employee id
	 * @return the employee details
	 */
	@Override
	public BaseEmployeeResponse getEmployeeDetails(String employeeId) {

		EmployeeProfileResponse resp = new EmployeeProfileResponse();
		EmployeeTO employeeTO = employeeBO.retrieveEmployee(employeeId);
		if (employeeTO == null) {
			ErrorPageDTO error = new ErrorPageDTO();
			error.setMessage("Employee ID not found: " + employeeId);
			resp.setError(error);
			return resp;
		}
		
		resp.setEmployee(employeeTO);
		return resp;
	}

	/**
	 * Update employee details.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	@Override
	public boolean updateEmployeeDetails(EmployeeProfileRequest request) {
		
		String employeeId = request.getEmployeeId();
		boolean isSuccess = false;
		if (request != null) {
			Employee employee = EmployeeTransformerUtil.transformEmployeeProfileRequest(request);
			employee.setEmployeeId(employeeId);
			employeeRepo.save(employee);
			
			isSuccess=true;
		}
		return isSuccess;
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
