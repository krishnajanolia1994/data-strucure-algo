package com.krishna.algorithm.DSAlgo.docorator;

public class GarlicBurger implements Burger{
	
	private int price;
	private int description;
	public GarlicBurger(int price, int description) {
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
