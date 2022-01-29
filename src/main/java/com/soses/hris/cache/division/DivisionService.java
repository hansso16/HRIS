package com.soses.hris.cache.division;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.entity.Division;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DivisionService {

	private DivisionFactory factory;

	@Autowired
	public DivisionService(DivisionFactory factory) {
		super();
		this.factory = factory;
	}

//	@Cacheable(value="provinceCache")
	public List<Division> findAll() {
		return factory.findAll();
	}
}
