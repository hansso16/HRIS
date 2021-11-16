package com.soses.hris.config;

import org.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

//	@Bean(destroyMethod = "shutdown")
//	public org.ehcache.CacheManager ehCacheManager() {
//		CacheConfiguration cacheConfiguration = new CacheConfiguration();
//		cacheConfiguration.setName("countryListCache");
//		cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
//		cacheConfiguration.setMaxEntriesLocalHeap(1000);
//
//		/*CacheConfiguration cacheConfiguration1 = new CacheConfiguration();
//		cacheConfiguration1.setName("channelListCache");
//		cacheConfiguration1.setMemoryStoreEvictionPolicy("LRU");
//		cacheConfiguration1.setMaxEntriesLocalHeap(1000);*/
//
//		org.ehcache.config.Configuration config = new org.ehcache.config.Configuration();
//		config.addCache(cacheConfiguration);
//		/*config.addCache(cacheConfiguration1);*/
//
//		return org.ehcache.CacheManager.newInstance(config);
//	}
//	
//	@Bean
//	@Override
//	public CacheManager cacheManager() {
//		return new EhCacheCacheManager(ehCacheManager());
//	}
//
//	@Bean
//	@Override
//	public CacheResolver cacheResolver() {
//		return new SimpleCacheResolver(cacheManager());
//	}
//
//	@Bean
//	@Override
//	public KeyGenerator keyGenerator() {
//		return new SimpleKeyGenerator();
//	}
//
//	@Bean
//	@Override
//	public CacheErrorHandler errorHandler() {
//		return new SimpleCacheErrorHandler();
//	}

}
