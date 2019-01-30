package com.feimao.ehcachelearning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;

/**
 * @Author: feimao
 * @Date: 19-1-30 上午11:54
 */
@Service
@Slf4j
public class EhcacheJcacheOnlyService {

    public String test() {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();
        MutableConfiguration<String, String> configuration = new MutableConfiguration<String, String>()
                .setTypes(String.class, String.class)
                .setStoreByValue(false)
                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ONE_MINUTE));
        Cache<String, String> cache = cacheManager.createCache("jcache", configuration);
        cache.put("k1", "v1");
        String v1 = cache.get("k1");
        cacheManager.destroyCache("jcache");
        log.info("v1: {}", v1);
        return v1;
    }
}
