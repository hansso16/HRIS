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

import com.soses.hris.cache.barangay.BarangayCache;
import com.soses.hris.entity.Barangay;

@Controller
@RequestMapping("/util")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class MunicipalUtilController {

	private BarangayCache barangayCache;
	
	@Autowired
	public MunicipalUtilController(BarangayCache barangayCache) {
		super();
		this.barangayCache = barangayCache;
	}


	@GetMapping(value="/municipal/{municipalId}", produces="application/json")
	public @ResponseBody List<Barangay> test(@PathVariable String municipalId) {
		
		List<Barangay> barangayList = barangayCache.getBarangayListByMunicipal(municipalId);
		
		return barangayList;
	}
}
