package com.shri.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServerController {

	@GetMapping(path="/helloserver" )
	public ResponseEntity<String> getHello() {
		return ResponseEntity.ok("Hello World!");
	}
	
}
