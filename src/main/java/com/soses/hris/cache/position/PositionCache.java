package com.soses.hris.cache.position;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Position;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PositionCache {

	private PositionService service;

	@Autowired
	public PositionCache(PositionService service) {
		super();
		this.service = service;
	}

//	@Cacheable(value="provinceCacheByRegion", key="#regionId")
	public List<Position> getPositionListByDivision(String divisionCode) {
		List<Position> divisionList = null;
		if (!StringUtil.isEmpty(divisionCode)) {
			List<Position> list = service.findAll();
			list = list.stream()
					.filter(param -> divisionCode.equals(param.getDivisionCode()))
					.collect(Collectors.toList());
		}
		return divisionList;
	}
}
