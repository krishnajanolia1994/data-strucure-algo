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
		return linkedListService.AddNode(name, surname);
	}

  

}
