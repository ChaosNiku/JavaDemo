package com.newcoder.cash.service;

import java.io.IOException;
import java.util.List;

import com.newcoder.cash.entity.Discount;
import com.newcoder.cash.entity.Goods;
import com.newcoder.cash.resource.GoodsResource;
import com.newcoder.cash.utils.DisConverter;

public class CashInit {
	
	public static List<Discount> diss;

	@SuppressWarnings("unused")
	public static void init() {
		try {
			GoodsResource res = new GoodsResource("goods.json");
			List<Goods> list = GoodsResource.getResource();
			diss = DisConverter.GetResource("dis.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Discount> getDiss() {
		return diss;
	}

	public static void setDiss(List<Discount> diss) {
		CashInit.diss = diss;
	}
	
}
