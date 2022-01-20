package com.soses.hris.cache.province;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Province;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProvinceCache {

	private ProvinceService provinceService;

	@Autowired
	public ProvinceCache(ProvinceService provinceService) {
		super();
		this.provinceService = provinceService;
	}

	@Cacheable(value="provinceCacheByRegion", key="#regionId")
	public List<Province> getProvinceListByRegion(String regionId) {
		List<Province> provinceList = null;
		if (!StringUtil.isEmpty(regionId)) {
			List<Province> list = provinceService.findAll();
			provinceList = list.stream()
					.filter(param -> regionId.equals(param.getRegionId()))
					.collect(Collectors.toList());
		}
		return provinceList;
	}
}
