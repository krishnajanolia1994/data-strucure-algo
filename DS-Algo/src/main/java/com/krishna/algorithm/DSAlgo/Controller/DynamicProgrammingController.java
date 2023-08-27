package com.krishna.algorithm.DSAlgo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.algorithm.DSAlgo.constent.AppConstants;
import com.krishna.algorithm.DSAlgo.service.DynamicProgrammigService;

@RestController
public class DynamicProgrammingController {
	@Autowired
	private DynamicProgrammigService dynamicProgrammigService;
	
	@GetMapping(value  = AppConstants.GET + AppConstants.LCA)
	public String getLCA(@RequestParam("first")String first , @RequestParam("second") String second)
	{
		return dynamicProgrammigService.getLCA(first, second);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM+AppConstants.EDIT_DISTANCE)
	public String getMinimumEdiDistance(@RequestParam("source")String source , @RequestParam("target") String target)
	{
		return dynamicProgrammigService.getMinimumEdiDistance(source, target);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM+AppConstants.DISTANCE_IN_COST_MATTRIX)
	public String getMinimumDistanceInCostMatrix(@RequestParam("matrix")int [] [] matrix )
	{
		return dynamicProgrammigService.getMinimumDistanceInCostMatrix(matrix);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM+AppConstants.MATRIX_CHAIN_MULTIPLICATION)
	public int getMinimumMatrixChainMultipliation(@RequestParam("matrix")int [] ar )
	{
		return dynamicProgrammigService.getMinimumMatrixChainMultipliation(ar);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MAXIMUM+AppConstants.ZERO_ONE_KNAPSACK)
	public int getMinimumMatrixChainMultipliation1(@RequestParam("profits")int [] profits,@RequestParam("weights")int [] weights,@RequestParam("totalWeight")int  totalWeight  )
	{
		return dynamicProgrammigService.getMaximumKnapsack(profits,weights,totalWeight);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.BINOMIAL_COIFFICIENT)
	public int getBinomialCofficient(@RequestParam("n")int n, @RequestParam("k")int k)
	{
		return dynamicProgrammigService.getBinomialCofficient(n,k);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM +AppConstants.EGG_DROP_ATTEMPT)
	public int getMinimumEggDropAttempt(@RequestParam("egg")int egg, @RequestParam("floor")int floor)
	{
		return dynamicProgrammigService.getMinimumEggDropAttempt(egg,floor);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.LONGEST +AppConstants.PALINDOMIC_SEQUENCE)
	public int getLongestPalindromicSubsequence(@RequestParam("str")String str)
	{
		return dynamicProgrammigService.getLongestPalindromicSubsequence(str);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MAXIMUM +AppConstants.PROFIT_IN_CUTTING_RODE)
	public int getMaximumProfitInCuttingARode(@RequestParam("lengths")int [] lengths,@RequestParam("values")int [] values)
	{
		return dynamicProgrammigService.getMaximumProfitInCuttingARode(lengths,values);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MAXIMUM +AppConstants.SUM_SUBSEQUENCE)
	public int getMaximumSumSubsequence(@RequestParam("ar")int [] ar)
	{
		return dynamicProgrammigService.getMaximumSumSubsequence(ar);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MAXIMUM +AppConstants.LENGTH+AppConstants.BIOTONIC_SUBSEQUENCE)
	public int getMaximumBiotonicSubsequence(@RequestParam("ar")int [] ar)
	{
		return dynamicProgrammigService.getMaximumBiotonicSubsequence(ar);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM +AppConstants.CUT_PARITION)
	public int getMinimumCutPartion(@RequestParam("str")String str)
	{
		return dynamicProgrammigService.getMinimumCutPartion(str);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.IS_PARTION)
	public boolean getDeterminePartition(@RequestParam("ar")int [] ar)
	{
		return dynamicProgrammigService.getDeterminePartition(ar);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM+AppConstants.WORD_WRAP)
	public int wordWrap(@RequestParam("ar")String [] ar,@RequestParam("max")int max)
	{
		return dynamicProgrammigService.wordWrap(ar,max);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MAXIMUM+AppConstants.LENGTH+AppConstants.CHAIN_PAAIR)
	public int maxLengthChainPair(@RequestParam("ar")int [][] ar)
	{
		return dynamicProgrammigService.maxLengthChainPair(ar);
	}
	

