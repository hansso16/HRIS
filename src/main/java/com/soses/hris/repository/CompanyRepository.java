package com.soses.hris.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soses.hris.entity.Company;
import com.soses.hris.entity.CompanyPK;

public interface CompanyRepository extends JpaRepository<Company, CompanyPK>{

	List<Company> findByEffDateLessThanEqualAndIdEndDateGreaterThan(LocalDate currDate1, LocalDate currDate2);
}
