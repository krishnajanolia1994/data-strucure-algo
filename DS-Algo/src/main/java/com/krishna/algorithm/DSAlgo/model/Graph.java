package com.krishna.algorithm.DSAlgo.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private int value ; 
	
	private List<Graph> graphs = new ArrayList<>();

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Graph> getGraphs() {
		return graphs;
	}

	public void setGraphs(List<Graph> graphs) {
		this.graphs = graphs;
	}
	
	
	
	

}
