package cn.com.chenxin.service.sfhc;

import java.util.UUID;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.chenxin.dao.JsSfhcXmGmsfhmMapper;
import cn.com.chenxin.dao.JsSfhcXmSjhmMapper;
import cn.com.chenxin.iface.DatasourceMarketSfhcThrift.Iface;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;
import cn.com.chenxin.utils.EnySha;

@Service
public class SfhcCxService {
	@Autowired
    private JsSfhcXmGmsfhmMapper jsSfhcXmGmsfhmMapper;
	@Autowired
    private JsSfhcXmSjhmMapper jsSfhcXmSjhmMapper;

   
    /**
     * 
     * @param xm
     *            姓名
     * @param gmsfhm
     *            公民身份号码
     * @return 查询数据集市结果
     */
	public String findSfhcByNameAndCode(LogInfo LogInfo, String params)
			throws TException {
		// TODO Auto-generated method stub
		JSONObject jsonParams = JSONObject.parseObject(params);
		String xm = jsonParams.getString("xm");
		String gmsfhm = jsonParams.getString("gmsfhm");
		gmsfhm = EnySha.gcode(gmsfhm);
        
  //     LOGGER.info("queryXmGmsfhm  Result:" + queryXmGmsfhm);
        JSONObject resjo = new JSONObject();
       String isSuccess = "1";
       try {
    	  
    	   Integer queryXmGmsfhm = this.jsSfhcXmGmsfhmMapper.sfhcCxService1QueryXmGmsfhm(xm, gmsfhm);
    	   if (null != queryXmGmsfhm) {
    		   //  return "3#C001";
    		   resjo.put("resultCode", "3");
    		   JSONArray arr = new JSONArray();
    		   arr.add("C001");
    		   resjo.put("reasonCode",arr);
    		   //	return resjo.toString();
    	   } else {
    		   Integer queryGmsfhm = this.jsSfhcXmGmsfhmMapper.sfhcCxService1QueryGmsfhm(gmsfhm);
    		   //         LOGGER.info("queryGmsfhm  Result:" + queryGmsfhm);
    		   if (null != queryGmsfhm) {
    			   //   return "1";
    			   resjo.put("resultCode", "1");
    			   JSONArray arr = new JSONArray();
    			  // arr.add("");
    			   resjo.put("reasonCode",arr);
    			   //	return resjo.toString();
    			   
    		   } else {
    			   //    return "0";
    			   resjo.put("resultCode", "0");
    			   JSONArray arr = new JSONArray();
    			  // arr.add("");
    			   resjo.put("reasonCode",arr);
    			   //	return resjo.toString();
    		   }
    	   }
	} catch (Exception e) {
		// TODO: handle exception
		isSuccess = "-1";
	} 

     // 添加日志
        String id=UUID.randomUUID().toString();
        String productcode = System.getProperty("sfhc_namecode");
        // 结果 来源
        String datasource ="1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(), resjo.toString(),
                isSuccess);
        ThreadPool.submitTask(sendProductLogTask);
        
        
        return resjo.toString();
	}



	
	 /**
     * 
     * @param xm
     *            姓名
     * @param sjhm
     *            手机号码
     * @return 查询数据集市结果
     */
	public String findSfhcByNameAndPhone(LogInfo LogInfo, String params)
			throws TException {
		// TODO Auto-generated method stub
		JSONObject jsonParams = JSONObject.parseObject(params);
		String xm = jsonParams.getString("xm");
		String sjhm = jsonParams.getString("sjhm");
		sjhm = EnySha.gcode(sjhm);
		String isSuccess = "1";
        
     //   LOGGER.info("queryXmSjhm  Result:" + queryXmSjhm);
        
        JSONObject resjo = new JSONObject();
        
        
        try {
        	Integer queryXmSjhm = this.jsSfhcXmSjhmMapper.sfhcCxService2QueryXmSjhm(xm, sjhm);
        	if (null != queryXmSjhm) {
        		//    return "3#C001";
        		resjo.put("resultCode", "3");
        		JSONArray arr = new JSONArray();
        		arr.add("C001");
        		resjo.put("reasonCode",arr);
        		//	return resjo.toString();
        	} else {
        		Integer querySjhm = this.jsSfhcXmSjhmMapper.sfhcCxService2QuerySjhm(sjhm);
        		//      LOGGER.info("querySjhm  Result:" + querySjhm);
        		if (null != querySjhm) {
        			//          return "1";
        			resjo.put("resultCode", "1");
        			JSONArray arr = new JSONArray();
        			//arr.add("");
        			resjo.put("reasonCode",arr);
        			//	return resjo.toString();
        		} else {
        			//          return "0";
        			resjo.put("resultCode", "0");
        			JSONArray arr = new JSONArray();
        			//arr.add("");
        			resjo.put("reasonCode",arr);
        			//	return resjo.toString();
        		}
        	}
		} catch (Exception e) {
			// TODO: handle exception
			isSuccess = "-1";
		}
        
        
        
        
        
     // 添加日志
        String id=UUID.randomUUID().toString();
        String productcode = System.getProperty("sfhc_namephone");
        // 结果 来源
        String datasource ="1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(), resjo.toString(),
                isSuccess);
        ThreadPool.submitTask(sendProductLogTask);
        
        return resjo.toString();
	}
	
	
    
}
