package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.service.SortingService;


@RestController
public class SortingController {
	
	@Autowired
	private SortingService sortingService;
	
	@PostMapping(value  = AppConstants.INSEERTION_SORT)
	public int [] insertionSort(@RequestBody int[] ar)
	{
		return sortingService.insertionSort(ar) ;
	}
	
	///  finding inversion
	
	@PostMapping(value  = AppConstants.MERGE_SORT)
	public int [] mergeSort(@RequestBody int[] ar)
	{
		return sortingService.mergeSort(ar) ;
	}
	
	@PostMapping(value  = AppConstants.HEAP_SORT)
	public int [] heapSort(@RequestBody int[] ar)
	{
		return sortingService.heapSort(ar) ;
	}
	
	@PostMapping(value  = AppConstants.COUNTING_SORT)
	public int [] countingSort(@RequestBody int[] ar)
	{
		return sortingService.countingSort(ar) ;
	}
	
	@PostMapping(value  = AppConstants.INDEX_SORT)
	public int [] indexSort(@RequestBody int[] ar)
	 {
		return sortingService.indexSort(ar) ;
	}
	
	@PostMapping(value  = AppConstants.SORT+ AppConstants.ALLMOST_SORT_ARRAY)
	public int [] sorartAlmostSoartArray(@RequestBody int[] ar)
	 {
		return sortingService.sorartAlmostSoartArray(ar) ;
	}
	
	@PostMapping(value  = AppConstants.SORT+ AppConstants.ARRANGE_IN_WAVE)
	public int [] arrangeArrayInWaveForm(@RequestBody int[] ar)
	 {
		return sortingService.arrangeArrayInWaveForm(ar) ;
	}
	
	@PostMapping(value  = AppConstants.SORT+ AppConstants.FIND_A_PAIR_HAVING_CLOSEST_SUM_TO_X)
	public int [] findAPairHavngClosesetSumToX(@RequestBody int[] ar, @RequestParam("x") int x)
	 {
		return sortingService.findAPairHavngClosesetSumToX(ar,x) ;
	}
	
	@PostMapping(value  = AppConstants.FIND_COUNT_OF_ONE)
	public int  findCountOfOne(@RequestBody int[] ar)
	 {
		return sortingService.findCountOfOne(ar) ;
	}
	
	@PostMapping(value  = AppConstants.FIND_MINIMUM_SWAP)
	public int  findMinimumSwap(@RequestBody int[] ar)
	 {
		return sortingService.findMinimumSwap(ar);
	}
	
	
	
}
