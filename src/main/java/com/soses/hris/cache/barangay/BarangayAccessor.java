package com.soses.hris.cache.barangay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.Barangay;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BarangayAccessor {

	private BarangayCache barangayCache;

	@Autowired
	public BarangayAccessor(BarangayCache barangayCache) {
		super();
		this.barangayCache = barangayCache;
	}
	
	public Barangay getBarangay(String barangayId, String municipalId) {
		Barangay dto = null;
		if (!StringUtil.isEmpty(barangayId) && !StringUtil.isEmpty(municipalId)) {
			List<Barangay> list = barangayCache.getBarangayListByMunicipal(municipalId);
			dto = list.stream().filter(param -> (barangayId.equals(param.getBarangayId()))) 
					.findFirst().orElse(null);
		}
		return dto;
	}
}
