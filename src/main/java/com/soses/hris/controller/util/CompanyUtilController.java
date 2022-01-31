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

import com.soses.hris.cache.division.DivisionCache;
import com.soses.hris.entity.Division;

@Controller
@RequestMapping("/util")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CompanyUtilController {

	private DivisionCache divisionCache;
	
	@Autowired
	public CompanyUtilController(DivisionCache divisionCache) {
		super();
		this.divisionCache = divisionCache;
	}


	@GetMapping(value="/company/{companyCode}", produces="application/json")
	public @ResponseBody List<Division> test(@PathVariable String companyCode) {
		
		List<Division> divisionList = divisionCache.getDivisionListByCompany(companyCode);
		
		return divisionList;
	}
}
