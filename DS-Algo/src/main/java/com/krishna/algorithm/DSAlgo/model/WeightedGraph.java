package com.krishna.algorithm.DSAlgo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {
	
	private boolean isIfinity;
	
	private int value;
	private int distance;
	
	private List<WeightedGraph> graphs = new ArrayList<WeightedGraph>();
	
	private Map<Integer, Integer> ditanceMap = new HashMap<Integer, Integer>();

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<WeightedGraph> getGraphs() {
		return graphs;
	}

	public void setGraphs(List<WeightedGraph> graphs) {
		this.graphs = graphs;
	}

	public Map<Integer, Integer> getDitanceMap() {
		return ditanceMap;
	}

	public void setDitanceMap(Map<Integer, Integer> ditanceMap) {
		this.ditanceMap = ditanceMap;
	}

	public boolean isIfinity() {
		return isIfinity;
	}

	public void setIfinity(boolean isIfinity) {
		this.isIfinity = isIfinity;
	}

	
}
