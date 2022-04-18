package com.soses.hris.service.user;

import java.time.LocalDate;

import com.soses.hris.api.user.BaseUserResponse;

/**
 * The Interface UserService.
 *
 * @author hso
 * @since Mar 22, 2022
 */
public interface UserService {

	/**
	 * Gets the user details.
	 *
	 * @param username the username
	 * @return the user details
	 */
	BaseUserResponse getUserDetails(String username);
	
	/**
	 * Terminate user.
	 *
	 * @param terminationDate the termination date
	 * @param username the username
	 * @return true, if successful
	 */
	boolean terminateUser(LocalDate terminationDate, String username);
}
	