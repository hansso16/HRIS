package com.soses.hris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.DivisionPosition;
import com.soses.hris.entity.DivisionPositionPK;

public interface DivisionPositionRepository extends JpaRepository<DivisionPosition, DivisionPositionPK>{

}
