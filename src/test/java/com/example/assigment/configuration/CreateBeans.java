package com.example.assigment.configuration;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateBeans {
	@Bean
	TestRestTemplate create() {
		return new TestRestTemplate();
	}
}
