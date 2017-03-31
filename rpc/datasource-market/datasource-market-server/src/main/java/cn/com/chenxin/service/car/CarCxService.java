package cn.com.chenxin.service.car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.chenxin.dao.JsGmdJkMapper;
import cn.com.chenxin.dao.JsJdcGrtjMapper;
import cn.com.chenxin.iface.DatasourceMarketCarThrift.Iface;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.model.JsJdcGrtj;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;
import cn.com.chenxin.utils.SpringInit;

public class CarCxService implements Iface {
	// @Autowired
	// private JsJdcGrtjMapper jdcGrtjMapper;//
	private String isSuccess = "1";

	@Override
	/**
	 * @Description: 查询数据库
	 * @param xm
	 *            姓名
	 * @param gmsfhm
	 *            身份证号
	 * @return List<JsJdcGrtj>
	 * @time:2016年3月8日 上午9:37:04
	 */
	public String findCarByNameAndCode(LogInfo LogInfo, String params)
			throws TException {
		// TODO Auto-generated method stub
		JsJdcGrtjMapper jdcGrtjMapper = (JsJdcGrtjMapper) SpringInit.getApplicationContext().getBean("jsJdcGrtjMapper");

		JSONObject json = JSONObject.parseObject(params);
		String gmsfhm = json.getString("gmsfhm");
		String xm = json.getString("xm");
		List<JsJdcGrtj> listGmsfhm = jdcGrtjMapper.carXmGmsfhm(gmsfhm, xm);
		JSONObject jj = new JSONObject();
		jj.put("list", listGmsfhm);
		return this.getCode(LogInfo, jj.toString());
	}

	@Override
	public String findCarByNameAndPhone(LogInfo LogInfo, String params)
			throws TException {
		// TODO Auto-generated method stub
		JSONObject json = JSONObject.parseObject(params);

		JsJdcGrtjMapper jdcGrtjMapper = (JsJdcGrtjMapper) SpringInit
				.getApplicationContext().getBean("jsJdcGrtjMapper");
		String sjhm = json.getString("sjhm");
		String xm = json.getString("xm");
		JsJdcGrtj jdcGrtj = new JsJdcGrtj();
		jdcGrtj.setCz(xm);
		jdcGrtj.setSjhm(sjhm);
		List<JsJdcGrtj> listSjhm = new ArrayList<JsJdcGrtj>();
		try {
			listSjhm = jdcGrtjMapper.select(jdcGrtj);
		} catch (Exception e) {
			// TODO: handle exception
			isSuccess = "-1";
		}

		JSONObject jj = new JSONObject();
		jj.put("list", listSjhm);

		// System.out.println("================"+jj.toString());

		return this.getCode(LogInfo, jj.toString());
	}

	@Override
	public String getCode(LogInfo LogInfo, String params) throws TException {
		// TODO Auto-generated method stub

		JSONObject json = JSONObject.parseObject(params);
		// String str = json.getString("list");
		JSONObject obj = new JSONObject();
		// List<JsJdcGrtj> list = (List<JsJdcGrtj>)json.get("list");
		JSONArray list = json.getJSONArray("list");

		BigDecimal number = new BigDecimal(0);
		String pjstring = "";
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				JsJdcGrtj jsJdcGrtj = JSONObject.toJavaObject(
						list.getJSONObject(i), JsJdcGrtj.class);
				BigDecimal carnum = jsJdcGrtj.getCnt();
				pjstring = jsJdcGrtj.getPj();
				number = number.add(carnum);

			}
			// String codeString = "3#C001,"+number + "," + pjstring;
			obj.put("reasonCode", "C001");
			obj.put("resultCode", "3");
			JSONObject data = new JSONObject();
			data.put("number", number);
			data.put("pj", pjstring);
			obj.put("data", data);

		} else {
			obj.put("resultCode", "0");

			// return "0";
		}

		// 添加日志
		String id = UUID.randomUUID().toString();
		String productcode = System.getProperty("car_namecodesj");
		// 结果 来源
		String datasource = "1";
		SendProductLogTask sendProductLogTask = new SendProductLogTask(
				JSON.toJSON(LogInfo), id, productcode, datasource, "1",
				params.toString(), obj.toString(), isSuccess);
		ThreadPool.submitTask(sendProductLogTask);

		return obj.toString();

	}

	@Override
	public String findCar(LogInfo LogInfo, String params) throws TException {
		// TODO Auto-generated method stub
		JSONObject json = JSONObject.parseObject(params);
		// String xm = json.getString("xm");
		String sjhm = json.getString("sjhm");
		String gmsfhm = json.getString("gmsfhm");
		String res = "";
		if (StringUtils.isNotBlank(sjhm) && StringUtils.isBlank(gmsfhm)) {

		//	LogInfo llo = new LogInfo();
			res = this.findCarByNameAndPhone(LogInfo, params);
		} else if (StringUtils.isNotBlank(gmsfhm) && StringUtils.isBlank(sjhm)) {
			res = this.findCarByNameAndCode(LogInfo, params);
		}
		return res;
	}

	/*
	 * public static void main(String[] args) throws Exception { String xm =
	 * "安佩东"; String gmsfhm = "524646508646461444"; JSONObject json = new
	 * JSONObject(); json.put("xm", xm); json.put("gmsfhm", gmsfhm);
	 * CarCxService cc = new CarCxService(); LogInfo ll = new LogInfo();
	 * System.out.println(cc.findCarByNameAndCode(ll, json.toString())); }
	 */

}
