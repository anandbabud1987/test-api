package com.anand.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class CacheAspect {
    private Map<String, Object> cache;
    private Logger _LOG = LoggerFactory.getLogger(CacheAspect.class);

    public CacheAspect() {
        cache = new HashMap<>();
    }

    @Pointcut("execution(@Cacheable * *.*(..))")
    @SuppressWarnings("unused")
    private void cache() {
    }
    @Around("cache()")
    public Object aroundCachedMethods(ProceedingJoinPoint thisJoinPoint)
            throws Throwable {

        StringBuilder keyBuff = new StringBuilder();

        keyBuff.append(thisJoinPoint.getTarget().getClass().getName());

        keyBuff.append(".").append(thisJoinPoint.getSignature().getName());

        keyBuff.append("(");
        for (final Object arg : thisJoinPoint.getArgs()) {
            keyBuff.append(arg.getClass().getSimpleName() + "=" + arg + ";");
        }
        keyBuff.append(")");
        String key = keyBuff.toString();

        _LOG.debug("Key = " + key);
        Object result = cache.get(key);
        if (result == null) {
            _LOG.debug("Result not yet cached. Must be calculated...");
            result = thisJoinPoint.proceed();
            _LOG.info("Storing calculated value '" + result + "' to cache");
            cache.put(key, result);
        } else {
            _LOG.debug("Result '" + result + "' was found in cache");
        }

        return result;
    }
}
