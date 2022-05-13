package com.soses.hris.service.user;

import java.security.Principal;
import java.time.LocalDate;

import com.soses.hris.api.ChangePasswordRequest;
import com.soses.hris.api.user.BaseUserResponse;
import com.soses.hris.api.user.UpdateAccessRequest;

// TODO: Auto-generated Javadoc
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
	BaseUserResponse getUserDetails(String username, Principal principal);
	
	/**
	 * Terminate user.
	 *
	 * @param terminationDate the termination date
	 * @param username the username
	 * @return true, if successful
	 */
	boolean terminateUser(LocalDate terminationDate, String username);
	
	/**
	 * Change password.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	boolean changePassword(ChangePasswordRequest request);
	
	/**
	 * Update access.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	boolean updateAccess(UpdateAccessRequest request);
}
	