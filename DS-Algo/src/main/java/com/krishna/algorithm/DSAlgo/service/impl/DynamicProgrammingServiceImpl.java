package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.service.DynamicProgrammigService;



@Component
public class DynamicProgrammingServiceImpl implements DynamicProgrammigService{

	@Override
	public String getLCA(String first, String second) {
		
		int lengh1 = first.length()+1;
		int lengh2 = second.length()+1;
		
		int [][] ar = new int [lengh2][lengh1];
		for(int i=1;i<lengh2;i++)
			for(int j=1;j<lengh1;j++) {
				if(second.charAt(i-1)==first.charAt(j-1)) {
					ar[i][j]=ar[i-1][j-1]+1;
				}else {
					ar[i][j] = max(ar[i-1][j],ar[i][j-1]);
				}
			}
		int i=lengh2-1;
		int j = lengh1-1;
		while(i>0||j>0) {
			if(ar[i][j]==ar[i][j-1]) {
				j--;
			}else if(ar[i][j]==ar[i-1][j]) {
				i--;
			}else {
				System.out.print(first.charAt(j-1));
				i--;
				j--;
			}
			if(i==-1||j==-1)
				break;
		}
		System.out.println();

		return "";
	}

	private int max(int i, int j) {
		return i>j?i:j;
	}

	@Override
	public String getMinimumEdiDistance(String source, String target) {
		
		int col = target.length()+1;
		int row = source.length()+1;
		
		int ar[][]=new int [row][col];
		
		int i;
		int j;
		
		for(i=0;i<row;i++)
			ar[i][0]=i;
		for(j=1;j<col;j++)
			ar[0][j]=j;
		
		for(i=1;i<row;i++)
			for(j=1;j<col;j++) {
				if(target.charAt(j-1)==source.charAt(i-1))
					ar[i][j]=ar[i-1][j-1];
				else {
					ar[i][j] = min(ar[i][j-1],ar[i-1][j],ar[i-1][j-1])+1;
				}
			}
		i=row-1;
		j=col-1;
		
		while(i!=-0&&j!=-0) {
			if(ar[i][j-1]<=ar[i-1][j]&& ar[i][j-1]<=ar[i-1][j-1]) {
				System.out.println(" add "+ source.charAt(i-1)+" in the target");j--;
			}else if(ar[i-1][j]<=ar[i-1][j-1]) {
				System.out.println(" delete "+ source.charAt(i-1));i--;

			}else if(ar[i][j]!=ar[i-1][j-1]){
				System.out.println(" replace  "+ target.charAt(j-1)+" in the target with "+ target.charAt(i-1) );i--;j--;

			}else {
				i--;j--;
			}
				
		}
		return null;
	}

	private int min(int i, int j, int k) {
		
		int min=i;
		
		if(j<min)
			min=j;
		if(k<min)
			min=k;
		
		return min;
	}

	@Override
	public String getMinimumDistanceInCostMatrix(int[][] matrix) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		int i,j;
		
		int [][] costMarix = new int [row][col];
		
		
		for(i=1;i<col;i++) {
			costMarix[0][i]  = costMarix[0][i-1]+matrix[0][i];
		}
		
		for(i=1;i<row;i++) {
			costMarix[i][0] = matrix[i][0] + costMarix[i-1][0];
		}
		
