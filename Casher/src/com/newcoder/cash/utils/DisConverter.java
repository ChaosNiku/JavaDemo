package com.newcoder.cash.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newcoder.cash.entity.Discount;
import com.newcoder.cash.entity.Goods;
import com.newcoder.cash.resource.GoodsResource;

/**
 * @author chaos
 * according to the request,there is only one type of discount,but for the sake of extension i
 * i choose to return a collection for containing more types if  it has in the json file
 *
 */
public class DisConverter {
	@SuppressWarnings("unchecked")
	public static List<Discount> GoodsResource(String url) throws IOException {
		InputStream is = GoodsResource.class.getClassLoader().getResourceAsStream(url);
		JsonFactory jf = new JsonFactory();
		JsonParser js = jf.createParser(is);
		ObjectMapper map = new ObjectMapper(jf);
		List<Discount> discounts = new LinkedList<>();
		MappingIterator<Discount> mapit=  map.readValues(js, map.getTypeFactory().constructCollectionType(List.class, Discount.class));
		discounts = (List<Discount>) mapit.nextValue();
		return discounts;
	}
}
