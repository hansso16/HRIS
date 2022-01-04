package com.soses.hris.api;

import java.util.List;

import com.soses.hris.dto.EmployeeDependentTO;

/**
 * The Class EmployeeDependentResponse.
 *
 * @author hso
 * @since Jan 4, 2022
 */
public class EmployeeDependentResponse extends BaseEmployeeSearchResponse {

	/** The employee dependent list. */
	private List<EmployeeDependentTO> employeeDependentList;

	/**
	 * Gets the employee dependent list.
	 *
	 * @return the employee dependent list
	 */
	public List<EmployeeDependentTO> getEmployeeDependentList() {
		return employeeDependentList;
	}

	/**
	 * Sets the employee dependent list.
	 *
	 * @param employeeDependentList the new employee dependent list
	 */
	public void setEmployeeDependentList(List<EmployeeDependentTO> employeeDependentList) {
		this.employeeDependentList = employeeDependentList;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeDependentResponse [employeeDependentList=" + employeeDependentList + ", toString()="
				+ super.toString() + "]";
	}
	
}
