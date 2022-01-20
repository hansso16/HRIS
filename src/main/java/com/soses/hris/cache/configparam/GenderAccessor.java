package com.soses.hris.cache.configparam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.ConfigParam;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GenderAccessor {

	private GenderCache genderCache;

	@Autowired
	public GenderAccessor(GenderCache genderCache) {
		super();
		this.genderCache = genderCache;
	}
	
	public ConfigParam getMaritalStatus(String code) {
		ConfigParam dto = null;
		if (!StringUtil.isEmpty(code)) {
			List<ConfigParam> list = genderCache.getGenderList();
			dto = list.stream().filter(param -> (code.equals(param.getId().getCode()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
