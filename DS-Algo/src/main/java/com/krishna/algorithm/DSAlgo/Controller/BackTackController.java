package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.service.BackTrackService;

@RestController
public class BackTackController {
	
	@Autowired
	private BackTrackService backTrackService;;
	@GetMapping(value  = AppConstants.GET +AppConstants.PERMUTATION)
	public String getPermutationOfString(@RequestParam("str") String str)
	{
		return backTrackService.getPermutationOfString(str)  ;
	}

}
