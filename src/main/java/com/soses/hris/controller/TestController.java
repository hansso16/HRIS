package com.soses.hris.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.soses.hris.HrisApplication;
import com.soses.hris.cache.configparam.ConfigParamService;
import com.soses.hris.cache.configparam.MaritalStatusAccessor;
import com.soses.hris.cache.configparam.MaritalStatusCache;
import com.soses.hris.entity.ConfigParam;

@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class TestController {
	
	private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(HrisApplication.class);

	@Autowired
	ConfigParamService cacheService;
	
	@Autowired
	MaritalStatusCache maritalStatusCache;
	
	@Autowired
	MaritalStatusAccessor msAccessor;
	
	@GetMapping(value="/test/{maritalStatus}", produces="application/json")
	@ResponseBody
	public String test(@PathVariable String maritalStatus) {
//		ConfigParam cp = maritalStatusCache.getMaritalStatus(maritalStatus);
		ConfigParam cp = msAccessor.getMaritalStatus(maritalStatus);
		log.info("CONTROLLER TEST CACHE: " + cp.toString());
		return cp.toString();
	}
	
	@GetMapping(value="/test", produces="application/json")
	@ResponseBody
	public String testAll() {
		List<ConfigParam> cp = cacheService.findAll();
		log.info("CONTROLLER TEST CACHE ALL: " + cp.toString());
		return cp.toString();
	}
	
}
