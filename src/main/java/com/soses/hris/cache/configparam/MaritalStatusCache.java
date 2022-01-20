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
public class MaritalStatusCache {

	private ConfigParamService cpService;

	@Autowired
	public MaritalStatusCache(ConfigParamService cpService) {
		super();
		this.cpService = cpService;
	}

	@Cacheable(value="maritalStatusCache")
	public List<ConfigParam> getMaritalStatusList() {
		List<ConfigParam> list = cpService.findAll();
		List<ConfigParam> maritalStatusList = list.stream()
				.filter(param -> (GlobalConstants.EMPLOYEE.equals(param.getId().getTableName()) 
						&& GlobalConstants.MARITAL_STATUS.equals(param.getId().getFieldName())))
				.collect(Collectors.toList());
		return maritalStatusList;
	}
}