		for(i=1;i<row;i++)
			for(j=1;j<col;j++) {
				costMarix[i][j] = min(costMarix[i][j-1],costMarix[i-1][j],costMarix[i-1][j-1]) +matrix[i][j];
			}
		System.out.println(costMarix[row-1][col-1]);
		return "";
	}

	@Override
	public int getMinimumMatrixChainMultipliation(int[] ar) {
		
		int length = ar.length-1;
		
		int matrix[][] = new int [length][length];
		
		int i=0;
		int j=1;
		int k;
		int min, localMin;
		while(!(i==0&&j==length)) {
			localMin=-1;
			min=-1;
			for(k=i;k<j;k++) {
				localMin = matrix[i][k]+matrix[k+1][j]+ar[i]*ar[k+1]*ar[j+1];
				if(min==-1||localMin<min)
					min=localMin;
									
			}
			matrix[i][j] = min;
			if(j<(length-1)) {
				i++;j++;
			}else {
				
				int newJ = j-i+1;
				j=newJ;
				i=0;
			}
			
		}
		return matrix[0][length-1];
	}

	@Override
	public int getBinomialCofficient(int n, int k) {
		
		
		int [][] ar = new int [n+1][n+1];
		
		for(int i=1;i<n+1;i++)
			ar[i][0]=1;
		
		for(int i=1;i<n+1;i++)
			for(int j=1;j<n+1;j++) {
				if(i==j)
					ar[i][j]=1;
				else {
					ar[i][j] = ar[i-1][j-1]+ar[i-1][j];
					
				}
			}
		return ar[n][k];
	}

	@Override
	public int getMaximumKnapsack(int[] profits, int[] weights, int totalWeight) {
		
		if(profits.length!=weights.length||profits.length==0)
			return 0;
		
		int length = profits.length;
		
		int  [][] profitsMatrix = new int [length][length];
		int  [][] weightsMatrix = new int [length][length];
		int k ,i,j, localWeight, maxWeight,localProfit, maxProfit;
		for(i=0;i<length;i++) {
			profitsMatrix[i][i] = profits[i];
			weightsMatrix[i][i] = weights[i];
		}
		
		i=0;
		j=1;
		
		while(!(i==0&&j==length)) {
			maxProfit=-1;
			maxWeight=-1;
			
			for(k=i;k<j;k++) {
				if(weightsMatrix[i][k]+weightsMatrix[k+1][j]<=totalWeight) {
					localWeight = weightsMatrix[i][k]+weightsMatrix[k+1][j];
					localProfit = profitsMatrix[i][k]+profitsMatrix[k+1][j];
				}else if(profitsMatrix[i][k]>profitsMatrix[k+1][j]) {
					localWeight = weightsMatrix[i][k];
					localProfit = profitsMatrix[i][k];
				}else {
					localWeight = weightsMatrix[k+1][j];
					localProfit = profitsMatrix[k+1][j];
				}
				if(maxProfit==-1||localProfit>maxProfit) {
					maxProfit = localProfit;
					maxWeight = localWeight;
				}
					
			}
			profitsMatrix[i][j]=maxProfit;
			weightsMatrix[i][j] = maxWeight;
			
			if(j<(length-1)) {
				i++;j++;
			}else {
				
				int newJ = j-i+1;
				j=newJ;
				i=0;
			}
			
			
		}
		
		return profitsMatrix[0][length-1];
	}

	@Override
	public int getMinimumEggDropAttempt(int egg, int floor) {
		
		int [][] dp =new int [egg+1][floor+1];
		
		int i,j,min,max,k;
		for(i=0;i<=egg;i++)
			dp[i][1]=1;
		
		for(i=0;i<=floor;i++)
			dp[1][i]=i;
		
		for(i=2;i<=egg;i++) {
			for(j=2;j<=floor;j++) {
				min = -1;
				for(k=1;k<=j;k++) {
					max = getMax(dp[i-1][k-1],dp[i][j-k]);
					if(min==-1||min>max)
						min=max+1;
				}
				dp[i][j]=min;
			}
		}
		
		
		return dp[egg][floor];
	}

	private int getMax(int i, int j) {
		
		return i>j?i:j;
	}

	@Override
	public int getLongestPalindromicSubsequence(String str) {
		
		int [][] dp = new int [str.length()][str.length()];
		
		int i,j,k;
		for(i=0;i<str.length();i++)
			dp[i][i] = 1;
		i=0;
		j=1;
		
		
		while(!(i==0&&j==str.length())) {
			int max=-1;
			if(str.charAt(i)==str.charAt(j)) {
				if(i+1==j)
					max=2;
				else {
					max = 2+dp[i+1][j-1];
				}
			}else {
				for(k=i;k<j;k++) {
					if(dp[i][k]>max)
						max=dp[i][k];
					if(dp[k+1][j]>max)
						max=dp[k+1][j];
				}
			}
			dp[i][j] = max;
			if(j<(str.length()-1)) {
				i++;j++;
			}else {
				
				int newJ = j-i+1;
				j=newJ;
				i=0;
			}
		}
		return dp[0][str.length()-1];
	}

	@Override
	public int getMaximumProfitInCuttingARode(int[] lengths, int[] values) {
		
		int profit [] = new int [values.length+1];
		
		profit[0]=0;
		
		
		profit[1] = values[0];
		
		for(int i=2;i<values.length;i++) {
			profit[i] = values[i-lengths[i-2]];
		}
		
		int i=1;
		int j = 2;
		int max;
		while(i<profit.length&&j<profit.length) {
			max=-1;
			for(int k = 1;k<j;k++) {
				if(profit[k]+profit[j-k]>max)
					max= profit[k]+profit[j-k];
			}
			if(max<values[j-1])
				max=values[j-1];
			profit[j]=max;
			
			j++;
		}
		return profit[values.length];
	}

	@Override
	public int getMaximumSumSubsequence(int[] ar) {
		if(ar.length==0)
			return 0;
		int i=1;
		int max;
		int min = getMin(ar);
		int  globaleMax=min;
		int sum[]= new int [ar.length];
		for(i=0;i<ar.length;i++)
			sum[i]=ar[i];
		i=1;
		while(i<ar.length) {
			max=-1;
			for(int j=0;j<i;j++) {
				if(ar[j]<ar[i]&&sum[j]+sum[i]>max)
					max=sum[i]+sum[j];
			}
			if(max>sum[i]) {
				sum[i] = max;
				if(globaleMax<max)
					globaleMax=max;
			}
			i++;
		}
		return globaleMax;
	}

	private int getMin(int[] ar) {
		int min = ar[0];
		for(int i=0;i<ar.length;i++) {
			if(ar[i]<min)
				min=ar[i];
		}
		return min;
	}

	@Override
	public int getMaximumBiotonicSubsequence(int[] ar) {
		int increasinRight [] = new int [ar.length];
		int increasingLeft [] = new int [ar.length];
		int i;
		for(i=0;i<ar.length;i++) {
			increasingLeft[i]=1;
			increasinRight[i]=1;

		}
		
		i=1;
		int max;
		while(i<ar.length) {
			
			max = 1;
			for(int j=0;j<i;j++) {
				if(ar[j]<ar[i]&&increasinRight[j]+increasinRight[i]>max)
					max= increasinRight[j]+increasinRight[i];
			}
			if(max>increasinRight[i])
				increasinRight[i]=max;
			i++;
		}
		
		i=ar.length-2;
		while(i>=0) {
			max=1;
			for(int j=ar.length-1;j>i;j--) {
				if(ar[j]<ar[i]&&increasingLeft[j]+increasingLeft[i]>max)
					max=increasingLeft[j]+increasingLeft[i];
			}
			if(max>increasingLeft[i])
				increasingLeft[i]=max;
			i--;
				
		}
		
		max = 0;
		
		for(i=0;i<ar.length;i++) {
			if(increasingLeft[i]+increasinRight[i]>max)
				max =increasingLeft[i]+increasinRight[i];
		}
		return max-1;
	}

	@Override
	public int getMinimumCutPartion(String str) {
		int [][] dp= new int [str.length()][str.length()];
		
		Set<String>  palildrom = new HashSet<String>();
		int i=0;
		int j=1;
		while(!(i==0&&j==str.length())) {
			int min = str.length();
			String palindromKey = (i+1)+"_"+(j-1);
			if(str.charAt(i)==str.charAt(j)&&(palildrom.contains(palindromKey)||i+1==j||i+1==j-1)) {
				min=0;
				palildrom.add(i+"_"+j);
			}else {
				for(int k=i;k<j;k++) {
					if(dp[i][k]+dp[k+1][j]+1<min)
						min= dp[i][k]+dp[k+1][j]+1;
				}
			}
			dp[i][j]=min;
			if(j<(str.length()-1)) {
				i++;j++;
			}else {
				
				int newJ = j-i+1;
				j=newJ;
				i=0;
			}
			
				
		}
		
		return dp[0][str.length()-1];
	}

	@Override
	public boolean getDeterminePartition(int[] ar) {
		int sum = getSum(ar);
		if(sum==0||sum%2!=0)
			return false;
		
		sum/=2;
		int i,j,operand2;
		
		boolean [][] dp = new boolean [sum+1][ar.length];
		for(i=1;i<sum+1;i++) {
			for(j=0;j<ar.length;j++) {
				operand2=i-ar[j];
				if((i==ar[j])||(operand2>=0&&isOperand2Prasent(operand2,j,ar,dp))) 
					dp[i][j]=true;
			}
		}
		
		boolean isPartion = false;
		i=sum;
		for(j=0;j<ar.length;j++)
			if(dp[i][j]) {
				isPartion=true;
			}
				
		
		
		return isPartion;
	}

	private boolean isOperand2Prasent(int i, int j, int[] ar, boolean[][] dp) {
		boolean isOperand2Prasent =false;
		for(int k=0;k<dp[0].length;k++) {
			if(k!=j&&dp[i][k]) {
				isOperand2Prasent=true;
				break;
			}
		}
		return isOperand2Prasent;
	}

	private int getSum(int[] ar) {
		int sum=0;
		for(int i=0;i<ar.length;i++) {
			sum+=ar[i];
		}
		return sum;
	}

	@Override
	public int wordWrap(String[] ar,int max) {
		
		int dp[][] = new int [ar.length][ar.length];
		int i,j,emptySpace,min,localMin,k;
		
		for(i=0;i<ar.length;i++) {
			if(ar[i].length()>max)
				return -1;
			emptySpace = max-ar[i].length();
			dp[i][i]=emptySpace*emptySpace*emptySpace;
		}
		i=0;
		j=1;
		while(!(i==0&&j==ar.length)) {
			emptySpace = getMinSpace(i,j,max,ar);
			if(emptySpace!=-1)
				dp[i][j]=emptySpace*emptySpace*emptySpace;
			else {
				min=-1;
				
				localMin=-1;
				for(k=i;k<j;k++) {
					localMin=dp[i][k]+dp[k+1][j];
					if(min==-1||localMin<min)
						min=localMin;
				}
				dp[i][j]=min;
				
				
			}
			if(j<(ar.length-1)) {
				i++;j++;
			}else {
				
				int newJ = j-i+1;
				j=newJ;
				i=0;
			}
		}
		return dp[0][ar.length-1];
	}

	private int getMinSpace(int i, int j, int max, String[] ar) {
		int emptySpace=-1;
		int totalSpace=0;
		for(int k=i;k<=j;k++)
			totalSpace+=ar[k].length();
		if((totalSpace+(j-i))<=max)
			emptySpace=max-(totalSpace+(j-i));
		return emptySpace;
	}

	@Override
	public int maxLengthChainPair(int[][] pairs) {
		
		int i,j,globleMax,max;
		int length = pairs.length;
		int []dp = new int[length];
		globleMax=-1;
		for(i=0;i<length;i++) {
			dp[i]=1;
		}
		for(i=1;i<length;i++) {
			max=0;
			for(j=0;j<i;j++) {
				if(pairs[j][1]<pairs[i][0]&&max<(dp[i]+dp[j])) {
					max=dp[i]+dp[j];
				}
			}
			if(max>dp[i]) {
				dp[i]=max;
				if(globleMax==-1||globleMax<max)
					globleMax=max;

			}
			
		}
		return globleMax;
	}

	@Override
	public int maxLengthBoxStack(int[][] ar) {
		int [][] rotation = new int [ar.length*6][3];
		int i,j,max,globaleMax;
		j=0;
		globaleMax=0;
		for(i=0;i<ar.length;i++) {
			rotation[j][0]=ar[i][0];
			rotation[j][1] = ar[i][1];
			rotation[j][2] = ar[i][2];
			j++;
			rotation[j][0]=ar[i][1];
			rotation[j][1] = ar[i][0];
			rotation[j][2] = ar[i][2];
			j++;
			rotation[j][0]=ar[i][0];
			rotation[j][1] = ar[i][2];
			rotation[j][2] = ar[i][1];
			j++;
			rotation[j][0]=ar[i][2];
			rotation[j][1] = ar[i][0];
			rotation[j][2] = ar[i][1];
			j++;
			rotation[j][0]=ar[i][1];
			rotation[j][1] = ar[i][2];
			rotation[j][2] = ar[i][0];
			j++;
			rotation[j][0]=ar[i][2];
			rotation[j][1] = ar[i][1];
			rotation[j][2] = ar[i][0];
			j++;
			
		}
		
		int [] dp = new int [rotation.length];
		sort(rotation);
		for(i=0;i<rotation.length;i++)
			dp[i]=rotation[i][2];
		for(i=1;i<dp.length;i++) {
			max=0;
			for(j=0;j<i;j++) {
				if(rotation[j][0]>rotation[i][0]&&rotation[j][1]>rotation[i][1]&&max<(dp[i]+dp[j])) {
					max=dp[i]+dp[j];
				}
			}
			if(max>dp[i]) {
				dp[i]=max;
				if(max>globaleMax)
					globaleMax=max;
			}
			
		}
		return globaleMax;
	}

	private void sort(int[][] rotation) {
		int [][]temp = new int [1][3];

		for (int i = 0; i < rotation.length; i++)
			for (int j = i + 1; j < rotation.length; j++) {
				if (rotation[j][0] > rotation[i][0] && rotation[j][1] > rotation[i][1]) {
					temp[0]=rotation[i];
					rotation[i]=rotation[j];
					rotation[j]=temp[0];
				}
			}
	}

	@Override
	public int getMinJump(int[] ar) {
		int [] dp = new int [ar.length];
		int i,j,min=-1,localMin;
		for(i=1;i<dp.length;i++) {
			if(ar[i-1]>0)
				dp[i]=i;
			else
				dp[i]=-1;
		}
		
		for(i=1;i<dp.length;i++) {
			min=-1;
			localMin =-1;
			for(j=0;j<i;j++){
				if((j+ar[j])>=i&&(min==-1||dp[j]>localMin))
					
					localMin=dp[j];
				if(min==-1||localMin<min)
					min=localMin;
			}
			if((dp[i]>min+1))
				dp[i]=min+1;
		}

		
		return dp[ar.length-1];
	}

	@Override
	public int getMaximumSqureMatrix(int[][] ar) {
		int max = 0;
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[0].length;j++) {
				if(i==0||j==0) {
					if(ar[i][j]>max)
						max=ar[i][j];
					
				}else if(ar[i][j]!=0){
					ar[i][j] = getmin(getmin(ar[i-1][j], ar[i][j-1]), ar[i-1][j-1])+1;
					if(ar[i][j]>max)
						max=ar[i][j];
				}
				
			}
		}
		
		for(int i=0;i<max;i++) {
			for(int j=0;j<max;j++) {
				System.out.print("1");
			}
			System.out.println();

		}
			
		
		return max;
	}

	private int getmin(int i, int j) {
		int min=i;
		if(j<min)
			min=j;
		return min;
	}

	@Override
	public int getUglyNumber(int n) {
		int [] uglies = new int [n];
		uglies[0]=1;
		int two=0;
		int three =0;
		int five=0;
		
		int twoNext,threeNext,fiveNext;
		for(int i=1;i<n;i++) {
			twoNext=uglies[two]*2;
			threeNext=uglies[three]*3;
			fiveNext=uglies[five]*5;
			
			int value = getmin(getmin(twoNext, threeNext), fiveNext);
			uglies[i]=value;
			if(value==twoNext)
				two++;
			if(value==threeNext)
				three++;
			if(value==fiveNext)
				five++;
			System.out.println(value);
			

		}
		
		
		return uglies[n-1];
	}

	@Override
	public int getMaxumumSumSubarray(int[] ar) {
		
		int start =0;
		int maxSum =ar[0];
		int sum=ar[0];
		
		for(int i=1;i<ar.length;i++) {
			if(sum>-1) {
				sum+=ar[i];
				
			}else {
				sum=ar[i];
				start=i;
				
			}
			if(sum>maxSum)
				maxSum=sum;
		}
		return maxSum;
	}

	@Override
	public String getLongestPalindromicSubstring(String str) {
		int length = str.length();
		int [][] dp =new int [length][length];
		int i,j;
		int maxi=0;
		int maxj=0;
		for(i=0;i<str.length();i++) {
			dp[i][i]=1;
		}
		i=0;
		j=1;
		while(!(i==0&&j==length)) {
			
			if(str.charAt(i)==str.charAt(j)) {
				if(i+1==j)
					dp[i][j]=2;
				else if(dp[i+1][j-1]>0) {
					dp[i][j] = 2+dp[i+1][j-1];
				}else
					dp[i][j]=0;
			}
			if(dp[i][j]>dp[maxi][maxj]) {
				maxi=i;
				maxj=j;
			}
			if(j<(length-1)) {
				i++;j++;
			}else {
				
				int newJ = j-i+1;
				j=newJ;
				i=0;
			}
		}
		
		
		return str.substring(maxi, maxj+1);
	}

	@Override
	public boolean getSumExist(int[] ar,int sum) {
		
		boolean [][] dp = new boolean [sum+1][ar.length];
		
		int i,j,k;
		for(i=1;i<=sum;i++) {
			for(j=0;j<ar.length;j++) {
				if(ar[j]==i)
					dp[i][j]=true;
				else {
					k=i-ar[j];
					if(k>0) {
						dp[i][j]= isExist(k,j,dp);
					}else{
						dp[i][j]=false;
					}
				}
			}
		}
		boolean exist= false;
		for(i=0;i<dp[0].length;i++) {
			if(dp[sum][i]) {
				exist = true;
			}
		}
		return exist;
	}

	private boolean isExist(int k, int j, boolean[][] dp) {
		boolean isExist=false;
		int length = dp[0].length;
		for(int i=0;i<length;i++) {
			if(i!=j&&dp[k][i])
				isExist=true;
		}
		return isExist;
	}

	@Override
	public int getNumberOfBinaryString(int n) {
		int one=1;
		int zero =1;
		int nextOne =0;
		int nextZero = 0;
		for(int i=1;i<n;i++) {
			nextZero = zero+one;
			nextOne= zero;
			zero=nextZero;
			one=nextOne;
		}
		return one+zero;
	}

	@Override
	public int getNumberOfWaysToReachNthStair(int n) {
		if(n==1||n==2)
			return n;
		int current=2;
		int previous=1;
		int next=0;
		for(int i=2;i<n;i++) {
			next=current+previous;
			previous=current;
			current=next;
		}
		return current;
	}

	@Override
	public int getNumberOfCombinationInKeyPadWitNDigit(int n) {
		
		int [] combinationOfNumber=new int [10];
		int [] nextCombinationOfNumber=new int [10];
		int i,j;
		for(i=0;i<10;i++)
			combinationOfNumber[i]=1;
		for(i=1;i<n;i++) {
			for(j=0;j<10;j++) {
				if(j==0) {
					nextCombinationOfNumber[0]+=combinationOfNumber[0];
					nextCombinationOfNumber[8]+=combinationOfNumber[0];
				}else if(j==1) {
					nextCombinationOfNumber[1]+=combinationOfNumber[1];
					nextCombinationOfNumber[2]+=combinationOfNumber[1];
					nextCombinationOfNumber[4]+=combinationOfNumber[1];

				}else if(j==2) {
					nextCombinationOfNumber[1]+=combinationOfNumber[2];
					nextCombinationOfNumber[2]+=combinationOfNumber[2];
					nextCombinationOfNumber[3]+=combinationOfNumber[2];
					nextCombinationOfNumber[5]+=combinationOfNumber[2];

				}else if(j==3) {
					nextCombinationOfNumber[2]+=combinationOfNumber[3];
					nextCombinationOfNumber[3]+=combinationOfNumber[3];
					nextCombinationOfNumber[6]+=combinationOfNumber[3];

				}else if(j==4) {
					nextCombinationOfNumber[1]+=combinationOfNumber[4];
					nextCombinationOfNumber[4]+=combinationOfNumber[4];
					nextCombinationOfNumber[7]+=combinationOfNumber[4];
					nextCombinationOfNumber[5]+=combinationOfNumber[4];

				}else if(j==5) {
					nextCombinationOfNumber[2]+=combinationOfNumber[5];
					nextCombinationOfNumber[4]+=combinationOfNumber[5];
					nextCombinationOfNumber[6]+=combinationOfNumber[5];
					nextCombinationOfNumber[8]+=combinationOfNumber[5];
					nextCombinationOfNumber[5]+=combinationOfNumber[5];

				}else if(j==6) {
					nextCombinationOfNumber[3]+=combinationOfNumber[6];
					nextCombinationOfNumber[5]+=combinationOfNumber[6];
					nextCombinationOfNumber[9]+=combinationOfNumber[6];
					nextCombinationOfNumber[6]+=combinationOfNumber[6];

				}else if(j==7) {
					nextCombinationOfNumber[4]+=combinationOfNumber[7];
					nextCombinationOfNumber[8]+=combinationOfNumber[7];
					nextCombinationOfNumber[7]+=combinationOfNumber[7];

				}else if(j==8) {
					nextCombinationOfNumber[5]+=combinationOfNumber[8];
					nextCombinationOfNumber[7]+=combinationOfNumber[8];
					nextCombinationOfNumber[0]+=combinationOfNumber[8];
					nextCombinationOfNumber[9]+=combinationOfNumber[8];
					nextCombinationOfNumber[8]+=combinationOfNumber[8];

				}else {
					nextCombinationOfNumber[6]+=combinationOfNumber[9];
					nextCombinationOfNumber[8]+=combinationOfNumber[9];
					nextCombinationOfNumber[9]+=combinationOfNumber[9];

				}
			}
			for(j=0;j<10;j++) {
				combinationOfNumber[j]=nextCombinationOfNumber[j];
				nextCombinationOfNumber[j]=0;
			}
			
		}
		return sum(combinationOfNumber);
	}

	private int sum(int[] combinationOfNumber) {
		int sum=0;
		for(int i=0;i<10;i++) {
			sum+=combinationOfNumber[i];
		}
		return sum;
	}

	@Override
	public int getCountNDigitNumberHavingSumX(int n,int sum) {
		int dp [][] = new int [n+1][sum+1];
		int i,j,total,k,lastDigit;
		for(i=1;i<=n;i++){
			dp[i][1]=1;
		}
		for(i=1;i<10;i++)
			if(i<=sum)
				dp[1][i]=1;
		for(i=2;i<=n;i++) {
			for(j=2;j<=sum;j++) {
				total=0;
				for(k=1;k<=j;k++) {
					lastDigit=j-dp[i-1][k];
					if(lastDigit>-1&&lastDigit<10) {
						total+=dp[i-1][k];
					}
				}
				dp[i][j]=total;
			}
		}
		return dp[n][sum];
	}

	@Override
	public int getMinimumInitialPointToReachDestination(int[] []ar) {
		int row= ar.length;
		int coloumn = ar[0].length;
		int dp[] []= new int [row][coloumn];
		dp[row-1][coloumn-1] = ar[row-1][coloumn-1]>1 ? 1:ar[row-1][coloumn-1];
		
		int i,j;
		i=row-1;
		for(j=coloumn-2;j>=0;j--) {
			dp[i][j]= (dp[i][j+1]+ar[i][j])>1?1:dp[i][j+1]+ar[i][j];
		}
		j=coloumn-1;
		for(i=row-2;i>=0;i--) {
			dp[i][j]= (dp[i+1][j]+ar[i][j])>1?1:dp[i+1][j]+ar[i][j];

		}
		int min;
		for(i=row-2;i>=0;i--) {
			for(j=coloumn-2;j>=0;j--) {
				min = getAbsoluteMin(dp[i+1][j],dp[i][j+1]);
				dp[i][j]=(min+ar[i][j])>1?1:min+ar[i][j];
			}
		}
		return dp[0][0];
	}

	private int getAbsoluteMin(int i, int j) {
		int min =j;
		if(Math.abs(i)<Math.abs(j)) {
			min=i;
		}
		return min;
	}

	@Override
	public int getLongetPath(char[][] ar) {
		
		int max = 0;
		
		int row = ar.length;
		int column = ar[0].length;
		
		int dp[][] = new int [row][column];
		
		Map<String, String> visited = new HashMap<>();
		int i,j;
		for(i=0;i<row;i++) {
			for(j=0;j<column;j++) {
				if(visited.get(""+ar[i][j])==null) {
					dp[i][j] = getLengthOfPath(i,j,ar,visited);
					if(dp[i][j]>max)
						max=dp[i][j];
				}
			}
		}
		return max;
	}

	private int getLengthOfPath(int i, int j, char[][] ar, Map<String, String> visited) {
		int length = 1;
		visited.put(ar[i][j]+"", ar[i][j]+"");
		int row = ar.length;
		int column = ar[0].length;
		
		boolean flag = true;
		while(flag) {
			if(j>0&&(ar[i][j-1]-1)==ar[i][j]) {
				length++;
				j--;
				
			}else if(j>0&&i>0&&(ar[i-1][j-1]-1)==ar[i][j]) {
				length++;
				j--;
				i--;
				
			}else if(i>0&&(ar[i-1][j]-1)==ar[i][j]) {
				length++;
				i--;
				
			}else if(j<column-1&&i>0&&(ar[i-1][j+1]-1)==ar[i][j]) {
				length++;	
				j++;
				i--;
				
			}else if(j<column-1&&(ar[i][j+1]-1)==ar[i][j]) {
				length++;
				j++;
				
			} else if(i<row-1&&(ar[i+1][j]-1)==ar[i][j]) {
				length++;
				i++;
				
			}else if(i<row-1&&j<column-1&&(ar[i+1][j+1]-1)==ar[i][j]) {
				length++;
				i++;
				j++;
				
			}else if(i<row-1&&j>0&&(ar[i+1][j-1]-1)==ar[i][j]) {
				length++;
				j--;
				i++;
				
			}else {
				flag=false;
			}
			visited.put(ar[i][j]+"", ar[i][j]+"");

		}
		
		return length;
	}

	@Override
	public int getNumberOfWayForTailing(int n) {
		int [] dp =new int [n];
		if(n==1||n==2)
			return n;
		dp[0]=1;
		dp[1]=2;
		for(int i=2;i<n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n-1];
	}

	@Override
	public int getMinimumSquire(int n) {
		
		double [] dp = new double [n+1];
		dp[0]=0;
		dp[1]=1;
		int lastSqrt = 1;
		int temp;
		int count;
		double sqrt ;
		for(int i=2;i<=n;i++) {
			sqrt=Math.sqrt(i);
			if(sqrt*sqrt==i) {
				dp[i]=1;
				lastSqrt=(int) sqrt;
			}
			else {
				count =0;
				temp=i;
				while(temp>=lastSqrt*lastSqrt)
				{
					temp-=lastSqrt*lastSqrt;
					count++;
				}
				count+=dp[temp];
				dp[i]=count;
			}
		}
		int result = (int) dp[n];
		return result;
	}

	@Override
	public int getMinimumCoinExchange(int value, int[] coins) {
		
		int dp [][] = new int [value+1][coins.length];
		int i,j;
		int row;
		int totalCoin =-1;
		for(i=1;i<=value;i++) {
			for(j=0;j<coins.length;j++) {
				if(coins[j]==i)
					dp[i][j]=1;
				else {
					row =i-coins[j];
					if(row>0) {
						totalCoin = getMinCoin(row,dp);
						if(totalCoin!=-1) {
								dp[i][j]=totalCoin+1;
						}else {
							dp[i][j]=-1;
						}
					}
					
				}
			}
		}
		int min=dp[value][0];
		for(i=1;i<coins.length;i++)
		{
			if(dp[value][i]!=-1&&dp[value][i]<min)
				min=dp[value][i];
		}
		return min;
	}

	private int getMinCoin(int row, int[][] dp) {
		int minCount=-1;
		
		for(int j=0;j<dp[0].length;j++) {
			if(dp[row][j]>0) {
				if(minCount==-1||minCount>dp[row][j]) {
					minCount=dp[row][j];
				}
			}
		}
		return minCount;
	}

	@Override
	public int getPossibleWayToConstructBuilding(int n) {
		int result = getNumberOfBinaryString(n);
		return result*result;
	}
		
}
