package com.soses.hris.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.User;

/**
 * The Interface UserRepository.
 *
 * @author hso
 * @since Mar 22, 2022
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the user
	 */
	User findByUsername(String username);
	
	/**
	 * Find by username contains.
	 *
	 * @param username the username
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<User> findByUsernameContains(String username, Pageable pageable);
	
	/**
	 * Find by username contains or employee id contains.
	 *
	 * @param username the username
	 * @param employeeId the employee id
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<User> findByUsernameContainsOrEmployeeIdContains(String username, String employeeId, Pageable pageable);
	
	/**
	 * Find by employee id.
	 *
	 * @param employeeId the employee id
	 * @return the user
	 */
	User findByEmployeeId(String employeeId);
}
