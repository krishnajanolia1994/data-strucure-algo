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


	@Override
	public LinkedList delete(String name) {
		
		LinkedList linkedList = dataStructure.getHead();
		
		if(linkedList==null)
			return linkedList;
		if(linkedList.getName()==name) {
			dataStructure.setHead(linkedList.getNext());
		}
		
		LinkedList parent = getParentNode(dataStructure.getHead(),name);
		if(parent!=null) {
			
			LinkedList grandChild = parent.getNext().getNext();
			parent.setNext(grandChild);
			
		}
		return dataStructure.getHead();
	}


	private LinkedList getParentNode(LinkedList head, String name) {
		LinkedList parent = null;
		if(head.getNext().getName()==name)
			parent = head.getNext();
		
		return parent;
	}


	@Override
	public LinkedList deleteByPosition(int index) {
		LinkedList linkedList = dataStructure.getHead();
		
		if(linkedList==null)
			return linkedList;
		
		LinkedList parent = getParentNodeByIndex(dataStructure.getHead(), index);
		if(parent!=null) {
			
			LinkedList grandChild = parent.getNext().getNext();
			parent.setNext(grandChild);
			
		}
		
		return dataStructure.getHead();
	}


	private LinkedList getParentNodeByIndex(LinkedList head, int index) {
		for(int i=0 ;i<index-1 ;i++) {
			head=head.getNext();
		}
		return head;
	}


	@Override
	public Integer findLength() {
		
		int count = 0;
		if(dataStructure.getHead()!=null) {
			LinkedList linkedList = dataStructure.getHead();
			while(linkedList!=null) {
				count++;
				linkedList=linkedList.getNext();
			}
		}
		return count;
	}


	@Override
	public Integer findLengthByRecursion() {
		LinkedList linkedList = dataStructure.getHead();
		int length=getLength(linkedList);
		return length;
	}


	private int getLength(LinkedList head) {
		if(head==null)
			return 0;
		return 1+getLength(head.getNext());
	}


	@Override
	public LinkedList swap(String first, String second) {
		// TODO Auto-generated method stub
		return null; 
	}


	
}
