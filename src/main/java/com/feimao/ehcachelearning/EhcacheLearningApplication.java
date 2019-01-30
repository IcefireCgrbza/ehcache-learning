package com.feimao.ehcachelearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EhcacheLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhcacheLearningApplication.class, args);
	}

}

