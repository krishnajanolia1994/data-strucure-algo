package com.krishna.algorithm.DSAlgo.docorator;

public class ZinjarBurger implements Burger{
	
	private int price;
	private int description;
	public ZinjarBurger(int price, int description) {
		super();
		this.price = price;
		this.description = description;
	}
	@Override
	public int getPrice() {
		return this.price;
	}
	@Override
	public int getDescription() {
		return this.description;
	}

}
