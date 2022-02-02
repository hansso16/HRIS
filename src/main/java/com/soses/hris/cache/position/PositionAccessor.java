package com.soses.hris.cache.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Position;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PositionAccessor {

	private PositionCache positionCache;

	@Autowired
	public PositionAccessor(PositionCache positionCache) {
		super();
		this.positionCache = positionCache;
	}
	
	public Position getPosition(String positionCode, String divisionCode) {
		Position dto = null;
		if (!StringUtil.isEmpty(positionCode) && !StringUtil.isEmpty(divisionCode)) {
			List<Position> list = positionCache.getPositionListByDivision(divisionCode);
			dto = list.stream().filter(param -> (divisionCode.equals(param.getId().getPositionCode()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
