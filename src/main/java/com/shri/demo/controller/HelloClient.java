package com.shri.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shri.demo.service.HelloService;

@RestController
public class HelloClient {

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	private HelloService helloService;

	@GetMapping(path = "/helloclient")
	public String callHelloServer() {
		return helloService.hello();

	}

}
