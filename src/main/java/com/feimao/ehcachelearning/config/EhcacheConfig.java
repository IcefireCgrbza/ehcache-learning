package com.feimao.ehcachelearning.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.jcache.JCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.cache.CacheManager;
import java.io.IOException;

import static com.feimao.ehcachelearning.constants.EhcacheConstant.ehcacheXmlPath;

/**
 * @Author: feimao
 * @Date: 18-12-16 下午2:03
 */
@Configuration
public class EhcacheConfig {

    @Bean
    public JCacheManagerFactoryBean jCacheManagerFactoryBean() throws IOException {
        JCacheManagerFactoryBean jCacheManagerFactoryBean = new JCacheManagerFactoryBean();
        jCacheManagerFactoryBean.setCacheManagerUri(new ClassPathResource(ehcacheXmlPath).getURI());
        return jCacheManagerFactoryBean;
    }

    @Bean(name = "cacheManager")
    public JCacheCacheManager jCacheCacheManager(@Qualifier("jCacheManagerFactoryBean") CacheManager jCacheManagerFactoryBean) {
        JCacheCacheManager jCacheCacheManager = new JCacheCacheManager();
        jCacheCacheManager.setCacheManager(jCacheManagerFactoryBean);
        return jCacheCacheManager;
    }
}
