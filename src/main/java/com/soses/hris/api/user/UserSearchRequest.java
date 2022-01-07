package com.soses.hris.api.user;

import com.soses.hris.api.BaseSearchRequest;

/**
 * The Class UserSearchRequest.
 *
 * @author hso
 * @since Jan 6, 2022
 */
public class UserSearchRequest extends BaseSearchRequest {

	/** The username. */
	private String username;

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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserSearchRequest [username=" + username + ", toString()=" + super.toString() + "]";
	}
	
}
