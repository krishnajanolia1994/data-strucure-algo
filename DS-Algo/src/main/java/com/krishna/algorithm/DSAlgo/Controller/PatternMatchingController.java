package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.service.PatternService;

@RestController
public class PatternMatchingController {
	
	@Autowired
	private PatternService patternService;
	
	@GetMapping(value  = AppConstants.PATTERN + AppConstants.MATCH)
	public Integer addNode(@RequestParam("pattern") String pattern , @RequestParam("string") String string)
	{
		return patternService.findPositionPatternInStringIfAny(pattern, string);
	}

}
