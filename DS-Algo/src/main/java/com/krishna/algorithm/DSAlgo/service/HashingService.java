package com.krishna.algorithm.DSAlgo.service;

import java.util.Map;

import com.krishna.algorithm.DSAlgo.model.HashNode;

public interface HashingService {
	public HashNode [] addNode(int key, int value);

	public Integer findSubarray(int ar [], int [] subArray);

	public Integer findIntresactionAndJoin(int[] ar1, int[] ar2);

	public Integer[] findTwoNumberHavingGivenSum(int[] ar, int sum);

	public boolean findDuplicateInKRange(int[] ar, int range);

	public Map<String, String> findItineary(Map<String, String> map);

	public Map<String, Integer> findTotalEmployee(Map<String, String> map);	

}
