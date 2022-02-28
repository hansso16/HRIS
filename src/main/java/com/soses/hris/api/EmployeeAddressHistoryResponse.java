package com.soses.hris.api;

import java.util.List;

import com.soses.hris.dto.EmployeeAddressHistoryTO;

/**
 * The Class EmployeeAddressHistoryResponse.
 *
 * @author hso
 * @since Feb 28, 2022
 */
public class EmployeeAddressHistoryResponse extends BaseEmployeeSearchResponse {

	/** The employee address list. */
	private List<EmployeeAddressHistoryTO> employeeAddressList;

	/**
	 * Gets the employee address list.
	 *
	 * @return the employee address list
	 */
	public List<EmployeeAddressHistoryTO> getEmployeeAddressList() {
		return employeeAddressList;
	}

	/**
	 * Sets the employee address list.
	 *
	 * @param employeeAddressList the new employee address list
	 */
	public void setEmployeeAddressList(List<EmployeeAddressHistoryTO> employeeAddressList) {
		this.employeeAddressList = employeeAddressList;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeAddressHistoryResponse [employeeAddressList=" + employeeAddressList + "]";
	}
	
}
