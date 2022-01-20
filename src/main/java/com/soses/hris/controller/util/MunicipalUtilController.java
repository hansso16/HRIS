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

import com.soses.hris.cache.municipality.MunicipalCache;
import com.soses.hris.entity.Municipal;

@Controller
@RequestMapping("/util")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class MunicipalUtilController {

	private MunicipalCache municipalCache;
	
	@Autowired
	public MunicipalUtilController(MunicipalCache municipalCache) {
		super();
		this.municipalCache = municipalCache;
	}


	@GetMapping(value="/municipal/{provinceId}", produces="application/json")
	public @ResponseBody List<Municipal> test(@PathVariable String provinceId) {
		
		List<Municipal> municipalList = municipalCache.getMunicipalListByProvince(provinceId);
		
		return municipalList;
	}
}
