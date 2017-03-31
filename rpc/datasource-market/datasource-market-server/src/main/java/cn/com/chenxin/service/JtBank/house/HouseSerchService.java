package cn.com.chenxin.service.JtBank.house;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import cn.com.chenxin.dao.JtBank.JsFzTest100Mapper;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.model.JtBank.JsFzTest100;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;
import cn.com.chenxin.utils.DES_Encrypt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 房主数据
 * 
 * @author caoq
 *
 */
@Service
public class HouseSerchService {
	/**
	 * logger
	 */
	private static final Logger LOGGER = Logger.getLogger(HouseSerchService.class);

	private String isSuccess = "1";
	private String key = "ccsp!@#$";
	@Autowired
	private JsFzTest100Mapper jsFzTestEnyMapper;

	public JSONObject findJtBankHouse(LogInfo LogInfo, String params) {
		JSONObject resultJson = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject jsonParams = JSONObject.parseObject(params);
		String xm = jsonParams.getString("xm");
		String sjhm = jsonParams.getString("sjhm");
		try {
			String sjhmString = DES_Encrypt.encrypt(sjhm, key);
			Example example = new Example(JsFzTest100.class);
			example.or().andEqualTo("xm", xm);
			example.or().andEqualTo("sjhm", sjhmString);
			
			List<JsFzTest100> list = new ArrayList<JsFzTest100>();
			list = jsFzTestEnyMapper.selectByExample(example);
			JsFzTest100 fzTestEny = null;

			int size = list.size();
			for (int i = 0; i < size; i++) {
				fzTestEny = new JsFzTest100();
				fzTestEny = list.get(i);
				JSONObject jsonObject = (JSONObject) JSONObject.toJSON(fzTestEny);
				jsonObject.put("sjhm", sjhm);
				array.add(jsonObject);
			}
			resultJson.put("resultCode", "3");
			resultJson.put("params", xm+"_"+sjhm);
			resultJson.put("data", array);
		} catch (Exception e) {
			isSuccess = "0";
			resultJson.put("resultCode", "0");
			resultJson.put("params",  xm+"_"+sjhm);
			resultJson.put("data", array);
			e.printStackTrace();
		}
		LOGGER.info("-----房主数据查询--后台数据----market----"+resultJson);
		// 记录日志
		String id = UUID.randomUUID().toString();
		String productcode = System.getProperty("jtBank_Fz");
		// 结果 来源
		String datasource = "1";
		SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
		        resultJson.toString(), isSuccess);
		ThreadPool.submitTask(sendProductLogTask);

		return resultJson;

	}
}
