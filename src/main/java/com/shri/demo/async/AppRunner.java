package com.shri.demo.async;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
	
	@Autowired
	private HelloAsyncService helloAsyncService;

	@Override
	public void run(String... args) throws Exception {
		// Start the clock
		long start = System.currentTimeMillis();

		// Kick of multiple, asynchronous lookups
		CompletableFuture<String> page1 = helloAsyncService.hello("test 1");
		CompletableFuture<String> page2 = helloAsyncService.hello("test 2");
		CompletableFuture<String> page3 = helloAsyncService.hello("test 3");

		// Wait until they are all done
		CompletableFuture.allOf(page1,page2,page3).join();

		// Print results, including elapsed time
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
		logger.info("--> " + page1.get());
		logger.info("--> " + page2.get());
		logger.info("--> " + page3.get());

	}
	
	
}
