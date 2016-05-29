package com.newcoder.cash.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newcoder.cash.entity.ShoppingInfo;

/**
 * @author chaos
 * the list cart contains goods data that already calculated
 *
 */
public class TicketsGnerator {
	public static String generate(List<ShoppingInfo> cart) throws JsonProcessingException{
		StringBuffer json = new StringBuffer();
		double totalPrice =0.0;
		double totalDisPrice =0.0;
		ObjectMapper map = new ObjectMapper();
		Map<String,Object> objmap = new HashMap<>();
		boolean flag =false;
		json.append("{\"shoppingList\":[");
		int i=1;
		int count =0;
		for(ShoppingInfo info:cart){
			if(info.isDis()){
				flag=true;
				count++;
			}
			objmap.put("designation", info.getGood().getName());
			objmap.put("count", String.valueOf(info.getNum())+info.getGood().getUnit());
			objmap.put("unitPrice", info.getGood().getPrice());
			objmap.put("subtotal", info.getSumprice());
			if(i<cart.size())
			json.append(map.writeValueAsString(objmap)+",");
			else json.append(map.writeValueAsString(objmap));
			objmap.clear();
			totalPrice+=info.getSumprice();
			i++;
			}
		json.append("],\"discount\":[");
		if(flag){
		objmap.clear();
		i=0;
		for(ShoppingInfo info:cart){
			if(info.isDis()){
				i++;
				objmap.put("designation", info.getGood().getName());
				objmap.put("count", String.valueOf(info.getDisprice()/info.getGood().getPrice()*2)+info.getGood().getUnit());
				totalDisPrice+=info.getDisprice();
				if(i<count) json.append(map.writeValueAsString(objmap)+",");
				else  json.append(map.writeValueAsString(objmap));
				objmap.clear();
				}
			}
		}
		json.append("],\"total\":"+String.valueOf(totalPrice));
		if(flag){
			json.append(",\"save\":"+String.valueOf(totalDisPrice));
		}
		json.append("}");
		return json.toString();
		
	}
}
