package com.soses.hris.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.EmployeeGeneralSearchResponse;
import com.soses.hris.bo.GeneralEmployeeBO;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.service.EmployeeService;

/**
 * The Class GeneralEmployeeSerivceImpl.
 *
 * @author hso
 * @since 19 Nov 2021
 */
@Service("GeneralEmployeeSerivceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class GeneralEmployeeSerivceImpl implements EmployeeService {

	/** The gen emp bo. */
	private GeneralEmployeeBO genEmpBo;

	/**
	 * Instantiates a new general employee serivce impl.
	 *
	 * @param genEmpBo the gen emp bo
	 */
	@Autowired
	public GeneralEmployeeSerivceImpl(GeneralEmployeeBO genEmpBo) {
		super();
		this.genEmpBo = genEmpBo;
	}

	/**
	 * Gets the employee details.
	 *
	 * @param employeeId the employee id
	 * @return the employee details
	 */
	@Override
	public EmployeeGeneralSearchResponse getEmployeeDetails(String employeeId) {
		
		EmployeeGeneralSearchResponse resp = new EmployeeGeneralSearchResponse();
		EmployeeTO employeeTO = genEmpBo.retrieveEmployee(employeeId);
		if (employeeTO != null) {
			resp.setEmployee(employeeTO);
		} else {
			ErrorPageDTO error = new ErrorPageDTO();
			error.setMessage("Employee ID not found: " + employeeId);
			resp.setError(error);
			return resp;
		}
		
		List<EmployeeAddressTO> empAddressList = genEmpBo.retrieveEmployeeAddress(employeeId);
		if (!GeneralUtil.isListEmpty(empAddressList)) {
			resp.setEmployeeAddressList(empAddressList);
		}
		
		return resp;
	}

}
