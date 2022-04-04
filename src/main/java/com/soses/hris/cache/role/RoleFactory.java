package com.soses.hris.cache.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.entity.Role;
import com.soses.hris.repository.RoleRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RoleFactory {

	private RoleRepository repo;
	
	@Autowired
	public RoleFactory(RoleRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Role> findAll() {
		return repo.findAll();
	}
}
