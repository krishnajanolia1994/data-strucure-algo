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
		return treeService.addNode(value);	
	}
	
	@PostMapping(value  = AppConstants.TREE + AppConstants.DELETE + AppConstants.NODE)
	public Tree deleteNode(@RequestParam("value") int value )
	{
		return treeService.deleteNode(value) ;
	}
	
	@PostMapping(value  = AppConstants.TREE + AppConstants.GET + AppConstants.NODE)
	public Tree getNode(@RequestParam("value") int value )
	{
		return treeService.getNode(value) ;
	}
	
	@PostMapping(value  = AppConstants.TREE + AppConstants.GET + AppConstants.LCA)
	public Integer getLCA(@RequestParam("value") int value,@RequestParam("value1") int value1 )
	{
		return treeService.getLCA(value,value1) ;
	}
	
	@PostMapping(value  = AppConstants.TREE + AppConstants.GET + AppConstants.KTH_SMALLEST_ELEMENT)
	public Tree getKthSmallestElement(@RequestParam("maxCount") int maxCount )
	{
		return treeService.getKthSmallestElement(maxCount) ;
	}
	
	@PostMapping(value  = AppConstants.IS_BST)
	public void isBst()
	{
		treeService.isBst() ;
		
	}
	
	@PostMapping(value  = AppConstants.AVL + AppConstants.TREE + AppConstants.ADD+AppConstants.NODE )
	public Tree addAvlNode(@RequestParam("value") int value )
	{
		return treeService.addAvlNode(value) ;
		
	}
	
	
	
	@PostMapping(value  =  AppConstants.TREE + AppConstants.INORDER)
	public Tree inorderTraves()
	{
		return treeService.inorder() ;
		
	}
	
	@PostMapping(value  =  AppConstants.TREE + AppConstants.PREORDER)
	public Tree preorderTraves()
	{
		return treeService.preorder() ;
		
	}
	
	@PostMapping(value  = AppConstants.TREE + AppConstants.POSTORDER)
	public Tree postorderTraves()
	{
		return treeService.postorder() ;
		
	}
	
	@PostMapping(value  =   AppConstants.TREE + AppConstants.DIAMETER)
	public int getDiameter()
	{
		return treeService.getDiameter() ;
		
	}
	
	@PostMapping(value  = AppConstants.TREE+AppConstants.OTHER + AppConstants.ADD + AppConstants.NODE)
	public Tree addNodeInOtherTree(@RequestParam("value") int value )
	{
		return treeService.addNode(value);	
	}
	
	@PostMapping(value  = AppConstants.TREE+AppConstants.CONVERT+AppConstants.THREADE__INTO_BINARY_TREE)
	public Tree convertIntoThreadeBinaryTree(@RequestParam("inorder") int[] inorder,@RequestParam("preorder") int[] preorder )
	{
		return treeService.convertIntoThreadeBinaryTree(inorder,preorder);	
	}
	
	@PostMapping(value  = AppConstants.TREE+AppConstants.COPY_WITH_RANDOM_NODE)
	public String copyTreeWithRandomNode(@RequestParam("values") int[] values)
	{
		return treeService.copyTreeWithRandomNode(values);	
	}
	
	@PostMapping(value  = AppConstants.TREE+AppConstants.WIDTH)
	public String getWidth(@RequestParam("values") int[] values)
	{
		return treeService.getWidth();	
	}
	
	@PostMapping(value  = AppConstants.TREE+AppConstants.HUFFMAN_COADING)
	public String[] huffmanCoading(@RequestParam("values") int[] values, @RequestParam("character") char [] character)
	{
		return treeService.huffmanCoading(values,character);	
	}

}
