package com.soses.hris.cache.configparam;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.entity.ConfigParam;
import com.soses.hris.repository.ConfigParamRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ConfigParamFactory {

	private ConfigParamRepository repo;
	
	@Autowired
	public ConfigParamFactory(ConfigParamRepository repo) {
		super();
		this.repo = repo;
	}

	public List<ConfigParam> findAll() {
		return repo.findByEffDateLessThanEqualAndIdEndDateGreaterThan(LocalDate.now(), LocalDate.now());
	}
}
