package cn.com.chenxin.service.JtBank.car;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import cn.com.chenxin.dao.JtBank.JsJdcTest100Mapper;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.model.JtBank.JsJdcTest100;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;
import cn.com.chenxin.utils.DES_Encrypt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 车主数据
 * 
 * @author caoq
 *
 */
@Service
public class CarSearchService {
	/**
	 * logger
	 */
	private static final Logger LOGGER = Logger.getLogger(CarSearchService.class);

	private String isSuccess = "1";
	private String key = "ccsp!@#$";

	@Autowired
	private JsJdcTest100Mapper jdcTestEnyMapper;

	public JSONObject findJtBankCar(LogInfo LogInfo, String params) {
		JSONObject resultJson = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject jsonParams = JSONObject.parseObject(params);
		String xm = jsonParams.getString("xm");
		String sjhm = jsonParams.getString("sjhm");
		String gmsfhm = jsonParams.getString("gmsfhm");
		String psString = xm+"_"+sjhm+"_"+gmsfhm;
		try {
			String sjhmString = DES_Encrypt.encrypt(sjhm, key);
			String gmsfhmString = DES_Encrypt.encrypt(gmsfhm, key);
			Example example = new Example(JsJdcTest100.class);
			example.or().andEqualTo("cz", xm).andEqualTo("sjhm", sjhmString);
			example.or().andEqualTo("cz", xm).andEqualTo("gmsfhm", gmsfhmString);
			List<JsJdcTest100> list = new ArrayList<JsJdcTest100>();
			list = jdcTestEnyMapper.selectByExample(example);
			JsJdcTest100 jdcTestEny = null;

			int size = list.size();
			for (int i = 0; i < size; i++) {
				jdcTestEny = new JsJdcTest100();
				jdcTestEny = list.get(i);
				JSONObject jsonObject = (JSONObject) JSONObject.toJSON(jdcTestEny);
				String sjhmO = jsonObject.getString("sjhmO");
				String qthm = jsonObject.getString("qthm");
				String dhhm = jsonObject.getString("dhhm");
				String sjhmOString = DES_Encrypt.decrypt(sjhmO, key);
				String qthmString = DES_Encrypt.decrypt(qthm, key);
				String dhhmString = DES_Encrypt.decrypt(dhhm, key);
				jsonObject.put("sjhmO", sjhmOString);
				jsonObject.put("qthm", qthmString);
				jsonObject.put("dhhm", dhhmString);
				jsonObject.put("sjhm", sjhm);
				jsonObject.put("gmsfhm", gmsfhm);
				array.add(jsonObject);
			}
			resultJson.put("resultCode", "3");
			resultJson.put("params",psString );
			resultJson.put("data", array);
		} catch (Exception e) {
			isSuccess = "0";
			resultJson.put("resultCode", "0");
			resultJson.put("params",psString );
			resultJson.put("data", array);
			e.printStackTrace();
		}
		LOGGER.info("-------车主数据查询---market- 后台返回 -"+resultJson);
		// 记录日志
		String id = UUID.randomUUID().toString();
		String productcode = System.getProperty("jtBank_Car");
		// 结果 来源
		String datasource = "1";
		SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
		        resultJson.toString(), isSuccess);
		ThreadPool.submitTask(sendProductLogTask);

		return resultJson;

	}

	public static void main(String[] args) {
	 String key = "ccsp!@#$";
		String dataString = "jiAM5tqxvFRxhgaSH4Seuw==";
	try {
	    String aaString = DES_Encrypt.decrypt(dataString, key);
	    System.out.println(aaString);
    } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
	}
}
