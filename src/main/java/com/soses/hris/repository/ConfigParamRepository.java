package com.soses.hris.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soses.hris.entity.ConfigParam;
import com.soses.hris.entity.ConfigParamPK;

@Repository
public interface ConfigParamRepository extends JpaRepository<ConfigParam, ConfigParamPK>{

	@Cacheable(value="configParamCache", key="#id")
	ConfigParam getById(ConfigParamPK id);
	
//	List<ConfigParam> findByIdTableNameAndIdFieldName(String tableName, String fieldName);
	
	@Cacheable(value="configParamTableNameAndFieldName", key="{#tableName, #fieldName}")
	List<ConfigParam> findByIdTableNameAndIdFieldNameAndEffDateBeforeAndIdEndDateAfter(String tableName, String fieldName
			, LocalDate currDate1, LocalDate currDate2);
}
