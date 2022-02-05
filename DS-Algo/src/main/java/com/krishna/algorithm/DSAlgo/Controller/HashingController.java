package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.model.HashNode;
import com.krishna.algorithm.DSAlgo.service.HashingService;
//A RestController for handling request related to hashing 
@RestController
public class HashingController {
	//to add hashingService
	@Autowired
	private HashingService hashingService;
	//to add a node in hashmap 
	@GetMapping(value  = AppConstants.HASHING + AppConstants.ADD+AppConstants.ELEMENT)
	public HashNode[] addNode(@RequestParam("key") int key , @RequestParam("value") int value)
	{
		return hashingService.addNode(key, value) ;
	}
}
