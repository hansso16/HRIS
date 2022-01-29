package com.soses.hris.cache.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Company;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyCacheAccessor {

	private CompanyCacheService service;

	@Autowired
	public CompanyCacheAccessor(CompanyCacheService service) {
		super();
		this.service = service;
	}
	
	public Company getCompany(String companyCode) {
		Company dto = null;
		if (!StringUtil.isEmpty(companyCode)) {
			List<Company> list = service.findAll();
			dto = list.stream().filter(param -> (companyCode.equals(param.getId().getCompanyCode()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
	
}
