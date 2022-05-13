package com.soses.hris.api.user;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateAccessRequest.
 */
public class UpdateAccessRequest extends BaseUserRequest {

	/** The role id. */
	String role;

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UpdateAccessRequest [role=" + role + "]";
	}
	
}
