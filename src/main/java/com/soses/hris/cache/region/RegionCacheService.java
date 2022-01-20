package com.soses.hris.cache.region;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.entity.Region;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegionCacheService {

	private RegionFactory regionFactory;

	@Autowired
	public RegionCacheService(RegionFactory regionFactory) {
		super();
		this.regionFactory = regionFactory;
	}

	@Cacheable(value="regionCache")
	public List<Region> findAll() {
		return regionFactory.findAll();
	}
}
