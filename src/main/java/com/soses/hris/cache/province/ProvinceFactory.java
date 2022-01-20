package com.soses.hris.cache.province;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.entity.Province;
import com.soses.hris.repository.ProvinceRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProvinceFactory {

	private ProvinceRepository repo;
	
	@Autowired
	public ProvinceFactory(ProvinceRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Province> findAll() {
		return repo.findAll();
	}
}
