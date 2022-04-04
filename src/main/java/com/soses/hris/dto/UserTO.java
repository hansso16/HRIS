package com.soses.hris.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.soses.hris.entity.Role;

/**
 * The Class UserTO.
 *
 * @author hso
 * @since Mar 23, 2022
 */
public class UserTO {

	/** The employee id. */
	private String employeeId;
    
    /** The username. */
    private String username;
    
    /** The password. */
    private String password;
    
    /** The entry timestamp. */
    private LocalDateTime entryTimestamp;
    
    /** The termination date. */
    private LocalDate terminationDate;
    
    /** The role. */
    private Role role;
    
    /** The role list. */
    private List<Role> roleList;

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
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
	 * Gets the termination date.
	 *
	 * @return the termination date
	 */
	public LocalDate getTerminationDate() {
		return terminationDate;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Gets the role list.
	 *
	 * @return the role list
	 */
	public List<Role> getRoleList() {
		return roleList;
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
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * Sets the termination date.
	 *
	 * @param terminationDate the new termination date
	 */
	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Sets the role list.
	 *
	 * @param roleList the new role list
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserTO [employeeId=" + employeeId + ", username=" + username + ", password=" + password
				+ ", entryTimestamp=" + entryTimestamp + ", terminationDate=" + terminationDate + ", role=" + role
				+ ", roleList=" + roleList + "]";
	}
}
