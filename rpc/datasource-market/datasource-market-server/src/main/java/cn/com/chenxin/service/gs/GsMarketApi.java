package cn.com.chenxin.service.gs;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;

import cn.com.chenxin.iface.DatasourceMarketGsThrift.Iface;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;
import cn.com.chenxin.utils.SpringInit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GsMarketApi implements Iface {
	private String isSuccess = "1";

	/*
	 * 动产抵押物信息 企业投资信息 企业变更信息
	 */
	@Override
	public String findMorCorInvestment(LogInfo LogInfo, String params) throws TException {

		CorporateInvestmentService serviceOne = (CorporateInvestmentService) SpringInit.getApplicationContext().getBean("corporateInvestmentService");
		ChattelMortgageService serviceTwo = (ChattelMortgageService) SpringInit.getApplicationContext().getBean("chattelMortgageService");
		JSONObject result = new JSONObject();
		JSONObject paramJsonObject = JSONObject.parseObject(params);
		String pripid = paramJsonObject.getString("pripid").trim();
		if (StringUtils.isNotBlank(pripid)) {
			JSONObject jsonOne = serviceOne.getCorporateInvestment(pripid);
			JSONObject jsonTwo = serviceTwo.getChattelMortgage(pripid);
			result.putAll(jsonOne);
			result.putAll(jsonTwo);
			result.put("resultCode", "3");
			result.put("desc", "查询成功");

		} else {
			result.put("resultCode", "1");
			result.put("desc", "查询失败，输入参数有误");
		}
		// 添加日志

		String id = UUID.randomUUID().toString();
		String productcode = System.getProperty("gs_MorCorInvestment");
		// 结果 来源
		String datasource = "1";
		SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params,
		        result.toJSONString(), isSuccess);
		ThreadPool.submitTask(sendProductLogTask);

		return result.toString();
	}

}
