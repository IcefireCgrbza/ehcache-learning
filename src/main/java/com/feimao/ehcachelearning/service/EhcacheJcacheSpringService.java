package com.feimao.ehcachelearning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CacheResult;

/**
 * @Author: feimao
 * @Date: 19-1-30 下午7:17
 */
@Service
@Slf4j
public class EhcacheJcacheSpringService {

    @CacheResult(cacheName = "cache_10s")
    public String test(@CacheKey String k1) {
        log.info("not in cache but call real service");
        return "test";
    }
}
