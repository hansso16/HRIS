package com.soses.hris.api;

import java.util.List;

import com.soses.hris.dto.EmployeeAddressTO;

/**
 * The Class EmployeeAddressResponse.
 *
 * @author hso
 * @since Jan 4, 2022
 */
public class EmployeeAddressResponse extends BaseEmployeeSearchResponse {

	/** The employee address list. */
	private List<EmployeeAddressTO> employeeAddressList;

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
		return "EmployeeAddressResponse [employeeAddressList=" + employeeAddressList + "]";
	}
	
}
