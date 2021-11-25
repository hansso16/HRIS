package com.soses.hris.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class EmployeeDependentPK.
 *
 * @author hso
 * @since 11 Nov 2021
 */
@Embeddable
public class EmployeeDependentPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1200717229413068351L;

	/** The employee id. */
	@Column(name="EMPLOYEE_ID")
	private String employeeId;
	
	/** The dependent id. */
	@Column(name="DEPENDENT_ID")
	private short dependentId;
	
	/**
	 * Instantiates a new employee dependent PK.
	 */
	public EmployeeDependentPK() { }

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
	 * Gets the dependent id.
	 *
	 * @return the dependent id
	 */
	public short getDependentId() {
		return dependentId;
	}

	/**
	 * Sets the dependent id.
	 *
	 * @param dependentId the new dependent id
	 */
	public void setDependentId(short dependentId) {
		this.dependentId = dependentId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeDependentPK [employeeId=" + employeeId + ", dependentId=" + dependentId + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dependentId, employeeId);
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
		EmployeeDependentPK other = (EmployeeDependentPK) obj;
		return dependentId == other.dependentId && employeeId == other.employeeId;
	}
	
}
