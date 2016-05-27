package com.newcoder.cash.test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.newcoder.cash.entity.Goods;
import com.newcoder.cash.resource.GoodsResource;

public class GetResourceTest {
	
	@Test
	public void GetGoods(){
		try {
			@SuppressWarnings("unused")
			GoodsResource res =new GoodsResource("goods.json");
			List<Goods> list = GoodsResource.getResource();
			for(Goods g:list){
				System.out.println(g);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
