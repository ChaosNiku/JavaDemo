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
		for(ShoppingInfo info:cart){
			//		需要一List存放
			if(info.isDis()) flag=true;
			objmap.put("名称", info.getGood().getName());
			objmap.put("数量", String.valueOf(info.getNum())+info.getGood().getUnit());
			objmap.put("单价", info.getGood().getPrice());
			objmap.put("小计", info.getSumprice());
			json.append(map.writeValueAsString(objmap));
			objmap.clear();
			totalPrice+=info.getSumprice();
			}
		if(flag){
		objmap.clear();
		for(ShoppingInfo info:cart){
			if(info.isDis()){
				objmap.put("名称", info.getGood().getName());
				objmap.put("数量", String.valueOf(info.getDisprice()/info.getGood().getPrice()*2)+info.getGood().getUnit());
				json.append(map.writeValueAsString(objmap));
				objmap.clear();
				totalDisPrice+=info.getDisprice();
				}
			}
		}
		objmap.put("总计", String.valueOf(totalPrice));
		if(flag){
			objmap.put("节省", String.valueOf(totalDisPrice));
		}
		json.append(map.writeValueAsString(objmap));
		return json.toString();
		
	}
}
