package com.krishna.algorithm.DSAlgo.model;

import java.util.ArrayList;
import java.util.List;


public class DataStructure {
private List<String> list = new ArrayList<String>();
	
	private LinkedList head = null;
	
	private CircularLinkedList headCircularLinkedList = null;
	
	private CircularLinkedList tailCircularLinkedList = null;

	
	private LinkedList linkedList = null;
	
	private WeightedUndirecteGraph weightedUndirecteGraph = null;
	
	private boolean accessWeightedUndirecteGraph = true;
	
	
	
	private static DataStructure dataStrucure = null;
	
	private DataStructure() {}
	
	public static synchronized DataStructure getDataStruture() {
		
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

	public CircularLinkedList getHeadCircularLinkedList() {
		return headCircularLinkedList;
	}

	public void setHeadCircularLinkedList(CircularLinkedList headCircularLinkedList) {
		this.headCircularLinkedList = headCircularLinkedList;
	}

	public CircularLinkedList getTailCircularLinkedList() {
		return tailCircularLinkedList;
	}

	public void setTailCircularLinkedList(CircularLinkedList tailCircularLinkedList) {
		this.tailCircularLinkedList = tailCircularLinkedList;
	}

	public WeightedUndirecteGraph getWeightedUndirecteGraph() {
		return weightedUndirecteGraph;
	}

	public void setWeightedUndirecteGraph(WeightedUndirecteGraph weightedUndirecteGraph) {
		this.weightedUndirecteGraph = weightedUndirecteGraph;
	}

	public boolean isAccessWeightedUndirecteGraph() {
		return accessWeightedUndirecteGraph;
	}

	public void setAccessWeightedUndirecteGraph(boolean accessWeightedUndirecteGraph) {
		this.accessWeightedUndirecteGraph = accessWeightedUndirecteGraph;
	}

	
	
	

}
