package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.model.Graph;
import com.krishna.algorithm.DSAlgo.model.WeightedGraph;
import com.krishna.algorithm.DSAlgo.service.GraphService;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



@Component
public class GraphServiceImpl implements GraphService{
	
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";


	
	private static Graph head;
	private static WeightedGraph weightedGraphHead;
	private static int totalHead; 

	@Override
	public String addNode(int sourse, int destination) {
		String response = ""; 
		if(head==null) {  
			head = new Graph();
			Graph destinationGraph = new Graph();
			head.setValue(sourse);
			destinationGraph.setValue(destination);
			head.getGraphs().add(destinationGraph);
		}else {
			
			Graph parentAndChild[] = getParent(sourse, destination);
			if(parentAndChild[0]==null) {
				response = "could not found sourse";
			}else {
				parentAndChild[0].getGraphs().add(parentAndChild[1]);
					response = "the destination has been added";
			}
		}
		return response;
	}



	private boolean validateParent(Graph parent, int destination) {
		boolean isValidParent = true;
		for(Graph graph : parent.getGraphs()) {
			if(graph.getValue()==destination) {
				isValidParent= false;
			}
		}
		return isValidParent;
	}



	private Graph[] getParent(int sourse, int destination) {
		
		Graph[] graphsToBeReturn = new Graph[2];
		int count =0;
		LinkedList<Graph> graphs = new LinkedList<Graph>();
		Map<Integer, Boolean> isVisited = new HashMap<Integer, Boolean>();
		graphs.addLast(head);
		isVisited.put(head.getValue(), true);
		while(!graphs.isEmpty()) {
			Graph currentGraph = graphs.removeFirst();
			System.out.println(count + " the value "+ currentGraph.getValue());
			count ++;
			if(currentGraph.getValue()==sourse)
				graphsToBeReturn[0]= currentGraph;
			if(currentGraph.getValue()==destination)
				graphsToBeReturn[1]= currentGraph;

			for(Graph child : currentGraph.getGraphs()) {
				if(isVisited.get(child.getValue())==null) {
					isVisited.put(child.getValue(), true);
					graphs.addLast(child);
				}
			}
		}
		if(graphsToBeReturn[1]==null) {
			Graph destinationGraph = new Graph();
			destinationGraph.setValue(destination);
			graphsToBeReturn[1]=destinationGraph;
		}
		
		return graphsToBeReturn;
	}



	@Override
	public String DFS() {
		int count = 0;
		
		
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		LinkedList< Graph> graphs =new LinkedList<Graph>();
		graphs.add(head);
		visited.put(head.getValue(), true);
		String DFS = ""+head.getValue();
		System.out.println(count+" value of current is "+ head.getValue());
		while(!graphs.isEmpty()) {
			boolean isEmpty = true;
			Graph current = graphs.getFirst();
			for(Graph child: current.getGraphs()) {
				if(visited.get(child.getValue())==null) {
					visited.put(child.getValue(), true);
					graphs.addFirst(child);
					isEmpty=false;
					DFS+=" "+ child.getValue();
					System.out.println(count+" value of current is "+ child.getValue());

					break;

				}
			}
			if(isEmpty) {
				graphs.removeFirst();
			}
		}
		
		return DFS;
	}



	@Override
	public String addNode(int sourse, int destination, int distance) {
		String response = "";
		if(weightedGraphHead==null) {
			weightedGraphHead = new WeightedGraph();
			WeightedGraph destinationGraph = new WeightedGraph();
			weightedGraphHead.setValue(sourse);
			destinationGraph.setValue(destination);
			weightedGraphHead.getDitanceMap().put(destination, distance);
			weightedGraphHead.getGraphs().add(destinationGraph);
			response = "the destination has been added";

			
			
		}else {
			
			WeightedGraph parentAndChild[] = getParentWightGraph(sourse, destination);
			if(parentAndChild[0]==null) {
				response = "could not found sourse";
			}else {
				if(parentAndChild[0].getDitanceMap().get(destination)!=null){
					if(parentAndChild[0].getDitanceMap().get(destination)>distance) {
						parentAndChild[0].getDitanceMap().put(destination, distance);
						response = "the destination distance has been updated";
					}else {
						response = "the destination alraidy exixst with less distence";
					}
				}else {
					parentAndChild[0].getDitanceMap().put(destination, distance);
					parentAndChild[0].getGraphs().add(parentAndChild[1]);
					response = "the destination has been added";

				}
			}
		}
		return response;	}



