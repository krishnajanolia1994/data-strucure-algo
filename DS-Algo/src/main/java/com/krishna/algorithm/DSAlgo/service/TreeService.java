package com.krishna.algorithm.DSAlgo.service;

import com.krishna.algorithm.DSAlgo.model.Tree;

public interface TreeService {
	
	public Tree addNode(int value) ;

	public Tree deleteNode(int value);

	public Tree getNode(int value);

	public Tree addAvlNode(int value);

	public Tree inorder();

	public Tree preorder();

	public Tree postorder();

	public int getDiameter();

	public Tree convertIntoThreadeBinaryTree(int[] inorder, int[] preorder);

	public String copyTreeWithRandomNode(int[] values);

	public String getWidth();

	public void isBst();

	public Integer getLCA(int value, int value1);

	public Tree getKthSmallestElement(int maxCount);

	public String[] huffmanCoading(int[] values, char[] character);



}
