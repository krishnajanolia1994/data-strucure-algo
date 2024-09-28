package com.example.krishna.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("name")
public class MyController {
	
	@RequestMapping(value = "/name", method = RequestMethod.POST)
	public ResponseEntity<String> get(@RequestParam("name") String name) {
		
		return new ResponseEntity<>(name, HttpStatus.ACCEPTED);
	}
}
