package com.soses.hris.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.RoleHierarchy;

public interface RoleHierarchyRepository extends JpaRepository<RoleHierarchy, Integer>{

	List<RoleHierarchy> findAllByEndDateGreaterThanAndEffDateLessThanEqual(LocalDate date1, LocalDate date2);
}
