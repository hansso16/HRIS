package com.soses.hris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByEmployeeId(int employeeId);

//	@Query("SELECT e FROM employee e WHERE e.employeeId LIKE %:employeeId%")
//	Employee findByEmployeeIdLike(String employeeId);
}
