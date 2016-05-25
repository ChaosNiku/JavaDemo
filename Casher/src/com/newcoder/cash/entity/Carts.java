package com.newcoder.cash.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chaos
 *
 */
public class Carts {
	private static List<ShoppingInfo> carts;
	
	
	public Carts() {
		super();
		Carts.carts = new LinkedList<ShoppingInfo>();
	}


	public static boolean addGood(ShoppingInfo info){
		if(info==null||info.getNum()<=0){
			return false;
		}

		boolean flag=carts.add(info);
		return flag;
	}
	public static boolean removeGood(ShoppingInfo info){
		if(info==null){
			return false;
		}
		boolean flag =false;
		for(ShoppingInfo i:carts){
			if(i.getGood().getName().equals(info.getGood().getName())){
				flag= carts.remove(i);
				
			}
		}
			return flag;
	}
}
