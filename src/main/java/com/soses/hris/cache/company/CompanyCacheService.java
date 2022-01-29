package com.soses.hris.cache.company;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.entity.Company;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyCacheService {

	private CompanyCacheFactory factory;

	@Autowired
	public CompanyCacheService(CompanyCacheFactory factory) {
		super();
		this.factory = factory;
	}
	
//	@Cacheable(value="regionCache")
	public List<Company> findAll() {
		return factory.findAll();
	}
}
