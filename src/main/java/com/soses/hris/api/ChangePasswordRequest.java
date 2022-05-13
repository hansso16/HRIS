package com.soses.hris.api;

import com.soses.hris.api.user.BaseUserRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangePasswordRequest.
 */
public class ChangePasswordRequest extends BaseUserRequest {

	/** The old password. */
	String currentPassword;
	
	/** The password. */
	String password;
	
	/** The password confirmation. */
	String passwordConfirmation;

	/**
	 * Gets the current password.
	 *
	 * @return the current password
	 */
	public String getCurrentPassword() {
		return currentPassword;
	}

	/**
	 * Sets the current password.
	 *
	 * @param currentPassword the new current password
	 */
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ChangePasswordRequest [oldPassword=" + currentPassword + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + "]";
	}
	
 }
