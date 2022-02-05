package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.service.AlgebraService;



@Component
public class AlgebraServiceImpl implements AlgebraService{

	@Override
	public double getRthRoot(int root, int number) {
		double next=0.1;
		double current = number/root;
		
		LinkedList list= new LinkedList();
//		list.add
		
		boolean itr = true;
		while(itr) {
			next = current - (1.0/root *(current- number/ (Math.pow(current, root-1))));
			double rtPowe = Math.pow(next, root);
			
			double differnce = number - rtPowe;
			if(differnce<0)
				differnce*=-1;
			if(differnce<0.000001) {
				itr=false;
			}else {
				current=next; 
			}
		}
		
		return next;
	}
	
}
