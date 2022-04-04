package com.soses.hris.common;

import com.soses.hris.dto.UserTO;
import com.soses.hris.entity.User;

/**
 * The Class UserTransformerUtil.
 *
 * @author hso
 * @since Mar 23, 2022
 */
public class UserTransformerUtil {

	/**
	 * Transform employee dependent entity.
	 *
	 * @param employeeDependent the employee dependent
	 * @return the employee dependent TO
	 */
	public static UserTO transformUserEntity(User user) {
		UserTO userTO = null;
		if (user != null) {
			userTO = new UserTO();
			userTO.setEmployeeId(user.getEmployeeId());
			userTO.setEntryTimestamp(user.getEntryTimestamp());
			userTO.setRole(user.getRole());
			userTO.setTerminationDate(user.getTerminationDate());
			userTO.setUsername(user.getUsername());
		}
		
		return userTO;
	}
}
