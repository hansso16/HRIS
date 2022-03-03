package com.soses.hris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.EmployeeAddressHistory;
import com.soses.hris.entity.EmployeeAddressHistoryPK;

@Repository
public interface EmployeeAddressHistoryRepository extends JpaRepository<EmployeeAddressHistory, EmployeeAddressHistoryPK> {

	List<EmployeeAddressHistory> findByIdEmployeeId(String employeeId);
	
	List<EmployeeAddressHistory> findByIdEmployeeIdAndIdAddressType(String employeeId, String addressType);
}
