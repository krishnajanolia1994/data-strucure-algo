package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.service.AlgebraService;
import com.krishna.algorithm.DSAlgo.service.BackTrackService;



@Component
public class BackTrackServiceImpl implements BackTrackService{

	@Override
	public String getPermutationOfString(String str) {
		 
		StringBuffer allPermutation = new StringBuffer("");
		StringBuffer strToBePrint = new StringBuffer("");
		
		printPermutation(allPermutation,new StringBuffer(str),str.length(),strToBePrint);
		return allPermutation.toString();
	}

	private StringBuffer  printPermutation(StringBuffer allPermutation, StringBuffer str, int length, StringBuffer strToBePrint1) {
		if(str.length()==1)
			return str;
		
		for(int i=0;i<str.length();i++)
		{
			StringBuffer temp =str;
			swap(str,i,0);
			StringBuffer strToBePrint = new StringBuffer(str.charAt(0)+"");
			StringBuffer tempb=printPermutation(allPermutation, new StringBuffer(str.substring(1, str.length())),length,strToBePrint1);
			strToBePrint.append(tempb);   
			if(strToBePrint.length()==length)
			{
				System.out.println(strToBePrint);
				allPermutation.append(" ").append(strToBePrint);
			}
			str=temp;
			
		}
		return allPermutation;
	}

	private void swap(StringBuffer str, int i, int j) {
		char ch1 = str.charAt(i);
		char ch2 = str.charAt(j);
		str.replace(j, j+1, ch1+"");
		str.replace(i, i+1, ch2+""); 

	}

	
	
}
