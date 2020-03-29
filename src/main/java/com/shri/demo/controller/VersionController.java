package com.shri.demo.controller;

import com.shri.demo.dto.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Slf4j
public class VersionController {

	@GetMapping(path = "/version")
	// @RequestMapping (method=RequestMethod.GET, path="/version")
	public ResponseEntity<String> getVersion() throws Exception {

		log.info("Version method called");
		Version version = new Version();
		version.setVersionNum("0.2");
		return ResponseEntity.ok(version.getVersionNum());
	}
}

