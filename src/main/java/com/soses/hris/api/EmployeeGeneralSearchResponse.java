package com.soses.hris.api;

import java.util.List;

import com.soses.hris.dto.EmployeeAddressTO;
import com.soses.hris.dto.EmployeeTO;

/**
 * The Class EmployeeGeneralSearchResponse.
 *
 * @author hso
 * @since 19 Nov 2021
 */
public class EmployeeGeneralSearchResponse extends BaseEmployeeSearchResponse {

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

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeGeneralSearchResponse [employee=" + employee + ", employeeAddressList=" + employeeAddressList
				+ "]";
	}
	
}
