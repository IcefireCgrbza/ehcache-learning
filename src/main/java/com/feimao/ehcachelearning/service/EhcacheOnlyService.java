package com.feimao.ehcachelearning.service;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.Duration;

import static com.feimao.ehcachelearning.constants.EhcacheConstant.persistenceStoragePath;

/**
 * @Author: feimao
 * @Date: 18-12-16 上午11:26
 */
@Service
@Slf4j
public class EhcacheOnlyService {

    public String test() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .with(CacheManagerBuilder.persistence(new File(persistenceStoragePath)))                 //持久化到硬盘的路径
                .withCache(                                                                              //cacheManager管理的一个cache
                        "cacheName",                                                                    //cache名
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(                              //cache配置
                                String.class,                                                                   //cache key类型
                                String.class,                                                                   //cache value类型
                                ResourcePoolsBuilder.newResourcePoolsBuilder()                                  //cache存储方式
                                        .heap(10, EntryUnit.ENTRIES)                                            //堆内
                                        .offheap(1, MemoryUnit.MB)                                              //堆外内存
                                        .disk(10, MemoryUnit.MB)                                                //持久化到硬盘
                        ).withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(20)))       //超时
                )
                .build();
        cacheManager.init();
        Cache<String, String> cache = cacheManager.getCache("cacheName", String.class, String.class);
        cache.put("k1", "v1");
        String v1 = cache.get("k1");
        cacheManager.removeCache("cacheName");
        cacheManager.close();
        log.info("value: {}", v1);
        return v1;
    }
}
