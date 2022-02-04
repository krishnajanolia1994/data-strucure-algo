package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.model.LinkedList;
import com.krishna.algorithm.DSAlgo.service.LinkedListService;

@Controller
public class LinkedListController {
	
	@Autowired
	private LinkedListService linkedListService;
	
	
	@GetMapping(value  = AppConstants.LINKED_LIST + AppConstants.NAME + AppConstants.SURNAME)
	public LinkedList addNode(@PathVariable("name") String name , @PathVariable("surname") String surname)
	{
		return linkedListService.AddNode(name, surname) ;  
		
	}
	
	@GetMapping(value  = AppConstants.LINKED_LIST + AppConstants.DELETE + AppConstants.BY_KEY)
	public LinkedList deleteNodeByKey(@PathVariable("name") String name)
	{
		return linkedListService.delete(name); 
		
	}
	
	@GetMapping(value  = AppConstants.LINKED_LIST + AppConstants.DELETE + AppConstants.BY_POSITION)
	public LinkedList deleteNodeByPosition(@PathVariable("index") int index)
	{
		return linkedListService.deleteByPosition(index); 
		
	}
	
	@GetMapping(value  = AppConstants.LINKED_LIST + AppConstants.FIND + AppConstants.LENGTH)
	public Integer findLength()
	{
		return linkedListService.findLength(); 
		
	}
	
	@GetMapping(value  = AppConstants.LINKED_LIST + AppConstants.FIND + AppConstants.LENGTH+AppConstants.RECURSION)
	public Integer findLengthByRecursion()
	{
		return linkedListService.findLengthByRecursion(); 
		
	}
	
	@GetMapping(value  = AppConstants.LINKED_LIST + AppConstants.SWAP)
	public LinkedList swap(@PathVariable("first") String first , @PathVariable("second") String second)
	{
		return linkedListService.swap(first,second); 
		
	}

  

}
