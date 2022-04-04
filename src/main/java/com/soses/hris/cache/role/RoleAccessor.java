package com.soses.hris.cache.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Role;

/**
 * The Class RoleAccessor.
 *
 * @author hso
 * @since Mar 23, 2022
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RoleAccessor {

	/** The role cache. */
	private RoleCacheService roleCache;

	/**
	 * Instantiates a new role accessor.
	 *
	 * @param roleCache the role cache
	 */
	@Autowired
	public RoleAccessor(RoleCacheService roleCache) {
		super();
		this.roleCache = roleCache;
	}
	
	/**
	 * Gets the role.
	 *
	 * @param roleId the role id
	 * @return the role
	 */
	public Role getRole(int roleId) {
		Role dto = null;
		if (roleId > 0) {
			List<Role> list = roleCache.findAll();
			dto = list.stream().filter(param -> roleId == param.getRoleId()) 
					.findFirst().orElse(null);
		}
		return dto;
	}

	/**
	 * Gets the role.
	 *
	 * @param roleId the role id
	 * @return the role
	 */
	public Role getRoleByFullRoleCode(String fullRoleCode) {
		Role dto = null;
		if (!StringUtil.isEmpty(fullRoleCode)) {
			List<Role> list = roleCache.findAll();
			dto = list.stream().filter(param -> fullRoleCode.equals(param.getFullRoleCode())) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
