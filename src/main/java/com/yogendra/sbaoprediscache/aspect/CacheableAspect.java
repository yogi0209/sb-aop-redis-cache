package com.yogendra.sbaoprediscache.aspect;

import com.yogendra.sbaoprediscache.redis.RedisDataCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class CacheableAspect {

    Logger logger = Logger.getLogger("Cache");
    @Autowired
    RedisDataCache redisDataCache;
    @Pointcut("@annotation(com.yogendra.sbaoprediscache.aspect.Cacheable)")
    public void cacheMethodResult(){

    }

    @Around("cacheMethodResult()")
    public Object cacheMethodResult(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object argument = proceedingJoinPoint.getArgs()[0];
        if (redisDataCache.ifKeyExists(argument.toString())){
            logger.info("Fetching data from Redis cache for key " + argument);
            return redisDataCache.fetchDataFromRedisCache(argument.toString());
        } else {
            Object response = proceedingJoinPoint.proceed(new Object[]{argument});
            logger.info("Adding data to Redis cache for key " + argument);
            redisDataCache.insertDataInRedisCache(argument.toString(), response);
            return response;
        }
    }
}
