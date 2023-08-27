package com.krishna.algorithm.DSAlgo.service.impl;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.service.DevideAndConqureService;
@Component
public class DevideAndConqureServiceImpl implements DevideAndConqureService {

	@Override
	public int getNthPowe(int number, int n) {
		
		int nthPower = calculateNtPower(number,n);
		return nthPower;
	}

	private int calculateNtPower(int number, int n) {
		if(n==1)
			return number;
		int power = number*calculateNtPower(number, n-1);
		return power;
	}

}
