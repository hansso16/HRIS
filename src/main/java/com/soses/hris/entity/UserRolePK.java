package com.soses.hris.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class UserRolePK.
 *
 * @author hso
 * @since 11 Nov 2021
 */
@Embeddable
public class UserRolePK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 17914362951231227L;

	/** The employee id. */
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	
	/** The role id. */
	@Column(name="ROLE_ID")
	private int roleId;
	
	/**
	 * Instantiates a new user role PK.
	 */
	public UserRolePK() { }

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserRolePK [employeeId=" + employeeId + ", roleId=" + roleId + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(employeeId, roleId);
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
		UserRolePK other = (UserRolePK) obj;
		return employeeId == other.employeeId && roleId == other.roleId;
	}
	
	
}
