package com.soses.hris.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUsername(String username);
	
	Page<User> findByUsernameContains(String username, Pageable pageable);
	
	Page<User> findByUsernameContainsOrEmployeeIdContains(String username, String employeeId, Pageable pageable);
}
