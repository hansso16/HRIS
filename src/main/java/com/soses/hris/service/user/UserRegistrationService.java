package com.soses.hris.service.user;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.soses.hris.api.user.UserRegistrationRequest;
import com.soses.hris.api.user.UserRegistrationResponse;
import com.soses.hris.cache.role.RoleAccessor;
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.entity.Employee;
import com.soses.hris.entity.Role;
import com.soses.hris.entity.User;
import com.soses.hris.repository.EmployeeRepository;
import com.soses.hris.repository.UserRepository;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class UserRegistrationService {

	private UserRepository userRepo;
	
	private RoleAccessor roleAccessor;
	
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public UserRegistrationService(UserRepository userRepo, RoleAccessor roleAccessor, EmployeeRepository employeeRepo) {
		super();
		this.userRepo = userRepo;
		this.roleAccessor = roleAccessor;
		this.employeeRepo = employeeRepo;
	}


	public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
		if (request == null) {return null; }
		
		UserRegistrationResponse response = new UserRegistrationResponse();
		User user = new User();
		String password = request.getPassword().trim();
		String passwordConfirmation = request.getPasswordConfirmation().trim();
		String username = request.getUsername();
		String strRoleId = request.getRoleId();
		int roleId = Integer.parseInt(strRoleId);
		Role role = roleAccessor.getRole(roleId);
		String employeeId = request.getEmployeeId();
		response.setEmployeeId(employeeId);
		Employee employee = employeeRepo.findByEmployeeId(employeeId);
		
		if (!StringUtil.isEmpty(username) && !StringUtil.isEmpty(employeeId)) {
			if (userRepo.existsById(username)) {
				ErrorPageDTO error = new ErrorPageDTO();
				error.setMessage("Username already exists.");
				response.setError(error);
				return response;
			}
			if (employee == null) {
				ErrorPageDTO error = new ErrorPageDTO();
				error.setMessage("Invalid Employee ID.");
				response.setError(error);
				return response;
			}
			if (userRepo.existsByEmployee(employee)) {
				ErrorPageDTO error = new ErrorPageDTO();
				error.setMessage("Employee is already a registered user.");
				response.setError(error);
				return response;
			}
			if (!StringUtil.isEmpty(passwordConfirmation) && !StringUtil.isEmpty(password)
					&& !password.equals(passwordConfirmation)) {
				ErrorPageDTO error = new ErrorPageDTO();
				error.setMessage("The password you entered does not match.");
				response.setError(error);
				return response;
			}
			if (role == null) {
				ErrorPageDTO error = new ErrorPageDTO();
				error.setMessage("Invalid Access Level");
				response.setError(error);
				return response;
			}
			
			// hash password
			String hashPassword = new BCryptPasswordEncoder().encode(password);
			user.setPassword(hashPassword);
			user.setUsername(username);
			user.setEmployee(employee);
			user.setRole(role);
			user.setEntryTimestamp(LocalDateTime.now());
			userRepo.save(user);
			response.setUsername(username);
			response.setResponseMessage("User successfully registered");
		}

		return response;
	}
}
