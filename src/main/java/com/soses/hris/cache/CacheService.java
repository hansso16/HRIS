package com.soses.hris.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.ConfigParam;

@Service
public class CacheService {

	private static final Logger log = LoggerFactory.getLogger(CacheService.class);
	
	private CacheFactory cacheFactory;

	@Autowired
	public void setCacheFactory(CacheFactory cacheFactory) {
		this.cacheFactory = cacheFactory;
	}

	public String deriveMaritalStatus(String code) {
		log.info("ENTER");
		if (!StringUtil.isEmpty(code)) {
			ConfigParam dto = cacheFactory.getMaritalStatusCache(code);
			if (dto != null) {
				return dto.getDescription();
			}
		}
		return "";
	}
	
	public List<ConfigParam> getConfigParamList(String tableName, String fieldName) {
		log.info("ENTER");
		return cacheFactory.getAllMaritalStatus();
	}
	
}
