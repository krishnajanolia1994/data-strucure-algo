package com.krishna.algorithm.DSAlgo.model;


public class LinkedList {
	private String name;
	private String surName;
	private LinkedList next;
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public LinkedList getNext() {
		return next;
	}
	public void setNext(LinkedList next) {
		this.next = next ;
	}
}
