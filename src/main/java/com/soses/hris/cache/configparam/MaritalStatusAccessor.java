package com.soses.hris.cache.configparam;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.ConfigParam;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MaritalStatusAccessor {

//	private static final Logger log = LogManager.getLogger(ConfigParamService.class);
	
	private MaritalStatusCache msService;

	@Autowired
	public MaritalStatusAccessor(MaritalStatusCache msService) {
		super();
		this.msService = msService;
	}
	
	public ConfigParam getMaritalStatus(String code) {
		ConfigParam dto = null;
		if (!StringUtil.isEmpty(code)) {
			List<ConfigParam> list = msService.getMaritalStatusList();
			dto = list.stream().filter(param -> (code.equals(param.getId().getCode()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
	
	public ConfigParam getMaritalStatusListByDate(String code, LocalDate processDate) {
		ConfigParam dto = null;
		if (!StringUtil.isEmpty(code)) {
			List<ConfigParam> list = msService.getMaritalStatusList();
			dto = list.stream().filter(param -> param.getEffDate().isBefore(processDate)
					&& param.getId().getEndDate().isAfter(processDate)) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
