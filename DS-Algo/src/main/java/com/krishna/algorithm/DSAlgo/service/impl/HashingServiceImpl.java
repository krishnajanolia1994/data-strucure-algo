package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.Random;

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


}
