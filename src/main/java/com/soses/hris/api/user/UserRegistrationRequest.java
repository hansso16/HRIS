package com.soses.hris.api.user;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRegistrationRequest.
 */
public class UserRegistrationRequest {

	/** The username. */
	String username;
	
	/** The password. */
	String password;
	
	/** The password confirmation. */
	String passwordConfirmation;
	
	/** The role id. */
	String roleId;
	
	/** The employee id. */
	String employeeId;

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
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
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
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
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
	 * Gets the password confirmation.
	 *
	 * @return the password confirmation
	 */
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	/**
	 * Sets the password confirmation.
	 *
	 * @param passwordConfirmation the new password confirmation
	 */
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserRegistrationRequest [username=" + username + ", password=" + password + ", passwordConfirmation="
				+ passwordConfirmation + ", roleId=" + roleId + ", employeeId=" + employeeId + "]";
	}
	
}
