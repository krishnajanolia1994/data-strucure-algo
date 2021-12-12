package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.service.PeakService;


@RestController
public class PeakFindingController {
	
	@Autowired
	private PeakService peakService;
	
	@PostMapping(value  = AppConstants.PEAK_FIND+ AppConstants.ONED)
	public int getPeak(@RequestBody int[] ar)
	{
		return peakService.getAPeak(ar);
	}

}
