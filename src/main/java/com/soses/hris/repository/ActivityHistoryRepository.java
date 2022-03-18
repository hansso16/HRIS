package com.soses.hris.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.ActivityHistory;

public interface ActivityHistoryRepository extends JpaRepository<ActivityHistory, Integer> {

	Page<ActivityHistory> findByEmployeeIdOrderByEntryTimestampDesc(String employeeId, Pageable pageable);
}
