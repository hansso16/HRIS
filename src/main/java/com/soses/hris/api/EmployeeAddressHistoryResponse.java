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
	private List<EmployeeAddressHistoryTO> employeeAddressHistoryList;

	/**
	 * Gets the employee address history list.
	 *
	 * @return the employee address history list
	 */
	public List<EmployeeAddressHistoryTO> getEmployeeAddressHistoryList() {
		return employeeAddressHistoryList;
	}

	/**
	 * Sets the employee address history list.
	 *
	 * @param employeeAddressHistoryList the new employee address history list
	 */
	public void setEmployeeAddressHistoryList(List<EmployeeAddressHistoryTO> employeeAddressHistoryList) {
		this.employeeAddressHistoryList = employeeAddressHistoryList;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeAddressHistoryResponse [employeeAddressHistoryList=" + employeeAddressHistoryList + "]";
	}
	
}
