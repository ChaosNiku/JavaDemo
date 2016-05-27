package com.newcoder.cash.test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.newcoder.cash.entity.Discount;
import com.newcoder.cash.entity.ShoppingInfo;
import com.newcoder.cash.service.CashSolve;
import com.newcoder.cash.utils.SimpleParser;
import com.newcoder.cash.utils.TicketConverter;
import com.newcoder.cash.utils.TicketsGnerator;

public class ConverTest {
	TicketConverter tc = new TicketConverter();
	List<ShoppingInfo> l = new LinkedList<ShoppingInfo>();
	@Test
	public void convert() {
		
		try {
			l = TicketConverter.convert(SimpleParser.simpleparser("[ \"ITEM000001\", \"ITEM000001\", \"ITEM000001\", \"ITEM000001\", \"ITEM000001\", \"ITEM000003-2\", \"ITEM000005\", \"ITEM000005\", \"ITEM000005\" ]"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ShoppingInfo i : l) {
			System.out.println("good:" + i.getGood().toString() + "  num:" + i.getNum());
		}

	}

	@Test
	public void cal() {
		System.out.println("START");
		new GetResourceTest().GetGoods();
		convert();
		System.out.println("-----------------------------");
		l=CashSolve.cash(l, new Discount("half", new String[]{"ITEM000005", "ITEM000001"}) );
		for (ShoppingInfo i : l) {
			System.out.println("good:" + i.getGood().toString() + "  num:" + i.getNum()+" sum:"+i.getSumprice()+" dis:"+i.getDisprice());
		}
		try {
			String json=TicketsGnerator.generate(l);
			System.out.println("ticket:  "+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("                ");
	}
}
