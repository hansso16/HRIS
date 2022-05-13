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

	Page<Employee> findByEmployeeIdContainsOrLastNameContainsOrFirstNameContains(String employeeId, String firstName, String lastName, Pageable pageable);

	Employee findByEmployeeId(String employeeId);
	
//	@Query(value= "select NEXTVAL(sqx_employee_id)", nativeQuery=true)
//	BigDecimal getNextEmployeeIdA();

	@Query(value= "select NEXTVAL(sqx_employee_id_a)", nativeQuery=true)
	BigDecimal getNextEmployeeIdA();
	
	@Query(value= "select NEXTVAL(sqx_employee_id_b)", nativeQuery=true)
	BigDecimal getNextEmployeeIdB();
	
	@Query(value= "select NEXTVAL(sqx_employee_id_c)", nativeQuery=true)
	BigDecimal getNextEmployeeIdC();
	
	@Query(value= "select NEXTVAL(sqx_employee_id_d)", nativeQuery=true)
	BigDecimal getNextEmployeeIdD();
	
	@Query(value= "select NEXTVAL(sqx_employee_id_e)", nativeQuery=true)
	BigDecimal getNextEmployeeIdE();
	
	@Query(value= "select NEXTVAL(sqx_employee_id_f)", nativeQuery=true)
	BigDecimal getNextEmployeeIdF();
	
	@Query(value= "select NEXTVAL(sqx_employee_id_g)", nativeQuery=true)
	BigDecimal getNextEmployeeIdG();
	
	@Query(value= "select NEXTVAL(sqx_employee_id_h)", nativeQuery=true)
	BigDecimal getNextEmployeeIdH();
}
