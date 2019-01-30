package com.feimao.ehcachelearning.controller;

import com.feimao.ehcachelearning.service.EhcacheJcacheOnlyService;
import com.feimao.ehcachelearning.service.EhcacheJcacheSpringService;
import com.feimao.ehcachelearning.service.EhcacheOnlyService;
import com.feimao.ehcachelearning.service.EhcacheSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: feimao
 * @Date: 18-12-16 上午11:25
 */
@RestController
@RequestMapping(value = "/ehcache")
public class EhcacheTestController {

    @Autowired
    private EhcacheOnlyService ehcacheOnlyService;

    @Autowired
    private EhcacheSpringService ehcacheSpringService;

    @Autowired
    private EhcacheJcacheOnlyService ehcacheJcacheOnlyService;

    @Autowired
    private EhcacheJcacheSpringService ehcacheJcacheSpringService;

    @GetMapping(value = "/only")
    public String onlyTest() {
        return ehcacheOnlyService.test();
    }

    @GetMapping(value = "/spring")
    public String springTest() {
        return ehcacheSpringService.test("k1");
    }

    @GetMapping(value = "/jcache/only")
    public String jcacheOnlyTest() {
        return ehcacheJcacheOnlyService.test();
    }

    @GetMapping(value = "/jcache/spring")
    public String jcacheSpringTest() {
        return ehcacheJcacheSpringService.test("k1");
    }
}
