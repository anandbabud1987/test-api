package com.anand.config;

import com.anand.service.OprtKeyGenerator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;



@Configuration
@EnableCaching(mode = AdviceMode.ASPECTJ)
public class CacheManagerConfig {

    public static final String USER_CACHE = "resultCache";


    @Bean
    public org.springframework.cache.CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

       // CaffeineCache userCache = new CaffeineCache(USER_CACHE, Caffeine.newBuilder()
         //       .maximumSize(1000)
            //    .expireAfterWrite(30, TimeUnit.MINUTES)
            //    .build());

        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache(USER_CACHE)));
        return cacheManager;
    }

    @Bean("OprtKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new OprtKeyGenerator();
    }
}
