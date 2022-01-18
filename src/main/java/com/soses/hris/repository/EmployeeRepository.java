package com.soses.hris.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

	List<Employee> findByEmployeeIdContains(String employeeId);

//	List<Employee> findByEmployeeIdContains(String employeeId, Pageable pageable);
	
	Page<Employee> findByEmployeeIdContains(String employeeId, Pageable pageable);

	Employee findByEmployeeId(String employeeId);
	
	@Query(value= "select NEXTVAL(sqx_employee_id)", nativeQuery=true)
	BigDecimal getNextEmployeeId();

//	@Query("SELECT e FROM employee e WHERE e.employeeId LIKE %:employeeId%")
//	Employee findByEmployeeIdLike(String employeeId);
}