	@GetMapping(value  = AppConstants.GET + AppConstants.MAXIMUM+AppConstants.LENGTH+AppConstants.BOX_STACK)
	public int maxLengthBoxStack(@RequestParam("ar")int [][] ar)
	{
		return dynamicProgrammigService.maxLengthBoxStack(ar);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM+AppConstants.JUMP)
	public int getMinJump(@RequestParam("ar")int [] ar)
	{
		return dynamicProgrammigService.getMinJump(ar);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.UGLY_NUMBER)
	public int getUglyNumber(@RequestParam("n") int n)
	{
		return dynamicProgrammigService.getUglyNumber(n);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MAXIMUM+AppConstants.SUM_SUBARRAY)
	public int getMaxumumSumSubarray(@RequestParam("ar") int [] ar)
	{
		return dynamicProgrammigService.getMaxumumSumSubarray(ar);
	}

	
	@GetMapping(value  = AppConstants.GET + AppConstants.LONGEST+AppConstants.PALINDOMIC_Substring)
	public String getLongestPalindromicSubstring(@RequestParam("str") String str)
	{
		return dynamicProgrammigService.getLongestPalindromicSubstring(str);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.SUM_EXIST)
	public boolean getSumExist(@RequestParam("ar") int[]  ar,@RequestParam("sum") int sum)
	{
		return dynamicProgrammigService.getSumExist(ar, sum);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.NUMBER_OF_BINARY_STRING_WITHOUT_CONSECUTIVE_ONE)
	public int getNumberOfBinaryString(@RequestParam("n") int n)
	{
		return dynamicProgrammigService.getNumberOfBinaryString( n);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.NUMBER_OF_WAYS_TO_REACH_NTH_STAIR)
	public int getNumberOfWaysToReachNthStair(@RequestParam("n") int n)
	{
		return dynamicProgrammigService.getNumberOfWaysToReachNthStair( n);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.NUMBER_OF_COMBINATION_WITH_N_DIGIT_IN_KEYPAD)
	public int getNumberOfCombinationInKeyPadWitNDigit(@RequestParam("n") int n)
	{
		return dynamicProgrammigService.getNumberOfCombinationInKeyPadWitNDigit( n);
	}
	
	//see it letter
	
	@GetMapping(value  = AppConstants.GET + AppConstants.COUNT_N_DIGIT_NUMER_HAVING_SUM_X)
	public int getCountNDigitNumberHavingSumX(@RequestParam("n") int n,@RequestParam("sum") int sum)
	{
		return dynamicProgrammigService.getCountNDigitNumberHavingSumX( n,sum);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM_INITIAL_POINT_TO_REACH_DESTINATION )
	public int getMinimumInitialPointToReachDestination(@RequestParam("ar") int [][]ar)
	{
		return dynamicProgrammigService.getMinimumInitialPointToReachDestination(ar);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.LOGEST_PATH )
	public int getLongetPath(@RequestParam("ar") char [][]ar)
	{
		return dynamicProgrammigService.getLongetPath(ar);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.NUMBER_OF_WAY_FOR_TAILING )
	public int getNumberOfWayForTailing(@RequestParam("n") int n)
	{
		return dynamicProgrammigService.getNumberOfWayForTailing(n);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM_SQUIRE )
	public int getMinimumSquire(@RequestParam("n") int n)
	{
		return dynamicProgrammigService.getMinimumSquire(n);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.MINIMUM_COIN_EXCHANGE )
	public int getMinimumCoinExchange(@RequestParam("value") int value,@RequestParam("coins") int[] coins)
	{
		return dynamicProgrammigService.getMinimumCoinExchange(value,coins);
	}
	
	@GetMapping(value  = AppConstants.GET + AppConstants.COUNT_POSIBLE_WAY_TO_CONSTRUCT_BUILDIN )
	public int getPossibleWayToConstructBuilding(@RequestParam("n") int n)
	{
		return dynamicProgrammigService.getPossibleWayToConstructBuilding(n);
	}
	
	//Collect maximum points in a grid using two traversals STL

	 
	
}
