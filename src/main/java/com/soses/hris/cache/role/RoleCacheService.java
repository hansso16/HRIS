package com.soses.hris.cache.role;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.entity.Role;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RoleCacheService {

	private RoleFactory roleFactory;

	@Autowired
	public RoleCacheService(RoleFactory roleFactory) {
		super();
		this.roleFactory = roleFactory;
	}

	@Cacheable(value="roleCache")
	public List<Role> findAll() {
		return roleFactory.findAll();
	}
}
