package com.soses.hris.cache.configparam;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.GlobalConstants;
import com.soses.hris.entity.ConfigParam;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GenderCache {

	private ConfigParamService cpService;

	@Autowired
	public GenderCache(ConfigParamService cpService) {
		super();
		this.cpService = cpService;
	}

	@Cacheable(value="genderCache")
	public List<ConfigParam> getGenderList() {
		List<ConfigParam> list = cpService.findAll();
		List<ConfigParam> genderList = list.stream()
				.filter(param -> (GlobalConstants.EMPLOYEE.equals(param.getId().getTableName()) 
						&& GlobalConstants.GENDER.equals(param.getId().getFieldName())))
				.collect(Collectors.toList());
		return genderList;
	}
}
