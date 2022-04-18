package com.soses.hris.service.user.impl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.api.user.BaseUserResponse;
import com.soses.hris.api.user.UserResponse;
import com.soses.hris.cache.company.CompanyCacheAccessor;
import com.soses.hris.cache.division.DivisionAccessor;
import com.soses.hris.cache.position.PositionAccessor;
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

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserRepository userRepo;
	
	private CompanyCacheAccessor companyCache;
	
	private DivisionAccessor divisionCache;
	
	private PositionAccessor positionCache;
	
	private RoleCacheService roleCache;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo, CompanyCacheAccessor companyCache
			, DivisionAccessor divisionCache, PositionAccessor positionCache
			, RoleCacheService roleCache) {
		super();
		this.userRepo = userRepo;
		this.companyCache = companyCache;
		this.positionCache = positionCache;
		this.divisionCache = divisionCache;
		this.roleCache = roleCache;
	}


	@Override
	public BaseUserResponse getUserDetails(String username) {
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
			
			response.setEmployee(employeeTO);
			response.setUser(userTO);
		}
		response.setUsername(username);
		
		return response;
	}
	
	@Override
	public boolean terminateUser(LocalDate terminationDate, String username) {
		
		if (terminationDate != null && !StringUtil.isEmpty(username)) {
			userRepo.terminateUser(terminationDate, username);
			return true;
		}
		
		return false;
	}

}
