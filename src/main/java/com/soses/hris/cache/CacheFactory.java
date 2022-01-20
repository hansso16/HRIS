package com.soses.hris.cache;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soses.hris.common.ConfigParamConstants;
import com.soses.hris.common.GeneralUtil;
import com.soses.hris.entity.ConfigParam;
import com.soses.hris.entity.ConfigParamPK;
import com.soses.hris.repository.ConfigParamRepository;

@Component
public class CacheFactory {

//	private ConfigParamRepository repo;
//	
//	private static final LocalDate activeDate = GeneralUtil.getMaxDate();
//	
//	@Autowired
//	public void setRepo(ConfigParamRepository repo) {
//		this.repo = repo;
//	}
//	
//	
//	public ConfigParam getMaritalStatusCache(String code) {
//		ConfigParamPK id = new ConfigParamPK();
//		id.setCode(code);
//		id.setEndDate(activeDate);
//		id.setTableName(ConfigParamConstants.EMPLOYEE);
//		id.setFieldName(ConfigParamConstants.MARITAL_STATUS);
//		return repo.getById(id);
//	}
//	
//	
////	public List<ConfigParam> findAll() {
////		return repo.findAll();
////	}
//	
//	public List<ConfigParam> getAllMaritalStatus() {
//		LocalDate currDate = GeneralUtil.getCurrentDate();
//		return repo.findByIdTableNameAndIdFieldNameAndEffDateBeforeAndIdEndDateAfter(
//				ConfigParamConstants.EMPLOYEE,ConfigParamConstants.MARITAL_STATUS,currDate,currDate);
//	}
	
}
