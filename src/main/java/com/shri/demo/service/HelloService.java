package com.shri.demo.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HelloService {

	private final RestTemplate restTemplate;
	private static String originalCalled;

	public HelloService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "reliable",
			commandProperties = { @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "1"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")})
	public String hello() {
		URI uri = URI.create("http://localhost:8080/helloserver");
		originalCalled = "original method CALLED";
		return this.restTemplate.getForObject(uri, String.class);
	}

	public String reliable() {
		String returnString = "Hello World Backup!!" + originalCalled;
		originalCalled = "original method SKIPPED";
		return returnString;
	}
}
