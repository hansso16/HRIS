package com.soses.hris.cache.division;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Division;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DivisionAccessor {

	private DivisionCache cache;

	@Autowired
	public DivisionAccessor(DivisionCache cache) {
		super();
		this.cache = cache;
	}
	
	public Division getDivision(String divisionCode, String comopanyCode) {
		Division dto = null;
		if (!StringUtil.isEmpty(divisionCode) && !StringUtil.isEmpty(comopanyCode)) {
			List<Division> list = cache.getDivisionListByCompany(comopanyCode);
			dto = list.stream().filter(param -> (divisionCode.equals(param.getId().getDivisionCode()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
