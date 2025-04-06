package com.example.Adminclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class AdminClientApplication {

	public static void main(String[] args) {
//		SpringApplication.run(AdminClientApplication.class, args);
		
//		int [] arr = {28, 13, 47, 33, 83, 72, 19 ,86, 37, 4 ,28 ,22 ,83, 32, 9 ,63 ,68, 92, 8 ,0 ,39, 78, 45, 33, 30,
//				71, 6 ,37, 39, 35, 86, 48, 13, 16, 76 ,34, 70, 64, 31, 92, 74, 0 ,16 ,78, 57, 92, 10, 96,
//				21, 65, 20, 25, 14, 34, 23, 21, 96, 86, 62, 82, 67, 41, 32, 73, 16, 9 ,53, 78, 66, 6 ,47 ,69 ,78,
//				1, 14, 42, 36, 17, 49, 79, 59, 84, 87, 61, 39, 81, 70, 56, 48, 5, 75, 19, 58};
//		
//		int result=maxWater(arr);
//		System.out.println(result);
		
		StringBuffer str=remove(new StringBuffer("abccbccba"),0);
		System.out.println(str.toString());
	}
	
	 private static StringBuffer remove(StringBuffer str, int start) {
		 int i,j;
		 for( i=start;i<str.length()-1;i++) {
			 if(str.charAt(i)==str.charAt(i+1)) {
				 for(j=i+1;j<str.length();j++) {
					 if(str.charAt(i)!=str.charAt(j)) {
						 break;
					 }
				 }
				 
				 String substring = str.substring(i, j);
				 
				 str= new StringBuffer(str.toString().replaceAll(substring, ""));
				 
//				 str.replace(i, j, "");
				 if(i!=0) {
					 str=remove(str, i-1);
				 }else
					 str=remove(str, 0);
				 
			 }
		 }
		return str;
	}

	public static  int maxWater(int arr[]) {
	        int result=0;
	        int len=arr.length;
	        
	        int maxIndexs [] = new int [len];
	        
	        maxIndexs[len-1]=len-1;
	        
	        if(len>2){
	            
	            for(int i= len-2;i>=0;i--)
	                if(arr[i]>arr[maxIndexs[i+1]])
	                    maxIndexs[i]=i;
	                else
	                     maxIndexs[i]=maxIndexs[i+1];
	            int i=0;
	            int j=0;
	            int min=0;
	            
	            for(int t=0;t<arr.length;t++){
	            	
	            }
	           
	            while(i<arr.length-1){
	                j=maxIndexs[i+1];
	                min=min(arr[i],arr[j]);
	                result+=(min)*(j-i-1);
	                
	                result-=subtract(i,j,arr,min);
	                if(j==len)
	                    break;
	                i=j;
	                
	            }
	        }
	        
	        return result;
	    }
	    
	    public static int min(int a,int b){
	        return a<b? a:b;
	    }
	    
	    public  static int subtract(int i,int j,int []arr,int min){
	        int sum=0;
	        
	        for(int k=i+1;k<j;k++){
	            if(arr[k]>min)
	                sum+=min;
	            else
	                sum+=arr[k];
	        }
	            

	        return sum;
	    }

}
