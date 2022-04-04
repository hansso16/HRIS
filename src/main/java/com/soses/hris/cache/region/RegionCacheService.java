package com.soses.hris.cache.region;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.entity.Region;

/**
 * The Class RegionCacheService.
 *
 * @author hso
 * @since Mar 23, 2022
 */
@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegionCacheService {

	/** The region factory. */
	private RegionFactory regionFactory;

	/**
	 * Instantiates a new region cache service.
	 *
	 * @param regionFactory the region factory
	 */
	@Autowired
	public RegionCacheService(RegionFactory regionFactory) {
		super();
		this.regionFactory = regionFactory;
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Cacheable(value="regionCache")
	public List<Region> findAll() {
		return regionFactory.findAll();
	}
}
