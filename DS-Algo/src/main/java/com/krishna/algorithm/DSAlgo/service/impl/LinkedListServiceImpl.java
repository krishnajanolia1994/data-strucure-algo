package com.krishna.algorithm.DSAlgo.service.impl;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.model.DataStructure;
import com.krishna.algorithm.DSAlgo.model.LinkedList;
import com.krishna.algorithm.DSAlgo.service.LinkedListService;

@Component
public class LinkedListServiceImpl implements LinkedListService{
	DataStructure dataStructure = DataStructure.getDataStruture();


	@Override
	public LinkedList AddNode(String name, String surname) {
		
		LinkedList linkedList = dataStructure.getHead();
		
		LinkedList linkedListNode = new LinkedList();
		linkedListNode.setName(name);
		linkedListNode.setSurName(surname);
		linkedListNode.setNext(null);

		if(linkedList==null) {
			linkedListNode.setName(name);
			linkedListNode.setSurName(surname);
			linkedListNode.setNext(null);
			dataStructure.setHead(linkedListNode);
		}else {
			LinkedList temp = linkedList;
			LinkedList lastNode = getLastNode(temp);
			lastNode.setNext(linkedListNode);
		}
		
		return dataStructure.getHead();
		
	}


	private LinkedList getLastNode(LinkedList linkedList) {
		while(linkedList.getNext()!=null) {
			linkedList = linkedList.getNext();
		}
		return linkedList;
	}

}
