package com.soses.hris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.ActivityHistory;

public interface ActivityHistoryRepository extends JpaRepository<ActivityHistory, Integer> {

	List<ActivityHistory> findByEmployeeId(String employeeId);
}
