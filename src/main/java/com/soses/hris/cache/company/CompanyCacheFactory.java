package com.soses.hris.cache.company;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.entity.Company;
import com.soses.hris.repository.CompanyRepository;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyCacheFactory {

	private CompanyRepository repo;

	@Autowired
	public CompanyCacheFactory(CompanyRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<Company> findAll() {
		return repo.findByEffDateLessThanEqualAndIdEndDateGreaterThan(LocalDate.now(), LocalDate.now());
	}
}
