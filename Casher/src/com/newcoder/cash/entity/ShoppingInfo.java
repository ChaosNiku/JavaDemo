package com.newcoder.cash.entity;

/**
 * @author chaos
 * @version 0.23
 *	entity contains goods ,number of shopping ,total price,the money has been saved and whether the good is discount
 */
public class ShoppingInfo {
	private Goods good;
	//quananty of the good	
	private int num;
	//is the good half price,not required
	private boolean isDis;
	private double sumprice;
	//the money you have saved
	private double disprice;
	
	//basic constructor using part field
	public ShoppingInfo(Goods good, int num) {
		super();
		this.good = good;
		this.num = num;
	}
	
		
	public ShoppingInfo(Goods good, int num, boolean isDis, double sumprice) {
		super();
		this.good = good;
		this.num = num;
		this.isDis = isDis;
		this.sumprice = sumprice;
	}

	
	
	public ShoppingInfo(Goods good, int num, boolean isDis, double sumprice, double disprice) {
		super();
		this.good = good;
		this.num = num;
		this.isDis = isDis;
		this.sumprice = sumprice;
		this.disprice = disprice;
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


	public boolean isDis() {
		return isDis;
	}


	public void setDis(boolean isDis) {
		this.isDis = isDis;
	}


	public double getSumprice() {
		return sumprice;
	}


	public void setSumprice(double sumprice) {
		this.sumprice = sumprice;
	}


	public double getDisprice() {
		return disprice;
	}


	public void setDisprice(double disprice) {
		this.disprice = disprice;
	}
	
	
}
