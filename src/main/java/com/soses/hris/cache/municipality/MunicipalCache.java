package com.soses.hris.cache.municipality;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Municipal;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MunicipalCache {

	private MunicipalService municipalityService;

	@Autowired
	public MunicipalCache(MunicipalService municipalityService) {
		super();
		this.municipalityService = municipalityService;
	}

	@Cacheable(value="municipalCacheByProvince", key="#provinceId")
	public List<Municipal> getMunicipalListByProvince(String provinceId) {
		List<Municipal> provinceList = null;
		if (!StringUtil.isEmpty(provinceId)) {
			List<Municipal> list = municipalityService.findAll();
			provinceList = list.stream()
					.filter(param -> provinceId.equals(param.getProvinceId()))
					.collect(Collectors.toList());
		}
		return provinceList;
	}
}
