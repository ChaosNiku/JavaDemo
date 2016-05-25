package com.newcoder.cash.entity;

public class ShoppingInfo {
	private Goods good;
	//quananty of the good	
	private int num;
	
	public ShoppingInfo(Goods good, int num) {
		super();
		this.good = good;
		this.num = num;
	}
	public ShoppingInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods getGood() {
		return good;
	}
	public void setGood(Goods good) {
		this.good = good;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
