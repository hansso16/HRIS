package com.soses.hris.cache.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Region;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegionAccessor {

	private RegionCacheService regionCache;

	@Autowired
	public RegionAccessor(RegionCacheService regionCache) {
		super();
		this.regionCache = regionCache;
	}
	
	public Region getMaritalStatus(String regionId) {
		Region dto = null;
		if (!StringUtil.isEmpty(regionId)) {
			List<Region> list = regionCache.findAll();
			dto = list.stream().filter(param -> (regionId.equals(param.getRegionId()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
