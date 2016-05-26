package com.newcoder.cash.service;

import java.util.LinkedList;
import java.util.List;

import com.newcoder.cash.entity.Discount;
import com.newcoder.cash.entity.Goods;
import com.newcoder.cash.entity.ShoppingInfo;
import com.newcoder.cash.resource.GoodsResource;

public class CashSolve {
	
	
	public static List<ShoppingInfo> cash(List<ShoppingInfo> cart,Discount dis){
		List<ShoppingInfo> mycarts = new LinkedList<>();
		for(ShoppingInfo info:cart){
			for(Goods g:GoodsResource.getResource()){
				if(info.getGood().getBarcode().equals(g.getBarcode()))
				info.setGood(g);
			}
		}
		for(ShoppingInfo info:cart){
			boolean flag =false;
			if(info.getNum()>=2){
				for(String s:dis.getBarcodes()){
					if(info.getGood().getBarcode().equals(s)){
						int left =info.getNum()%2;
						double price = (double)(left*info.getGood().getPrice())+(double)(info.getNum()/2*info.getGood().getPrice()*1.50);
						double disprice = (double)(info.getNum()*info.getGood().getPrice())-price;
						info.setSumprice(price);
						info.setDis(true);
						info.setDisprice(disprice);
						mycarts.add(info);
						flag=true;
						break;
					}
				}
			}
			if(!flag){
			double price = (double)(info.getNum()*info.getGood().getPrice());
			info.setDis(false);
			info.setSumprice(price);
			mycarts.add(info);
			}
			flag =false;
		}
		
		return mycarts;
	}
}
