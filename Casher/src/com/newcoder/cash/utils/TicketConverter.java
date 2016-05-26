package com.newcoder.cash.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.newcoder.cash.entity.Goods;
import com.newcoder.cash.entity.ShoppingInfo;

public class TicketConverter {
	
	public static List<ShoppingInfo> convert(String[] args){
		List<ShoppingInfo> list =new ArrayList<ShoppingInfo>();
		List<String> types = new LinkedList<>();	
		for(String s:args){
			Goods good = new Goods();
			good.setBarcode(s);
			if(s.contains("-")){
				String[] bar =new String[2];
				bar=s.split("-");
				int num = Integer.parseInt(bar[1]);
				good.setBarcode(bar[0]);
				types.add(bar[0]);
				list.add(new ShoppingInfo(good, num));
				continue;
			}
			if(!types.contains(s)){
				types.add(s);
				list.add(new ShoppingInfo(good, 0));
			}
			for(ShoppingInfo i:list){
				if(i.getGood().getBarcode().equals(s)){
					list.remove(i);
					list.add(new ShoppingInfo(i.getGood(),i.getNum()+1));
				}
			}
		}
		return list;	
	}
}
