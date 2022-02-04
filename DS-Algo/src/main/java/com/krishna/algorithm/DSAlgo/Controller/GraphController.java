package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.service.GraphService;

@RestController
public class GraphController {
	@Autowired
	private GraphService graphService;;
	@GetMapping(value  = AppConstants.GRAPH + AppConstants.ADD+AppConstants.NODE)
	public String addNode(@RequestParam("sourse") int sourse , @RequestParam("destination") int destination)
	{
		return graphService.addNode(sourse, destination);
	}
	
	@GetMapping(value  = AppConstants.WEIGHT+AppConstants.GRAPH + AppConstants.ADD+AppConstants.NODE)
	public String addNode(@RequestParam("sourse") int sourse , @RequestParam("destination") int destination, @RequestParam("distance") int distance)
	{
		return graphService.addNode(sourse, destination,distance);
	}
	
	@GetMapping(value  = AppConstants.DIJEKSTRA)
	public String dijkstra(@RequestParam("sourse") int sourse , @RequestParam("destination") int destination)
	{
		return graphService.dijkstra(sourse, destination) ;
	}
	
	@GetMapping(value  = AppConstants.BELLMANFORD)
	public String ballmanFoard(@RequestParam("sourse") int sourse , @RequestParam("destination") int destination)
	{
		return graphService.bellmanFord(sourse, destination);
	}
	
	@GetMapping(value  = AppConstants.GRAPH + AppConstants.DFS)
	public String DFS()
	{
		return graphService.DFS();
	}
}
