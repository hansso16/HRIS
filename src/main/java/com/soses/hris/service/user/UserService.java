package com.soses.hris.service.user;

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
	 * @return the user details
	 */
	BaseUserResponse getUserDetails(String username);
}
