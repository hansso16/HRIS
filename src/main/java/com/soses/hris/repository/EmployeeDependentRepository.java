package com.soses.hris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.EmployeeDependent;
import com.soses.hris.entity.EmployeeDependentPK;

public interface EmployeeDependentRepository extends JpaRepository<EmployeeDependent, EmployeeDependentPK>{

	List<EmployeeDependent> findByIdEmployeeId(String employeeId);
}
