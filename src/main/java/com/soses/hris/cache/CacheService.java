package com.soses.hris.cache;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class CacheService {

//	private static final Logger log = LoggerFactory.getLogger(CacheService.class);
//	
//	private CacheFactory cacheFactory;
//
//	@Autowired
//	public void setCacheFactory(CacheFactory cacheFactory) {
//		this.cacheFactory = cacheFactory;
//	}

//	@Cacheable(value="configParamCache", key="#code")
//	public ConfigParam deriveMaritalStatus(String code) {
////		log.info("ENTER");
//		if (!StringUtil.isEmpty(code)) {
////			ConfigParam dto = cacheFactory.getMaritalStatusCache(code);
//			List<ConfigParam> list = findAll();
//			ConfigParam dto = list.stream().filter(param -> code.equals(param.getId().getCode())).findAny().orElse(null);
//			if (dto != null) {
//				return dto;
//			}
//		}
//		return null;
//	}
	
//	@Cacheable(value="configParamCachee")
//	public List<ConfigParam> findAll() {
//		return cacheFactory.findAll();
//	}
}
