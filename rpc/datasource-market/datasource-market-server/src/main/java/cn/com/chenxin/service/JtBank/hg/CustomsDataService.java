package cn.com.chenxin.service.JtBank.hg;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import cn.com.chenxin.dao.JtBank.JsHgTest100Mapper;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.model.JtBank.JsHgTest100;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 海关数据
 * 
 * @author caoq
 *
 */
@Service
public class CustomsDataService {
	/**
	 * logger
	 */
	private static final Logger LOGGER = Logger.getLogger(CustomsDataService.class);

	private String isSuccess = "1";

	@Autowired
	private JsHgTest100Mapper hgTestEnyMapper;

	public JSONObject findJtBankHG(LogInfo LogInfo, String params) {
		JSONObject resultJson = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject jsonParams = JSONObject.parseObject(params);
		String company = jsonParams.getString("company");
		try {
			Example example = new Example(JsHgTest100.class);
			example.or().andEqualTo("consignorCname", company);
			example.or().andEqualTo("consigneeCname", company);
			List<JsHgTest100> list = new ArrayList<JsHgTest100>();
			list = hgTestEnyMapper.selectByExample(example);
			JsHgTest100 hgTestEny = null;

			int size = list.size();
			for (int i = 0; i < size; i++) {
				hgTestEny = new JsHgTest100();
				hgTestEny = list.get(i);
				JSONObject hgJsonObject = (JSONObject) JSONObject.toJSON(hgTestEny);
				array.add(hgJsonObject);
			}
			resultJson.put("resultCode", "3");
			resultJson.put("params", company);
			resultJson.put("data", array);
		} catch (Exception e) {
			isSuccess = "0";
			resultJson.put("resultCode", "0");
			resultJson.put("params", company);
			resultJson.put("data", array);
			e.printStackTrace();
		}
		LOGGER.info("-----海关数据查询--后台数据----market----"+resultJson);
		// 记录日志
		String id = UUID.randomUUID().toString();
		String productcode = System.getProperty("jtBank_Hg");
		// 结果 来源
		String datasource = "1";
		SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
		        resultJson.toString(), isSuccess);
		ThreadPool.submitTask(sendProductLogTask);

		return resultJson;

	}
}
