package com.krishna.algorithm.DSAlgo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value  = AppConstants.HASHING + AppConstants.FIND_SUB_ARRAR)
	public Integer findSubarray(@RequestParam("ar") int [] ar , @RequestParam("subArray") int [] subArray)
	{
		return hashingService.findSubarray(ar, subArray) ;
	}
	
	@GetMapping(value  = AppConstants.HASHING + AppConstants.FIND_INTESACTION_JOIN)
	public Integer findIntresactionAndJoin(@RequestParam("ar1") int [] ar1 , @RequestParam("ar2") int [] ar2)
	{
		return hashingService.findIntresactionAndJoin(ar1, ar2) ;
	}
	
	@GetMapping(value  = AppConstants.HASHING + AppConstants.FIND_TWO_NUMBER_HAVING_SUM)
	public Integer[] findTwoNumberHavingGivenSum(@RequestParam("ar") int [] ar , @RequestParam("sum") int sum)
	{
		return hashingService.findTwoNumberHavingGivenSum(ar,sum) ;
	}
	
	@GetMapping(value  = AppConstants.HASHING + AppConstants.FIND_DUPLICATE_IN_K_RANGE)
	public boolean findDuplicateInKRange(@RequestParam("ar") int [] ar , @RequestParam("range") int range)
	{
		return hashingService.findDuplicateInKRange(ar, range) ;
	}
	
	@PostMapping(value  = AppConstants.HASHING + AppConstants.FIND_ITINERARY)
	public Map<String, String> findItineary(@RequestBody Map<String, String> map)
	{
		return hashingService.findItineary(map) ;
	}
	
	@PostMapping(value  = AppConstants.HASHING + AppConstants.FIND_TOTAL_NUMBER_EMPLOYEE)
	public Map<String, Integer> findTotalEmployee(@RequestBody Map<String, String> map)
	{
		return hashingService.findTotalEmployee(map) ;
	}
	

	
}