	private WeightedGraph[] getParentWightGraph(int sourse, int destination) {
		totalHead=0;
		WeightedGraph[] graphsToBeReturn = new WeightedGraph[2];
		int count =0;
		LinkedList<WeightedGraph> graphs = new LinkedList<WeightedGraph>();
		Map<Integer, Boolean> isVisited = new HashMap<Integer, Boolean>();
		graphs.addLast(weightedGraphHead);
		isVisited.put(weightedGraphHead.getValue(), true);
		while(!graphs.isEmpty()) {
			totalHead++;
			WeightedGraph currentGraph = graphs.removeFirst();
			currentGraph.setIfinity(true);
			System.out.println(count + " the value "+ currentGraph.getValue());
			count ++;
			if(currentGraph.getValue()==sourse)
				graphsToBeReturn[0]= currentGraph;
			if(currentGraph.getValue()==destination)
				graphsToBeReturn[1]= currentGraph;

			for(WeightedGraph child : currentGraph.getGraphs()) {
				if(isVisited.get(child.getValue())==null) {
					isVisited.put(child.getValue(), true);
					graphs.addLast(child);
				}
			}
		}
		if(graphsToBeReturn[1]==null) {
			WeightedGraph destinationGraph = new WeightedGraph();
			destinationGraph.setValue(destination);
			graphsToBeReturn[1]=destinationGraph;
		}
		
		return graphsToBeReturn;

	}



	@Override
	public String dijkstra(int sourse, int destination) {
		String response = "";
		
		WeightedGraph[] prentChild=  getParentWightGraph(sourse, destination) ;
		WeightedGraph graph = prentChild[0];
		if(graph==null||prentChild[1]==null) {
			response="sourse does not exist";
		}else {
			 
			normaliseDistance(graph);
			response = "the distance of source and destination is equals to "+ prentChild[1].getDistance();
		}
		
		
		return response;
	}
	
	private void normaliseDistance(WeightedGraph parent) {
		int count =0;
		LinkedList<WeightedGraph> graphs = new LinkedList<WeightedGraph>();
		Map<Integer, Boolean> isVisited = new HashMap<Integer, Boolean>();
		parent.setDistance(0);
		graphs.addLast(parent);
		isVisited.put(parent.getValue(), true);
		while(!graphs.isEmpty()) {
			WeightedGraph currentGraph = graphs.removeFirst();
			System.out.println(count + " the value "+ currentGraph.getValue());
			count ++;
			
			for(WeightedGraph child : currentGraph.getGraphs()) {
				int newDistance = currentGraph.getDistance()+ currentGraph.getDitanceMap().get(child.getValue());
				if(child.isIfinity()) {
					child.setIfinity(false);
					child.setDistance(newDistance);
				}else if(newDistance<child.getDistance()) {
					child.setDistance(newDistance);
				}
				if(isVisited.get(child.getValue())==null) {
					
					isVisited.put(child.getValue(), true);
					graphs.addLast(child);
				}
			}
		}
		
	}



	@Override
	public String bellmanFord(int sourse, int destination) {
		String algorithm = "SHA-256"; // if you perfer SHA-2
//        String algorithm = "SHA3-256";

        String pText = "Hello World";
        System.out.println(String.format(OUTPUT_FORMAT, "Input (string)", pText));
        System.out.println(String.format(OUTPUT_FORMAT, "Input (length)", pText.length()));

        byte[] shaInBytes = digest(pText.getBytes(UTF_8), algorithm);
        System.out.println(String.format(OUTPUT_FORMAT, algorithm + " (hex) ", bytesToHex(shaInBytes)));
        // fixed length, 32 bytes, 256 bits.
        System.out.println(String.format(OUTPUT_FORMAT, algorithm + " (length)", shaInBytes.length));

        Base64 base64 = new Base64();
        System.out.println(new String(base64.decode("krishna".getBytes())));
		
		String response = "";
		
		WeightedGraph[] prentChild=  getParentWightGraph(sourse, destination) ;
		WeightedGraph graph = prentChild[0];
		if(graph==null||prentChild[1]==null) {
			response="sourse does not exist";
		}else {
			
			for(int count =0;count< totalHead;count++ ) {
				normaliseDistance(graph);
			}
			
			response = "the distance of source and destination is equals to "+ prentChild[1].getDistance();
		}
		
		
		

		return response;
	}
	
	private byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }
	
	private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    } 

}
