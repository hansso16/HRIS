package com.soses.hris.api;

import java.util.List;

import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.dto.EmployeeTO;

/**
 * The Class EmployeeSearchResponse.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class EmployeeSearchResponse extends BaseEmployeeSearchResponse {

	/** The employee. */
	private EmployeeTO employee;
	
	/** The employee address list. */
	private List<EmployeeAddressTO> employeeAddressList;
	
	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public EmployeeTO getEmployee() {
		return employee;
	}
	
	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(EmployeeTO employee) {
		this.employee = employee;
	}
	
	/**
	 * Gets the employee address list.
	 *
	 * @return the employee address list
	 */
	public List<EmployeeAddressTO> getEmployeeAddressList() {
		return employeeAddressList;
	}
	
	/**
	 * Sets the employee address list.
	 *
	 * @param employeeAddressList the new employee address list
	 */
	public void setEmployeeAddressList(List<EmployeeAddressTO> employeeAddressList) {
		this.employeeAddressList = employeeAddressList;
	}
}
