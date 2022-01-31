package com.soses.hris.controller.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.soses.hris.cache.position.PositionCache;
import com.soses.hris.entity.Position;

@Controller
@RequestMapping("/util")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class DivisionUtilController {

	private PositionCache positionCache;
	
	@Autowired
	public DivisionUtilController(PositionCache positionCache) {
		super();
		this.positionCache = positionCache;
	}


	@GetMapping(value="/division/{divisionCode}", produces="application/json")
	public @ResponseBody List<Position> test(@PathVariable String divisionCode) {
		
		List<Position> positionList = positionCache.getPositionListByDivision(divisionCode);
		
		return positionList;
	}
}
