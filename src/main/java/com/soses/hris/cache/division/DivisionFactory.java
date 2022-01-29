package com.soses.hris.cache.division;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.entity.Division;
import com.soses.hris.repository.DivisionRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DivisionFactory {

	private DivisionRepository repo;
	
	@Autowired
	public DivisionFactory(DivisionRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Division> findAll() {
		return repo.findByEffDateLessThanEqualAndIdEndDateGreaterThan(LocalDate.now(), LocalDate.now());
	}
}
