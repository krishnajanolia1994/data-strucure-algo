package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.model.Tree;
import com.krishna.algorithm.DSAlgo.service.TreeService;


@RestController
public class TreeController {
	
	@Autowired
	private TreeService treeService;
	
	
	@PostMapping(value  = AppConstants.TREE + AppConstants.ADD + AppConstants.NODE)
	public Tree addNode(@RequestParam("value") int value )
	{
		return treeService.addNode(value);;
		
	}
	
	@PostMapping(value  = AppConstants.TREE + AppConstants.DELETE + AppConstants.NODE)
	public Tree deleteNode(@RequestParam("value") int value )
	{
		return treeService.deleteNode(value);
	}
	
	@PostMapping(value  = AppConstants.TREE + AppConstants.GET + AppConstants.NODE)
	public Tree getNode(@RequestParam("value") int value )
	{
		return treeService.getNode(value);
	}
	
	@PostMapping(value  = AppConstants.AVL + AppConstants.TREE + AppConstants.ADD + AppConstants.NODE)
	public Tree addAvlNode(@RequestParam("value") int value )
	{
		return treeService.addAvlNode(value);
		
	}

}
