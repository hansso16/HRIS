package com.soses.hris.cache.province;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Province;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProvinceAccessor {

	private ProvinceCache provinceCache;

	@Autowired
	public ProvinceAccessor(ProvinceCache provinceCache) {
		super();
		this.provinceCache = provinceCache;
	}
	
	public Province getMaritalStatus(String provinceId, String regionId) {
		Province dto = null;
		if (!StringUtil.isEmpty(provinceId) && !StringUtil.isEmpty(regionId)) {
			List<Province> list = provinceCache.getProvinceListByRegion(regionId);
			dto = list.stream().filter(param -> (provinceId.equals(param.getProvinceId()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
