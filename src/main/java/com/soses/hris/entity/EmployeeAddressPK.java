package com.soses.hris.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeAddressPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7286351108679372094L;

	@Column(name="EMPLOYEE_ID")
	private int employeeId;

	@Column(name="ADDRESS_TYPE")
	private String addressType;

	public EmployeeAddressPK() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressType, employeeId);
	}

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
	
	
}
