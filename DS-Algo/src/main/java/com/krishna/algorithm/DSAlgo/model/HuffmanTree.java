package com.krishna.algorithm.DSAlgo.model;

public class HuffmanTree {
	
	private int value;
	
	private char charecter ;
	
	private HuffmanTree left;
	
	private HuffmanTree right;
	
	private HuffmanTree next;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public HuffmanTree getLeft() {
		return left;
	}

	public void setLeft(HuffmanTree left) {
		this.left = left;
	}

	public HuffmanTree getRight() {
		return right;
	}

	public void setRight(HuffmanTree right) {
		this.right = right;
	}

	public HuffmanTree getNext() {
		return next;
	}

	public void setNext(HuffmanTree next) {
		this.next = next;
	}

	public char getCharecter() {
		return charecter;
	}

	public void setCharecter(char charecter) {
		this.charecter = charecter;
	}
	
	
	
}
