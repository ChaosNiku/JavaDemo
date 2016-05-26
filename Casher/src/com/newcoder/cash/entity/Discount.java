package com.newcoder.cash.entity;

//according to data type ,it may have more kinds of discount type
public class Discount {
	private String type;
	private String[] barcodes;
	
	
	public Discount(String type, String[] barcodes) {
		super();
		this.type = type;
		this.barcodes = barcodes;
	}


	public Discount() {
		super();
		this.barcodes =new String[528528];
		// TODO Auto-generated constructor stub
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String[] getBarcodes() {
		return barcodes;
	}


	public void setBarcodes(String[] barcodes) {
		this.barcodes = barcodes;
	}
	
	public void addBarcodes(String barcode){
		int count=0;
		for(String s:barcodes){
			if(s!=null&&!s.equals(""))
			count++;
		}
		if(count==0||count>barcode.length()) return;
		barcodes[count+1] =barcode;
	}
}
