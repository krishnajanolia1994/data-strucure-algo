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
		
		LinkedList linkedList = dataStructure.getHead()
		
		LinkedList linkedListNode = new LinkedList()
		
		linkedListNode.setName(name)
		linkedListNode.setSurName(surname)
		
		linkedListNode.setNext(null)
		

		if(linkedList==null) {
			linkedListNode.setName(name);
			
			linkedListNode.setSurName(surname)
			linkedListNode.setNext(null)
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
		if(linkedList.getName().equals(name)) {
			dataStructure.setHead(linkedList.getNext());
			return dataStructure.getHead();

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
		LinkedList temp = head;
		while(temp.getNext()!=null) {
			if( temp.getNext().getName().equals(name))
				parent = temp;
			temp=temp.getNext();
		}
				
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
		if(first==second) {
			System.out.println("same element");
			return dataStructure.getHead();
		}
		
		LinkedList linkedList = dataStructure.getHead();
		if(linkedList.getName().equals(first)||linkedList.getName().equals(second)) {
			LinkedList firstNode = null;
			LinkedList secondNodeParent = null;
			firstNode = linkedList;

			if(linkedList.getName().equals(first)) {
				while(linkedList.getNext()!=null) {
					if(linkedList.getNext().getName().equals(second)) {
						secondNodeParent = linkedList;
					}
					linkedList=linkedList.getNext();
				}
				swapNode(linkedList, firstNode, secondNodeParent);
			}else {
				while(linkedList.getNext()!=null) {
					if(linkedList.getNext().getName().equals(first)) {
						secondNodeParent = linkedList;
					}
					linkedList=linkedList.getNext();

				}
				swapNode(linkedList, firstNode, secondNodeParent);
			}
				
		}else {
			LinkedList fistParent = null;
			LinkedList secondParent = null;
			boolean fistFount =false;
			boolean seondFound = false;
			while(linkedList.getNext()!=null) {
				
				if(!fistFount&&linkedList.getNext().getName().equals(first)) {
					fistFount= true;
					fistParent= linkedList;
				}else if(!seondFound&&linkedList.getNext().getName().equals(second)) {
					seondFound=true;
					secondParent=linkedList;
				}else if(fistFount&& seondFound)
					break;
				linkedList=linkedList.getNext();
				
			}
			if(fistParent!=null&&secondParent!=null) {
				LinkedList firstNode = fistParent.getNext();
				LinkedList firstChild = firstNode.getNext();
				LinkedList secondNode = secondParent.getNext();
				LinkedList secondChild = secondNode.getNext();
				secondParent.setNext(firstNode);
				firstNode.setNext(secondChild);
				fistParent.setNext(secondNode);
				secondNode.setNext(firstChild);
			}
		}
		 
		return dataStructure.getHead(); 
	}


	private void swapNode(LinkedList linkedList, LinkedList firstNode, LinkedList secondNodeParent) {
		if(secondNodeParent!=null) {
			LinkedList firstChildNode = firstNode.getNext();
			LinkedList secondChildNode = secondNodeParent.getNext().getNext();
			LinkedList secondNode = secondNodeParent.getNext();
			secondNode.setNext(firstChildNode);
			secondNodeParent.setNext(firstNode);
			firstNode.setNext(secondChildNode);
			dataStructure.setHead(secondNode);
		}
	}


	@Override
	public LinkedList getLinkedList() {
		return dataStructure.getHead();
	}


	@Override
	public LinkedList reverse() {
		LinkedList head = dataStructure.getHead();
		reverse(head,true);
		return dataStructure.getHead();
	}


	private LinkedList reverse(LinkedList head,boolean isHead) {
		if(head.getNext()==null) {
			dataStructure.setHead(head);
			return head;
		}
		LinkedList next = head.getNext();
		if(isHead) {
			head.setNext(null);
			isHead=false;
		}
		LinkedList reverse = reverse(next,isHead); 
		reverse.setNext(head);
		return head;
	}


	
}
