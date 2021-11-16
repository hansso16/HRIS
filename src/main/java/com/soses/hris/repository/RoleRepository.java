package com.soses.hris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	public Role findByRoleId(Integer roleId);
}
