package com.soses.hris.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.Division;
import com.soses.hris.entity.DivisionPK;

public interface DivisionRepository extends JpaRepository<Division, DivisionPK>{

	List<Division> findByEffDateLessThanEqualAndIdEndDateGreaterThan(LocalDate currDate1, LocalDate currDate2);
}
