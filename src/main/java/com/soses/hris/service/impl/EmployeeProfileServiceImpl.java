package com.soses.hris.service.impl;


import java.io.IOException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeProfileRequest;
import com.soses.hris.api.EmployeeProfileResponse;
import com.soses.hris.bo.EmployeeBO;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.FlatFileService;
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.entity.Employee;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.service.EmployeeProfileService;

// TODO: Auto-generated Javadoc
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

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(EmployeeProfileServiceImpl.class);
	
	/** The employee BO. */
	private EmployeeBO employeeBO;
	
	/** The employee repo. */
	private EmployeeRepository employeeRepo;
	
	/** The flat file service. */
	private FlatFileService flatFileService;
	
	/**
	 * Instantiates a new employee profile service impl.
	 *
	 * @param employeeBO the employee BO
	 * @param employeeRepo the employee repo
	 * @param flatFileService the flat file service
	 */
	@Autowired
	public EmployeeProfileServiceImpl(EmployeeBO employeeBO, EmployeeRepository employeeRepo
			, FlatFileService flatFileService) {
		super();
		this.employeeBO = employeeBO;
		this.employeeRepo = employeeRepo;
		this.flatFileService = flatFileService;
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
			
			// Upload photo
			String fileName = null;
			MultipartFile file = request.getFile();
			if (file != null && !StringUtil.isEmpty(file.getOriginalFilename())) {
				try {
					fileName = flatFileService.uploadEmployeePhoto(file, employeeId);
					employee.setPhoto(fileName);
				} catch (IOException e) {
					e.printStackTrace();
					log.error(e.getMessage());
				}
			}
			
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
