package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.model.HashNode;
import com.krishna.algorithm.DSAlgo.service.HashingService;



@Component
public class HashingServiceImpl implements HashingService{
	
	private HashNode hashNodes[] = new HashNode[100];
	private static  Random random = new Random();
	private static  int a= random.nextInt();
	private static  int b= random.nextInt();


	@Override
	public HashNode[] addNode(int key, int value) {
		int largeKey = a*(b+key);
		if(largeKey<0) {
			largeKey*=-1;
		}
		int hashKey = largeKey%100; 
		HashNode hashNodeNew = new HashNode();
		hashNodeNew.setKey(key);
		hashNodeNew.setValue(value);
		hashNodeNew.setNext(null);
		if(hashNodes[hashKey]==null) {
			hashNodes[hashKey]= hashNodeNew;
		}else {
			addHashNode(hashNodes[hashKey],hashNodeNew);  
		}
			
		return hashNodes;
	}

 
	private void addHashNode(HashNode hashNode, HashNode hashNodeNew) {
		while(hashNode.getNext()!=null) {
			hashNode=hashNode.getNext();
		}
		hashNode.setNext(hashNodeNew);
	}


	@Override
	public Integer findSubarray(int []ar, int [] subArray) {
		int index =-1;
		if(ar.length!=0&& subArray.length!=0&&subArray.length<=ar.length) {
			int subarrayLength = subArray.length;
			int arrayLength = ar.length;
			
			int arraySum = 0;
			int subaraySum = 0;
			int sum = 0;
			
			for(int i=0;i<subarrayLength;i++)
			{
				subaraySum +=(subArray[i]*(i+1));
				arraySum +=(ar[i]*(i+1));
				sum +=(ar[i]);

			}
			
			for(int i=0;i<=(arrayLength-subarrayLength);i++) {
				if(arraySum==subaraySum && isMatch(ar,subArray,i,subarrayLength)) {
					index =i;
					break;
				}
				if(i+subarrayLength==arrayLength)
					break;
				arraySum-=sum;
				arraySum+=ar[i+subarrayLength]*subarrayLength;
				sum-=ar[i];
				sum+=ar[i+subarrayLength];
				
				
			}
		}
		return index;
	}


	private boolean isMatch(int[] ar, int[] subArray, int start, int arrayLength) {
		boolean isMatch = true;
		
		for(int i=0;i<arrayLength;i++) {
			if(subArray[i]!=ar[start])
			{
				isMatch=false;
				break;
			}
			start++;
		}
		return isMatch;
	}


	@Override
	public Integer findIntresactionAndJoin(int[] ar1, int[] ar2) {
		int l1 = ar1.length;
		int l2 = ar2.length;
		
		if(l1>0&&l2>0) {
			if(l1<l2) {
				printIntersaction(ar1,l1,ar2,l2);
			}else {
				printIntersaction(ar2,l2,ar1,l1);

			}
		}
		return 0;
	}


	private void printIntersaction(int[] ar1, int l1, int[] ar2, int l2) {
		Map<Integer, Integer> map =new HashMap<Integer, Integer>();
		Map<Integer, Integer> visited =new HashMap<Integer, Integer>();
		for(int i=0;i<l1;i++)
			map.put(ar1[i], ar1[i]);
		String intersaction = "";
		String join = "";
		for(int i=0;i<l2;i++) {
			if(visited.get(ar2[i])==null) {
				visited.put(ar2[i], ar2[i]);
				
				if(map.get(ar2[i])!=null) {
					intersaction +=" "+ar2[i];
				}
				join +=" "+ar2[i];

			}
		}
		for(int i=0;i<l1;i++) {
			if(visited.get(ar1[i])==null) {
				visited.put(ar1[i], ar1[i]);
				join +=" "+ar1[i];
	
	
			}
		
		}
		System.out.println("intersaction "+intersaction);
		System.out.println("join "+join);

	}


	@Override
	public Integer[] findTwoNumberHavingGivenSum(int[] ar, int sum) {
		Integer[] result = new Integer[2];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i =0;i<ar.length;i++) {
			int secondValue = sum-ar[i];
			if(map.get(secondValue)!=null) {
				result[1] = ar[i];
				result[0] = secondValue;
				break;
			}
			map.put(ar[i], ar[i]);
		}
		return result;
	}


	@Override
	public boolean findDuplicateInKRange(int[] ar, int range) {
		
		boolean duplicate=false;
		
		Map<Integer, Integer> values = new HashMap<Integer, Integer>();
		
		for(int i=0;i<ar.length;i++)
		{
			if(values.get(ar[i])!=null)
			{
				duplicate=true;
				break;
			}
			values.put(ar[i], ar[i]);
			int indexToBeRemoved = i-range+1;
			if(indexToBeRemoved>-1&&values.get(ar[indexToBeRemoved])!=null)
				values.remove(ar[indexToBeRemoved]);
		}
		return duplicate;
	}


	@Override
	public Map<String, String> findItineary(Map<String, String> map) {
		
		Map<String, String> reverse = new HashMap<String, String>();
		Map<String, String> result = new LinkedHashMap<String, String>();

		
		for(Entry<String, String> entry : map.entrySet()) {
			reverse.put(entry.getValue(), entry.getKey());
		}
		String placeToVisit = "";
		for(String key : map.keySet()) {
			if(reverse.get(key)==null)
				{
				placeToVisit=key;
				}
		}
		while(placeToVisit!=null) {
			result.put(placeToVisit, map.get(placeToVisit));
			placeToVisit = map.get(placeToVisit);
		}
		return result;
	}


	@Override
	public Map<String, Integer> findTotalEmployee(Map<String, String> map) {
		Map<String, String> reverse = new HashMap<String, String>();
		Map<String, Integer> result = new LinkedHashMap<String, Integer>();

		
		for(Entry<String, String> entry : map.entrySet()) {
			reverse.put(entry.getValue(), entry.getKey());
		}
		
		for(Entry<String, String> entry : map.entrySet()) {
			if(entry.getKey().equals(entry.getValue()))
				map.remove(entry.getKey());
		}
		
		Set<String > set = new HashSet<String>();
		
		for(Entry<String, String> entry : map.entrySet()) {
			if(reverse.get(entry.getKey())==null) {
				result.put(entry.getKey(), 0);
				set.add(entry.getKey());
			}
		}
		
		boolean flag = true;
		
		while(flag) {
			Set<String> temp = new HashSet<String>();
			for(String key : set) {
				
				String value = map.get(key);
				if(value!=null) {
					int numberOFChilderen = 0;
					if(result.get(key)!=null)
						numberOFChilderen = result.get(key);
					if(result.get(value)!=null) {
						result.put(value,numberOFChilderen+ result.get(value)+1);
					}else {
						result.put(value, numberOFChilderen+1);

					}
				}

				if(value!=null&& !set.contains(value))
					temp.add(value);
				
			}
			if(temp.isEmpty())
				flag=false;
			
			set = new HashSet<String>();
			
			set.addAll(temp);

		}		
		
		
		return result;

	}


}
