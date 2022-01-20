package com.soses.hris.cache.municipality;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.entity.Municipal;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MunicipalService {

	private MunicipalFactory municipalityFactory;

	@Autowired
	public MunicipalService(MunicipalFactory municipalityFactory) {
		super();
		this.municipalityFactory = municipalityFactory;
	}

	@Cacheable(value="municipalCache")
	public List<Municipal> findAll() {
		return municipalityFactory.findAll();
	}
}
