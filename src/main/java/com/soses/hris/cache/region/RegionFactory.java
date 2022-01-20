package com.soses.hris.cache.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.entity.Region;
import com.soses.hris.repository.RegionRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegionFactory {

	private RegionRepository repo;
	
	@Autowired
	public RegionFactory(RegionRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Region> findAll() {
		return repo.findAll();
	}
}
