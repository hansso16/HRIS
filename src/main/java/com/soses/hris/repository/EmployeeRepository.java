package com.soses.hris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByEmployeeIdContains(String employeeId);

	Employee findByEmployeeId(String employeeId);

//	@Query("SELECT e FROM employee e WHERE e.employeeId LIKE %:employeeId%")
//	Employee findByEmployeeIdLike(String employeeId);
}
