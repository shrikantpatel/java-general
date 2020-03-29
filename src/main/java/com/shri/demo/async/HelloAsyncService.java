package com.shri.demo.async;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloAsyncService {

	private static final Logger logger = LoggerFactory.getLogger(HelloAsyncService.class);

//	@Autowired
//	private RestTemplate restTemplate;

	private final RestTemplate restTemplate;

	@Autowired
	public HelloAsyncService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Async("customExecutor1")
	public CompletableFuture<String> hello(String user) throws InterruptedException {
		logger.info("Looking up " + user);
		String url = String.format("http://localhost:8080/helloserver", user);
		ResponseEntity<String> results = restTemplate.getForEntity(url, String.class);
		// Artificial delay of 1s for demonstration purposes
		Thread.sleep(1000L);
		return CompletableFuture.completedFuture(results.toString());
	}

}
