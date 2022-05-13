package com.soses.hris.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.Employee;
import com.soses.hris.entity.Role;
import com.soses.hris.entity.User;

// TODO: Auto-generated Javadoc
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
	Page<User> findByUsernameContainsOrEmployeeContains(String username, Employee employee, Pageable pageable);
	
	/**
	 * Exists by employee.
	 *
	 * @param employee the employee
	 * @return true, if successful
	 */
	boolean existsByEmployee(Employee employee);
	
	/**
	 * Exists by id.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	boolean existsById(String username);
	
	/**
	 * Terminate user.
	 *
	 * @param terminationDate the termination date
	 * @param username the username
	 */
	@Modifying
	@Query("UPDATE user u SET u.terminationDate = :terminationDate WHERE u.username = :username")
	
	/**
	 * Terminate user.
	 *
	 * @param terminationDate the termination date
	 * @param username the username
	 */
	void terminateUser(@Param("terminationDate") LocalDate terminationDate, @Param("username") String username);

	/**
	 * Update password.
	 *
	 * @param password the password
	 * @param username the username
	 */
	@Modifying
	@Query("UPDATE user u SET u.password = :password WHERE u.username = :username")
	void updatePassword(@Param("password") String password, @Param("username") String username);
	
	/**
	 * Update acess.
	 *
	 * @param role the role
	 * @param username the username
	 */
	@Modifying
	@Query("UPDATE user u SET u.role = :role WHERE u.username = :username")
	void updateAcess(@Param("role") Role role, @Param("username") String username);		
}
