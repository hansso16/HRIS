package com.soses.hris.cache.municipality;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.entity.Municipal;
import com.soses.hris.repository.MunicipalRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MunicipalFactory {

	private MunicipalRepository repo;
	
	@Autowired
	public MunicipalFactory(MunicipalRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Municipal> findAll() {
		return repo.findAll();
	}
}
