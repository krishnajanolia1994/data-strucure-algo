package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.service.AlgebraService;



@Component
public class AlgebraServiceImpl implements AlgebraService{

	@Override
	public double getRthRoot(int root, int number) {
		double next=0.1;
		double current = number/root;
		
		
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

	@Override
	public double getMinimumPlatform(String [] arr, String[] dep) {
		
		Map<Float, Float> map = new HashMap<Float, Float>();
		
		if(arr.length>0) {
			float[] arrInFloatt = new float[arr.length];
			float[] depInFloatt = new float[arr.length];
			for(int i=0;i<arr.length;i++) {
				arrInFloatt[i] = Float.parseFloat(arr[i].replace(":", "."));
				depInFloatt[i] = Float.parseFloat(dep[i].replace(":", "."));

			}
			
			Float key = 0.0f;
			boolean isPlatformExist = false;
			
			map.put(arrInFloatt[0], depInFloatt[0]);
			for(int i=1;i<arrInFloatt.length;i++) {
				isPlatformExist = false;
				for(Entry<Float, Float> entry : map.entrySet()) {
					if(arrInFloatt[i]>entry.getValue()) {
						key=entry.getKey();
						isPlatformExist=true;
						break;
					}
				}
				if(isPlatformExist)
					map.remove(key);
				map.put(arrInFloatt[i], depInFloatt[i]);
			}
			

		}
				
		return map.entrySet().size();
	}
	
}
