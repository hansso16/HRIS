package com.soses.hris.cache.barangay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.entity.Barangay;
import com.soses.hris.repository.BarangayRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BarangayFactory {

	private BarangayRepository repo;
	
	@Autowired
	public BarangayFactory(BarangayRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Barangay> findAll() {
		return repo.findAll();
	}
}
