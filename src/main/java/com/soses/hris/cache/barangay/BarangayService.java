package com.soses.hris.cache.barangay;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.soses.hris.entity.Barangay;

@Service
@Transactional
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BarangayService {

	private BarangayFactory barangayFactory;

	@Autowired
	public BarangayService(BarangayFactory barangayFactory) {
		super();
		this.barangayFactory = barangayFactory;
	}

	@Cacheable(value="barangayCache")
	public List<Barangay> findAll() {
		return barangayFactory.findAll();
	}
}
