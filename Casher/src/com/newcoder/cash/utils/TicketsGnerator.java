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
			//		��ҪһList���
			if(info.isDis()) flag=true;
			objmap.put("����", info.getGood().getName());
			objmap.put("����", String.valueOf(info.getNum())+info.getGood().getUnit());
			objmap.put("����", info.getGood().getPrice());
			objmap.put("С��", info.getSumprice());
			json.append(map.writeValueAsString(objmap));
			objmap.clear();
			totalPrice+=info.getSumprice();
			}
		if(flag){
		objmap.clear();
		for(ShoppingInfo info:cart){
			if(info.isDis()){
				objmap.put("����", info.getGood().getName());
				objmap.put("����", String.valueOf(info.getDisprice()/info.getGood().getPrice()*2)+info.getGood().getUnit());
				json.append(map.writeValueAsString(objmap));
				objmap.clear();
				totalDisPrice+=info.getDisprice();
				}
			}
		}
		objmap.put("�ܼ�", String.valueOf(totalPrice));
		if(flag){
			objmap.put("��ʡ", String.valueOf(totalDisPrice));
		}
		json.append(map.writeValueAsString(objmap));
		return json.toString();
		
	}
}
