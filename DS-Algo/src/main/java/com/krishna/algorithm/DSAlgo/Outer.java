package com.krishna.algorithm.DSAlgo;

public class Outer {
	
	private int x=0;

	public Outer(int x) {
		super();
		this.x = x;
	}
	
	public class Inner {
		
		public void show() {
			System.out.println("inner");
		}
	}

}
