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

import com.soses.hris.cache.province.ProvinceCache;
import com.soses.hris.entity.Province;

@Controller
@RequestMapping("/util")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class RegionUtilController {

	private ProvinceCache provinceCache;
	
	@Autowired
	public RegionUtilController(ProvinceCache provinceCache) {
		super();
		this.provinceCache = provinceCache;
	}


	@GetMapping(value="/region/{regionId}", produces="application/json")
	public @ResponseBody List<Province> test(@PathVariable String regionId) {
		
		List<Province> provinceList = provinceCache.getProvinceListByRegion(regionId);
		
		return provinceList;
	}
}
