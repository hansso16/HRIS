package com.soses.hris.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.Position;
import com.soses.hris.entity.PositionPK;

public interface PositionRepository extends JpaRepository<Position, PositionPK>{
	
	List<Position> findByEffDateLessThanEqualAndIdEndDateGreaterThan(LocalDate currDate1, LocalDate currDate2);
}
