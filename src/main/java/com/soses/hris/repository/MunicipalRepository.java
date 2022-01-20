package com.soses.hris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.Municipal;

@Repository
public interface MunicipalRepository extends JpaRepository<Municipal, String> {

}
