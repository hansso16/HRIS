package com.soses.hris.cache.province;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.entity.Province;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProvinceService {

	private ProvinceFactory provinceFactory;

	@Autowired
	public ProvinceService(ProvinceFactory provinceFactory) {
		super();
		this.provinceFactory = provinceFactory;
	}

	@Cacheable(value="provinceCache")
	public List<Province> findAll() {
		return provinceFactory.findAll();
	}
}
