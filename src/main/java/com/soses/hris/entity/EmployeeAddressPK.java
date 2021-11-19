package com.soses.hris.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class EmployeeAddressPK.
 *
 * @author hso
 * @since 19 Nov 2021
 */
@Embeddable
public class EmployeeAddressPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7286351108679372094L;

	/** The employee id. */
	@Column(name="EMPLOYEE_ID")
	private String employeeId;

	/** The address type. */
	@Column(name="ADDRESS_TYPE")
	private String addressType;

	/**
	 * Instantiates a new employee address PK.
	 */
	public EmployeeAddressPK() {
		super();
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the address type.
	 *
	 * @return the address type
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * Sets the address type.
	 *
	 * @param addressType the new address type
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(addressType, employeeId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeAddressPK other = (EmployeeAddressPK) obj;
		return Objects.equals(addressType, other.addressType) && employeeId == other.employeeId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeAddressPK [employeeId=" + employeeId + ", addressType=" + addressType + "]";
	}
	
	
}
