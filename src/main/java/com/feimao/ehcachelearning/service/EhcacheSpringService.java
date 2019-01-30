package com.feimao.ehcachelearning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: feimao
 * @Date: 18-12-16 下午2:07
 */
@Service
@Slf4j
public class EhcacheSpringService {

    @Cacheable(cacheManager = "cacheManager", cacheNames = "cache_10s", key = "#key", sync = true)
    public String test(String key) {
        log.info("not in cache but call real service");
        return "test";
    }
}
