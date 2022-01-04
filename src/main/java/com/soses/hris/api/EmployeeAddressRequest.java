package com.soses.hris.api;

import java.util.List;

import com.soses.hris.entity.EmployeeAddress;

/**
 * The Class EmployeeAddressRequest.
 *
 * @author hso
 * @since Jan 4, 2022
 */
public class EmployeeAddressRequest extends BaseEmployeeRequest {

	/** The employee address. */
	private List<EmployeeAddress> employeeAddress;

	/**
	 * Gets the employee address.
	 *
	 * @return the employee address
	 */
	public List<EmployeeAddress> getEmployeeAddress() {
		return employeeAddress;
	}

	/**
	 * Sets the employee address.
	 *
	 * @param employeeAddress the new employee address
	 */
	public void setEmployeeAddress(List<EmployeeAddress> employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeAddressRequest [employeeAddress=" + employeeAddress + ", toString()=" + super.toString() + "]";
	}

	
}
