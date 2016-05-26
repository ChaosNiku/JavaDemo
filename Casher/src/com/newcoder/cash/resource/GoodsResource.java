package com.newcoder.cash.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newcoder.cash.entity.Goods;

/**
 * @author chaos
 * demo don't have a db
 * this class read  & parse the json 
 * load all the goods info. to a static list
 */
public class GoodsResource {
	public static List<Goods> resource;

	@SuppressWarnings("unchecked")
	public GoodsResource(String url) throws IOException {
		super();
		 InputStream is = GoodsResource.class.getClassLoader().getResourceAsStream(url);
		 JsonFactory jf =new JsonFactory();
		 JsonParser js= jf.createParser(is);
		 ObjectMapper map = new ObjectMapper(jf);
		 MappingIterator<Goods> mapit=  map.readValues(js, map.getTypeFactory().constructCollectionType(List.class, Goods.class));
		 setResource((List<Goods>) mapit.nextValue());
	}
 
	public static List<Goods> getResource() {
		return resource;
	}

	public static void setResource(List<Goods> resource) {
		GoodsResource.resource = resource;
	}
	
}
