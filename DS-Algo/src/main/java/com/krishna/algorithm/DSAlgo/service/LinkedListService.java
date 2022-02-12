package com.krishna.algorithm.DSAlgo.service;

import com.krishna.algorithm.DSAlgo.model.LinkedList;

public interface LinkedListService {
	
	public LinkedList AddNode(String name, String surname)   ;

	public LinkedList delete(String name);

	public LinkedList deleteByPosition(int index);

	public Integer findLength();

	public Integer findLengthByRecursion();

	public LinkedList swap(String first, String second);

	public LinkedList getLinkedList();

	public LinkedList reverse();

}
