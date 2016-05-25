package com.newcoder.cash.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.newcoder.cash.entity.ShoppingInfo;
import com.newcoder.cash.utils.TicketConverter;

public class ConverTest {
	TicketConverter tc = new TicketConverter();
	
	@Test
	public void test(){
		List<ShoppingInfo> l = new LinkedList<ShoppingInfo>();
		l =tc.convert(new String[]{ "ITEM000001", "ITEM000001", "ITEM000001", "ITEM000001", "ITEM000001", "ITEM000003-2", "ITEM000005", "ITEM000005", "ITEM000005"});
		for(ShoppingInfo i:l){
			System.out.println("good:"+i.getGood().toString()+"  num:"+i.getNum());
		}
	}
}
