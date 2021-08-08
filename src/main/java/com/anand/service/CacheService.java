package com.anand.service;

import com.anand.model.OperatorRequest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.anand.config.CacheManagerConfig.USER_CACHE;

@Service
public class CacheService {

    private final CacheManager cacheManager;

    private final OprtKeyGenerator oprtKeyGenerator;

    public CacheService(CacheManager cacheManager, OprtKeyGenerator oprtKeyGenerator) {
        this.cacheManager = cacheManager;
        this.oprtKeyGenerator = oprtKeyGenerator;
    }

    public Cache.ValueWrapper getOprtCache(OperatorRequest input) {
        String key = oprtKeyGenerator.generateKey(input);
        return cacheManager.getCache(USER_CACHE).get(key);
    }

    public void setCache(OperatorRequest input, Object result) {
        String key = oprtKeyGenerator.generateKey(input);
        Objects.requireNonNull(cacheManager.getCache(USER_CACHE)).put(key, result.toString());
    }
}
