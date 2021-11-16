package com.soses.hris.api;

import java.util.List;

import com.soses.hris.dto.EmployeeDependentTO;
import com.soses.hris.dto.EmployeeInfoTO;

/**
 * The Class EmployeeBenefitsSearchResponse.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class EmployeeInfoSearchResponse extends BaseEmployeeSearchResponse {

	/** The employee info. */
	private EmployeeInfoTO employeeInfo;
	
	/** The employee dependent. */
	private List<EmployeeDependentTO> employeeDependent;
	
	/**
	 * Gets the employee info.
	 *
	 * @return the employee info
	 */
	public EmployeeInfoTO getEmployeeInfo() {
		return employeeInfo;
	}
	
	/**
	 * Sets the employee info.
	 *
	 * @param employeeInfo the new employee info
	 */
	public void setEmployeeInfo(EmployeeInfoTO employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
	
	/**
	 * Gets the employee dependent.
	 *
	 * @return the employee dependent
	 */
	public List<EmployeeDependentTO> getEmployeeDependent() {
		return employeeDependent;
	}
	
	/**
	 * Sets the employee dependent.
	 *
	 * @param employeeDependent the new employee dependent
	 */
	public void setEmployeeDependent(List<EmployeeDependentTO> employeeDependent) {
		this.employeeDependent = employeeDependent;
	}

	
}
