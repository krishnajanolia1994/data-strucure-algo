package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.service.BackTrackingService;

@RestController
@RequestMapping("back/track")
public class BackTrackingController {
	@Autowired
	private BackTrackingService BackTrackingService;
	
	@GetMapping(value  = AppConstants.GET + AppConstants.STRING+AppConstants.PERMUTATION)
	public double printStringPermutation(@RequestParam("str") String str)
	{
		return BackTrackingService.printStringPermutation(str);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.KNIGHT+AppConstants.TOUR)
	public boolean getKnightTour(@RequestParam("n") int n)
	{
		return BackTrackingService.printKnightTour(n);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.NQUEEN)
	public boolean getNqueen(@RequestParam("n") int n)
	{
		return BackTrackingService.getNqueen(n);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.HAMALTONIAAN_PATH)
	public boolean getHamltonianPath(@RequestParam("ar") int[][] ar)
	{
		return BackTrackingService.getHamltonianPath(ar);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.SUDOKU)
	public boolean getSudoku(@RequestParam("ar") int[][] ar)
	{
		return BackTrackingService.getSudoku(ar);
	}
}
