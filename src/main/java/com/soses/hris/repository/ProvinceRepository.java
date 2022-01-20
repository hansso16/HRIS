package com.soses.hris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {

}
