package com.krishna.algorithm.DSAlgo.model;

import java.util.ArrayList;
import java.util.List;


public class DataStructure {
private List<String> list = new ArrayList<String>();
	
	private LinkedList head = null;
	
	private LinkedList linkedList = null;
	
	
	
	private static DataStructure dataStrucure = null;
	
	private DataStructure() {}
	
	public static DataStructure getDataStruture() {
		
		if(dataStrucure == null) {
			dataStrucure = new DataStructure();
		}
		return dataStrucure;
		
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public LinkedList getLinkedList() {
		return linkedList;
	}

	public void setLinkedList(LinkedList linkedList) {
		this.linkedList = linkedList;
	}

	public LinkedList getHead() {
		return head;
	}

	public void setHead(LinkedList head) {
		this.head = head;
	}
	

}
