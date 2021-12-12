package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return sortingService.insertionSort(ar);
	}
	
	@PostMapping(value  = AppConstants.MERGE_SORT)
	public int [] mergeSort(@RequestBody int[] ar)
	{
		return sortingService.mergeSort(ar);
	}
	
	@PostMapping(value  = AppConstants.HEAP_SORT)
	public int [] heapSort(@RequestBody int[] ar)
	{
		return sortingService.heapSort(ar);
	}
	
	@PostMapping(value  = AppConstants.COUNTING_SORT)
	public int [] countingSort(@RequestBody int[] ar)
	{
		return sortingService.countingSort(ar);
	}
	
	@PostMapping(value  = AppConstants.INDEX_SORT)
	public int [] indexSort(@RequestBody int[] ar)
	{
		return sortingService.indexSort(ar);
	}
	

}
