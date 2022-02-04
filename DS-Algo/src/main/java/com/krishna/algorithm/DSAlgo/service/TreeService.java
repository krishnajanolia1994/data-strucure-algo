package com.krishna.algorithm.DSAlgo.service;

import com.krishna.algorithm.DSAlgo.model.Tree;

public interface TreeService {
	
	public Tree addNode(int value);

	public Tree deleteNode(int value);

	public Tree getNode(int value);

	public Tree addAvlNode(int value);


}
