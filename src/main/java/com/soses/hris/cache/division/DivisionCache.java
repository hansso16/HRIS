package com.soses.hris.cache.division;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Division;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DivisionCache {

	private DivisionService service;

	@Autowired
	public DivisionCache(DivisionService serviceService) {
		super();
		this.service = serviceService;
	}

//	@Cacheable(value="provinceCacheByRegion", key="#regionId")
	public List<Division> getDivisionListByCompany(String companyCode) {
		List<Division> divisionList = null;
		if (!StringUtil.isEmpty(companyCode)) {
			List<Division> list = service.findAll();
			divisionList = list.stream()
					.filter(param -> companyCode.equals(param.getCompanyCode()))
					.collect(Collectors.toList());
		}
		return divisionList;
	}
}
