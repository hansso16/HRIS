package com.soses.hris.cache.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Position;

/**
 * The Class PositionAccessor.
 *
 * @author hso
 * @since Mar 22, 2022
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PositionAccessor {

	/** The position cache. */
	private PositionCache positionCache;

	/**
	 * Instantiates a new position accessor.
	 *
	 * @param positionCache the position cache
	 */
	@Autowired
	public PositionAccessor(PositionCache positionCache) {
		super();
		this.positionCache = positionCache;
	}
	
	/**
	 * Gets the position.
	 *
	 * @param positionCode the position code
	 * @param divisionCode the division code
	 * @return the position
	 */
	public Position getPosition(String positionCode, String divisionCode) {
		Position dto = null;
		if (!StringUtil.isEmpty(positionCode) && !StringUtil.isEmpty(divisionCode)) {
			List<Position> list = positionCache.getPositionListByDivision(divisionCode);
			dto = list.stream().filter(param -> (positionCode.equals(param.getId().getPositionCode()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
