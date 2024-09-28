package com.example.acurator;

public class  MyClone<T extends Comparable<T>> implements Cloneable , MinMax<T > {
	
	private int a;

	public MyClone(int a) {
		super();
		this.a = a;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	@Override
	public MyClone clone() {
		MyClone clo = null;
		try {
			clo= (MyClone) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clo;
	}
	
	
	

}
