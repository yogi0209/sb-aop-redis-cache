package com.yogendra.sbaoprediscache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisDataCache {
    @Autowired
    private RedisTemplate<String, Object> jsonRedisTemplate;

    public boolean ifKeyExists(String key) {
        return jsonRedisTemplate.hasKey(key);
    }

    public void insertDataInRedisCache(String key, Object data) {
        jsonRedisTemplate.opsForValue().set(key, data, Duration.ofSeconds(5));
    }

    public Object fetchDataFromRedisCache(String key) {
        return jsonRedisTemplate.opsForValue().get(key);
    }
}
