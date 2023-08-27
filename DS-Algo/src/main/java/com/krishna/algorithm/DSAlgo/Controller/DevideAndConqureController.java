package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.service.BackTrackingService;
import com.krishna.algorithm.DSAlgo.service.DevideAndConqureService;

@RestController
@RequestMapping("devide/conqure")
public class DevideAndConqureController {
	@Autowired
	private DevideAndConqureService devideAndConqureService;
	
	@GetMapping(value  = AppConstants.GET + AppConstants.NTH_POWER)
	public int getNthPowe(@RequestParam("number") int number,@RequestParam("n") int n)
	{
		return devideAndConqureService.getNthPowe(number,n);
	}
	

	
}
