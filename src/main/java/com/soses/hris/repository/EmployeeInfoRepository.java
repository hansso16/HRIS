package com.soses.hris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.EmployeeInfo;

public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, String> {

	EmployeeInfo findByEmployeeId(String employeeId);
}
