package com.soses.hris.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
public class EmployeeAddressHistoryPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7286351108679372094L;

	/** The employee id. */
	@Column(name="EMPLOYEE_ID")
	private String employeeId;

	/** The address type. */
	@Column(name="ADDRESS_TYPE")
	private String addressType;
	
	/** The entry timestamp. */
	@Column(name="ENTRY_TIMESTAMP")
	private LocalDateTime entryTimestamp;

	/**
	 * Instantiates a new employee address PK.
	 */
	public EmployeeAddressHistoryPK() {
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
	 * Gets the address type.
	 *
	 * @return the address type
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * Gets the entry timestamp.
	 *
	 * @return the entry timestamp
	 */
	public LocalDateTime getEntryTimestamp() {
		return entryTimestamp;
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
	 * Sets the address type.
	 *
	 * @param addressType the new address type
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * Sets the entry timestamp.
	 *
	 * @param entryTimestamp the new entry timestamp
	 */
	public void setEntryTimestamp(LocalDateTime entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeAddressPK [employeeId=" + employeeId + ", addressType=" + addressType + ", entryTimestamp="
				+ entryTimestamp + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(addressType, employeeId, entryTimestamp);
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
		EmployeeAddressHistoryPK other = (EmployeeAddressHistoryPK) obj;
		return Objects.equals(addressType, other.addressType) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(entryTimestamp, other.entryTimestamp);
	}
}
