package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.service.AlgebraService;

@RestController
public class AlgebraController {
	@Autowired
	private AlgebraService algebraService;;
	@GetMapping(value  = AppConstants.GET + AppConstants.RTH+AppConstants.ROOT)
	public double getRthRoot(@RequestParam("root") int root , @RequestParam("number") int number)
	{
		return algebraService.getRthRoot(root, number);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM+AppConstants.PLATFORM)
	public double getMinimumPlatform(@RequestParam("ar") String [] ar,@RequestParam("dep") String [] dep)
	{
		return algebraService.getMinimumPlatform(ar, dep);
	}
}
