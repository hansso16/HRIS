package com.soses.hris.cache.barangay;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Barangay;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BarangayCache {

	private BarangayService barangayService;

	@Autowired
	public BarangayCache(BarangayService barangayService) {
		super();
		this.barangayService = barangayService;
	}

	@Cacheable(value="barangayCacheByMunicipal", key="#municipalId")
	public List<Barangay> getBarangayListByMunicipal(String municipalId) {
		List<Barangay> provinceList = null;
		if (!StringUtil.isEmpty(municipalId)) {
			List<Barangay> list = barangayService.findAll();
			provinceList = list.stream()
					.filter(param -> municipalId.equals(param.getMunicipalId()))
					.collect(Collectors.toList());
		}
		return provinceList;
	}
}
