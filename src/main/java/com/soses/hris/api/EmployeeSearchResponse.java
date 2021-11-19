package com.soses.hris.api;

import java.util.List;

import com.soses.hris.dto.EmployeeTO;

/**
 * The Class EmployeeSearchResponse.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class EmployeeSearchResponse extends BaseEmployeeSearchResponse {

	/** The employee. */
	private List<EmployeeTO> employeeList;

	/**
	 * Gets the employee list.
	 *
	 * @return the employee list
	 */
	public List<EmployeeTO> getEmployeeList() {
		return employeeList;
	}

	/**
	 * Sets the employee list.
	 *
	 * @param employeeList the new employee list
	 */
	public void setEmployeeList(List<EmployeeTO> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "EmployeeSearchResponse [employeeList=" + employeeList + "]";
	}
}
