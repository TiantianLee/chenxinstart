package cn.com.chenxin.service.grey;

import java.util.UUID;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.chenxin.dao.JsGmdJkMapper;
import cn.com.chenxin.iface.DatasourceMarketGreyThrift.Iface;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.model.JsGmdJk;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;
import cn.com.chenxin.utils.SpringInit;

@Service
public class GreyCxService implements Iface{
	
	/*@Autowired
    private JsGmdJkMapper gmdJkMapper;*/
	@Override
	public String findGreyByNameAndCode(LogInfo LogInfo, String params)
			throws TException {
		// TODO Auto-generated method stub
		JsGmdJkMapper gmdJkMapper = (JsGmdJkMapper) SpringInit.getApplicationContext().getBean("jsGmdJkMapper");	
		JSONObject json = JSONObject.parseObject(params);
		String xm = json.getString("xm");
		String gmsfhm =json.getString("gmsfhm");
		String isSuccess = "1";
		
		JsGmdJk jsGmdJk = new JsGmdJk();
        jsGmdJk.setXm(xm);
        jsGmdJk.setGmsfhm(gmsfhm);
        Integer queryGrsx = null;
        try {
        	 queryGrsx = gmdJkMapper.selectCount(jsGmdJk);
			
		} catch (Exception e) {
			// TODO: handle exception
			isSuccess = "-1";
		}
    //    LOGGER.info("----GreyCxServiceImpl ----------- 数据库返回结果:" + queryGrsx);

    //    String yym = "";
        JSONObject resjo = new JSONObject();
        if (null != queryGrsx) {
            if (queryGrsx > 0) {
   //           yym = "1#A901";
            	resjo.put("resultCode", "1");
            	JSONArray arr = new JSONArray();
            	arr.add("A901");
            	resjo.put("reasonCode",arr);
            	
            } else {
            	resjo.put("resultCode", "2");
            	JSONArray arr = new JSONArray();
            	arr.add("");
            	resjo.put("reasonCode",arr);
            }
        }
        
     // 添加日志
        String id=UUID.randomUUID().toString();
        String productcode = System.getProperty("grey_namecode");
        // 结果 来源
        String datasource ="1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(), resjo.toString(),
                isSuccess);
        ThreadPool.submitTask(sendProductLogTask);
        
        return resjo.toString();
		
		
	}

}
