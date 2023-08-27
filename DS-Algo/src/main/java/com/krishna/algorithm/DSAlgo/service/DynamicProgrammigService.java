package com.krishna.algorithm.DSAlgo.service;

public interface DynamicProgrammigService {

	String getLCA(String first, String second);

	String getMinimumEdiDistance(String source, String target);

	String getMinimumDistanceInCostMatrix(int[][] matrix);

	int getMinimumMatrixChainMultipliation(int[] ar);

	int getBinomialCofficient(int n, int k);

	int getMaximumKnapsack(int[] profits, int[] weights, int totalWeight);

	int getMinimumEggDropAttempt(int egg, int floor);

	int getLongestPalindromicSubsequence(String str);

	int getMaximumProfitInCuttingARode(int[] lengths, int[] values);

	int getMaximumSumSubsequence(int[] ar);

	int getMaximumBiotonicSubsequence(int[] ar);

	int getMinimumCutPartion(String str);

	boolean getDeterminePartition(int[] ar);

	int wordWrap(String[] ar,int max);

	int maxLengthChainPair(int[][] ar);

	int maxLengthBoxStack(int[][] ar);

	int getMinJump(int[] ar);

	int getMaximumSqureMatrix(int[][] ar);

	int getUglyNumber(int n);

	int getMaxumumSumSubarray(int[] ar);

	String getLongestPalindromicSubstring(String str);

	boolean getSumExist(int[] ar,int sum);

	int getNumberOfBinaryString(int n);

	int getNumberOfWaysToReachNthStair(int n);

	int getNumberOfCombinationInKeyPadWitNDigit(int n);

	int getCountNDigitNumberHavingSumX(int n,int sum);

	int getMinimumInitialPointToReachDestination(int[][] ar);

	int getLongetPath(char[][] ar);

	int getNumberOfWayForTailing(int n);

	int getMinimumSquire(int n);

	int getMinimumCoinExchange(int value, int[] coins);

	int getPossibleWayToConstructBuilding(int n);

}
