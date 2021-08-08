package com.anand.aspectj;

import com.anand.model.OperatorRequest;
import com.anand.service.CacheService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheAspect {
    Logger log = LoggerFactory.getLogger(CacheAspect.class);
    private final CacheService cacheService;


    public CacheAspect(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Around(value = "execution(* com.anand.service.OperatorService.doOperation(..))")
    public Object cacheMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("inside cacheMethod of CacheAspect invoked");
        OperatorRequest input = (OperatorRequest) proceedingJoinPoint.getArgs()[0];
        Cache.ValueWrapper cache = cacheService.getOprtCache(input);
        if (cache != null && cache.get() != null) {
            log.info("value already exists in cache and fetching from cache");
            return String.valueOf(cache.get());
        } else {
            Object value = proceedingJoinPoint.proceed();
            cacheService.setCache(input,value);
            return value;
        }
    }

}
