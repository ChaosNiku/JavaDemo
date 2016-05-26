package com.newcoder.cash.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SimpleParser {
	public static String[] simpleparser(String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper map = new ObjectMapper();
		String[] jsons = map.readValue(json, String[].class);
		return jsons;
	}
}
