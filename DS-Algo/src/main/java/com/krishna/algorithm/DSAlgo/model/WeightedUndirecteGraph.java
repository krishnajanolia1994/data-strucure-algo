package com.krishna.algorithm.DSAlgo.model;

public class WeightedUndirecteGraph {
	
	private int value;
	private  int searchNumber;
	
	private int totalNode = 0;
	
	private int arraySize = 5;
	
	private WeightedUndirecteGraph [] graphs = new WeightedUndirecteGraph[5];
	
	private int[] distences = new int [5];
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getSearchNumber() {
		return searchNumber;
	}
	public void setSearchNumber(int searchNumber) {
		this.searchNumber = searchNumber;
	}
	public WeightedUndirecteGraph[] getGraphs() {
		return graphs;
	}
	public void setGraphs(WeightedUndirecteGraph[] graphs) {
		this.graphs = graphs;
	}
	public int[] getDistences() {
		return distences;
	}
	public void setDistences(int[] distences) {
		this.distences = distences;
	}
	public int getTotalNode() {
		return totalNode;
	}
	public void setTotalNode(int totalNode) {
		this.totalNode = totalNode;
	}
	public int getArraySize() {
		return arraySize;
	}
	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}
	
	
	

}
