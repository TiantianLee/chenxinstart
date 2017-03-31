package cn.com.chenxin.service.hmd;

import com.alibaba.fastjson.JSONObject;

import cn.com.chenxin.iface.LogInfo;

public class HmdDhSercice {
	
	
	//根据姓名和身份证号码查找DH失信、网贷
	public String findHmdByNameAndCode(LogInfo LogInfo,String params){
		JSONObject json = new JSONObject();
		json.put("resultcode", "-1");
		return json.toString();
	}
	
	//根据姓名和手机号码查找DH网贷
	public String findHmdByNameAndPhone(LogInfo LogInfo,String params){
		JSONObject json = new JSONObject();
		json.put("resultcode", "-1");
		return json.toString();
	}

}
