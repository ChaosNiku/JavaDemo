package com.newcoder.cash.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author chaos
 *
 */
public class AbstractGoods {

	private String name;
	private String unit;
	private String category;
	private String subCategory;
	// unreal barcode
	private String barcode;
	private double price;
	
	
	//constructor using all fields	
	public AbstractGoods(String name, String unit, String category, String subCategory, String barcode,
			double price) {
		super();
		this.name = name;
		this.unit = unit;
		this.category = category;
		this.subCategory = subCategory;
		this.barcode = barcode;
		this.price = price;
	}
	//	default constructors
	public AbstractGoods() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "AbstractGoods [name=" + name + ", unit=" + unit + ", category=" + category
				+ ", subCategory=" + subCategory + ", barcode=" + barcode + ", price=" + price + "]";
	}
	
}

