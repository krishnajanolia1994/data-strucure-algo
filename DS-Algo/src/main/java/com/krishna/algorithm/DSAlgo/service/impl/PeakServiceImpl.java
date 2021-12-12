package com.krishna.algorithm.DSAlgo.service.impl;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.service.PeakService;


@Component
public class PeakServiceImpl implements PeakService{
	@Override
	public int getAPeak(int[] ar) {
		int peak;
		int first =0;
		int last = ar.length-1;
		if(ar.length==1)
			return ar[0];
		else if(ar[0]>ar[1])
			peak= ar[0];
		else if(ar[ar.length-1]>ar[ar.length-2])
			peak= ar[ar.length-1];

		else peak = findAPeak(ar,first,last);
		return peak;
	}

	private int findAPeak(int[] ar, int first, int last) {
		
		if(first<=last) {
			int mid =(first+last)/2;
			if((mid!=0)|| (mid!=ar.length-1)) {
				if(ar[mid]>ar[mid-1]&& ar[mid]>ar[mid+1]) {
					return ar[mid];
					
					
				}
				else if(ar[mid]<ar[mid-1]) {
					last=mid-1;
				}else {
					first=mid+1;
				}
			}
		}
		return findAPeak(ar, first, last);
	}



}
