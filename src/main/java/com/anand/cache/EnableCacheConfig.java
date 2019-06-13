package com.anand.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anand.service.PersonService;

import java.util.Arrays;

@Configuration
@EnableCaching
public class EnableCacheConfig {
	
	@Bean
    public PersonService personService() {
       return new PersonService();
    }
	
	@Bean
	public CacheManager cacheManager() {
		
		SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("listpersons")));
        return cacheManager;
		
	}

}
