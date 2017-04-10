package cn.com.chenxin.utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Cache {

	public static Map<String,String> map = Collections.synchronizedMap(new TreeMap<String, String>());
	
	public static List<String> list = Collections.synchronizedList(new LinkedList<String>());
	
}
