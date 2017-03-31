package com.cx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

import cn.com.chenxin.service.fullInfo.FullInfoTBService;
import cn.com.chenxin.utils.SpringInit;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestJUnitMarket {
	@Autowired
	private FullInfoTBService  fullInfoTBService;
	@Test
	public void textFullinfoC(){
	//	FullInfoTBService fullInfoTBService = (FullInfoTBService) SpringInit.getApplicationContext().getBean("fullInfoTBService");
		JSONObject params =new JSONObject();
		params.put("userCode", "administrator");
		params.put("xm", "oaIsq40LnvbqTBTw2J3JlQ==");
		params.put("sjhm", "xhDMDZDTQZJNMXe763c5gA==");
		params.put("gmsfhm", "administrator");
		String a=fullInfoTBService.getFullInfoC(null, "administrator", "oaIsq40LnvbqTBTw2J3JlQ==", "xhDMDZDTQZJNMXe763c5gA==", "administrator").toString();
		
		System.out.println("====>"+a);
	}
}
