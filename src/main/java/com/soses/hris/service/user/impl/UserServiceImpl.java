package com.soses.hris.service.user.impl;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.soses.hris.api.ChangePasswordRequest;
import com.soses.hris.api.user.BaseUserResponse;
import com.soses.hris.api.user.UpdateAccessRequest;
import com.soses.hris.api.user.UserResponse;
import com.soses.hris.cache.company.CompanyCacheAccessor;
import com.soses.hris.cache.division.DivisionAccessor;
import com.soses.hris.cache.position.PositionAccessor;
import com.soses.hris.cache.role.RoleAccessor;
import com.soses.hris.cache.role.RoleCacheService;
import com.soses.hris.common.EmployeeTransformerUtil;
import com.soses.hris.common.StringUtil;
import com.soses.hris.common.UserTransformerUtil;
import com.soses.hris.dto.EmployeeTO;
import com.soses.hris.dto.UserTO;
import com.soses.hris.entity.Company;
import com.soses.hris.entity.Division;
import com.soses.hris.entity.Employee;
import com.soses.hris.entity.Position;
import com.soses.hris.entity.Role;
import com.soses.hris.entity.User;
import com.soses.hris.repository.UserRepository;
import com.soses.hris.service.user.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 *
 * @author hso
 * @since Mar 22, 2022
 */
@Service("UserServiceImpl")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class UserServiceImpl implements UserService {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/** The user repo. */
	private UserRepository userRepo;
	
	/** The company cache. */
	private CompanyCacheAccessor companyCache;
	
	/** The division cache. */
	private DivisionAccessor divisionCache;
	
	/** The position cache. */
	private PositionAccessor positionCache;
	
	/** The role cache. */
	private RoleCacheService roleCache;
	
	/** The role accessor. */
	private RoleAccessor roleAccessor;
	
	/**
	 * Instantiates a new user service impl.
	 *
	 * @param userRepo the user repo
	 * @param companyCache the company cache
	 * @param divisionCache the division cache
	 * @param positionCache the position cache
	 * @param roleCache the role cache
	 * @param roleAccessor the role accessor
	 */
	@Autowired
	public UserServiceImpl(UserRepository userRepo, CompanyCacheAccessor companyCache
			, DivisionAccessor divisionCache, PositionAccessor positionCache
			, RoleCacheService roleCache, RoleAccessor roleAccessor) {
		super();
		this.userRepo = userRepo;
		this.companyCache = companyCache;
		this.positionCache = positionCache;
		this.divisionCache = divisionCache;
		this.roleCache = roleCache;
		this.roleAccessor = roleAccessor;
	}


	/**
	 * Gets the user details.
	 *
	 * @param username the username
	 * @param principal the principal
	 * @return the user details
	 */
	@Override
	public BaseUserResponse getUserDetails(String username, Principal principal) {
		if (StringUtil.isEmpty(username)) {
			log.error("Username is null/empty: " + username);
			return null;
		}
		
		UserResponse response = new UserResponse();

		User user = userRepo.findByUsername(username);
		if (user != null) {
			Employee employee = user.getEmployee();
			if (employee != null) {
				Company company = companyCache.getCompany(employee.getCompany());
				response.setCompany(company);

				Division division = divisionCache.getDivision(employee.getDivision(), employee.getCompany());
				response.setDivision(division);

				Position position = positionCache.getPosition(employee.getPosition(), employee.getDivision());
				response.setPosition(position);
			}
			UserTO userTO = UserTransformerUtil.transformUserEntity(user);
			EmployeeTO employeeTO = EmployeeTransformerUtil.transformEmployeeEntity(user.getEmployee());
			
			List<Role> roleList = roleCache.findAll();
			userTO.setRoleList(roleList);
			
			// Get Current User's Role
			String loggedUsername = principal.getName();
			User loggedUser = userRepo.findByUsername(loggedUsername);
			if (loggedUser != null) {
				Role loggedUserRole = loggedUser.getRole();
				response.setUserRole(loggedUserRole);
			}
			
			response.setEmployee(employeeTO);
			response.setUser(userTO);
		}
		response.setUsername(username);
		
		return response;
	}
	
	/**
	 * Terminate user.
	 *
	 * @param terminationDate the termination date
	 * @param username the username
	 * @return true, if successful
	 */
	@Override
	public boolean terminateUser(LocalDate terminationDate, String username) {
		
		if (terminationDate != null && !StringUtil.isEmpty(username)) {
			userRepo.terminateUser(terminationDate, username);
			return true;
		}
		
		return false;
	}


	/**
	 * Change password.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	@Override
	public boolean changePassword(ChangePasswordRequest request) {
		// TODO Auto-generated method stub
		
		String password = request.getPassword().trim();
		String passwordConfirmation = request.getPasswordConfirmation().trim();
		String username = request.getUsername();
		if (!StringUtil.isEmpty(passwordConfirmation) && !StringUtil.isEmpty(password)
				&& password.equals(passwordConfirmation)) {
			
			// encode
			String hashPassword = new BCryptPasswordEncoder().encode(password);
			
			userRepo.updatePassword(hashPassword, username);
			return true;
		}
		
		return false;
	}


	/**
	 * Update access.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	@Override
	public boolean updateAccess(UpdateAccessRequest request) {
		
		String roleId = request.getRole();
		String username = request.getUsername();
		Role role = roleAccessor.getRole(Integer.parseInt(roleId));
		
		if (role != null && !StringUtil.isEmpty(username)) {
			userRepo.updateAcess(role, username);
			return true;
		}
		
		return false;
	}
}
