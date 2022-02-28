package com.soses.hris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.EmployeeAddressHistory;

public interface EmployeeAddressHistoryRepository extends JpaRepository<EmployeeAddressHistory, String> {

}
