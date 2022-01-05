package com.soses.hris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.soses.hris.entity.EmployeeDependent;
import com.soses.hris.entity.EmployeeDependentPK;

public interface EmployeeDependentRepository extends JpaRepository<EmployeeDependent, EmployeeDependentPK>{

	List<EmployeeDependent> findByIdEmployeeId(String employeeId);
	
	@Query(value="SELECT max(ed.dependent_id) FROM EMPLOYEE_DEPENDENT ed WHERE ed.EMPLOYEE_ID = :employeeId", nativeQuery=true)
	short getMaxDependentIdByEmployee(@Param("employeeId") String employeeId);
}
