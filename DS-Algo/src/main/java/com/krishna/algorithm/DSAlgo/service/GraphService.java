package com.krishna.algorithm.DSAlgo.service;

public interface GraphService {
	public String addNode(int sourse, int destination);	
	
	public String DFS();
	
	public String addNode(int sourse,int destination, int distance);
	
	public String dijkstra(int sourse, int destination);
	
	public String bellmanFord(int sourse, int destination);

}