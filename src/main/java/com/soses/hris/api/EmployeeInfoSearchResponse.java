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
	private List<EmployeeDependentTO> employeeDependentList;
	
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
		return "EmployeeInfoSearchResponse [employeeInfo=" + employeeInfo + ", employeeDependentList="
				+ employeeDependentList + "]";
	}
	
}
