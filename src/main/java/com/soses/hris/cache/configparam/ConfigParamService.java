package com.soses.hris.cache.configparam;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.entity.ConfigParam;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ConfigParamService {

//	private static final Logger log = LogManager.getLogger(ConfigParamService.class);
	
	private ConfigParamFactory configParamFactory;

	@Autowired
	public ConfigParamService(ConfigParamFactory configParamFactory) {
		super();
		this.configParamFactory = configParamFactory;
	}

	@Cacheable(value="configParamCache")
	public List<ConfigParam> findAll() {
		return configParamFactory.findAll();
	}
	
}
