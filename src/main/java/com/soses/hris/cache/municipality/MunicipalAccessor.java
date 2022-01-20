package com.soses.hris.cache.municipality;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Municipal;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MunicipalAccessor {

	private MunicipalCache municipalityCache;

	@Autowired
	public MunicipalAccessor(MunicipalCache municipalityCache) {
		super();
		this.municipalityCache = municipalityCache;
	}
	
	public Municipal getMaritalStatus(String municipalId, String provinceId) {
		Municipal dto = null;
		if (!StringUtil.isEmpty(municipalId) && !StringUtil.isEmpty(provinceId)) {
			List<Municipal> list = municipalityCache.getMunicipalListByProvince(provinceId);
			dto = list.stream().filter(param -> (provinceId.equals(param.getMunicipalId()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
