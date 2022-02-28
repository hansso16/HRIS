package com.soses.hris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.EmployeeAddressHistory;

@Repository
public interface EmployeeAddressHistoryRepository extends JpaRepository<EmployeeAddressHistory, String> {

	List<EmployeeAddressHistory> findByIdEmployeeId(String employeeId);
	
	List<EmployeeAddressHistory> findByIdEmployeeIdByAddressType(String employeeId, String addressType);
}
