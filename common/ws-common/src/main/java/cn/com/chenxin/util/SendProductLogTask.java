package cn.com.chenxin.util;

import org.apache.log4j.Logger;

import cn.com.chenxin.entity.Log_product;
import cn.com.chenxin.message.CommonMessageSender;
import cn.com.chenxin.pool.threadpool.ThreadPool;

import com.alibaba.fastjson.JSONObject;

/**
 *   添加产品转发日志
 * @author lxl
 *
 */
public class SendProductLogTask implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(SendProductLogTask.class);
    
    
    private Object object;
    private String id;
    private String productCode;
    private String dataType;
    private String forwardLevel;
    private String params;
    private String result;
    private String isSuccess;
    private String out_webserviceName;
    private String out_webserviceUrl;
    private String out_result;
    
    /**
     * 
     * @param object 日志信息
     * @param id ID
     * @param productCode 产品code
     * @param dataType 数据来源
     * @param forwardLevel 转发层次
     * @param params 参数
     * @param result 结果
     * @param isSuccess 是否成功
     * @param out_webserviceName 外部接口名称
     * @param out_webserviceUrl  外部接口url
     * @param out_Result 调用外部接口结果
     */
    public SendProductLogTask(Object object,String id,String productCode,String dataType,String forwardLevel,String params,String result,String isSuccess,
    		String out_webserviceName,String out_webserviceUrl,String out_result) {

        this.object = object;
        this.id = id;
        this.productCode = productCode;
        this.dataType = dataType;
        this.forwardLevel = forwardLevel;
        this.params = params;
        this.result = result;
        this.isSuccess = isSuccess;
        this.out_webserviceName = out_webserviceName;
        this.out_webserviceUrl = out_webserviceUrl;
        this.out_result = out_result;
    }
    /**
     * 
     * @param object 日志信息
     * @param id ID
     * @param productCode 产品code
     * @param dataType 数据来源
     * @param forwardLevel 转发层次
     * @param params 参数
     * @param result 结果
     * @param isSuccess 是否成功
     */
    public SendProductLogTask(Object object,String id,String productCode,String dataType,String forwardLevel,String params,String result,String isSuccess) {
    	
    	this.object = object;
    	this.id = id;
    	this.productCode = productCode;
    	this.dataType = dataType;
    	this.forwardLevel = forwardLevel;
    	this.params = params;
    	this.result = result;
    	this.isSuccess = isSuccess;
    }

    
    
    
    
    public void sendProductLog() {
    	
        JSONObject jo=(JSONObject) object;
    	Log_product logProduct=new Log_product();
    	
    	logProduct.setId(id);
    	logProduct.setGroupId(jo.getString("groupId"));
    	logProduct.setUserId(jo.getString("userId"));
    	logProduct.setUserName(jo.getString("userName"));
    	logProduct.setUserType(jo.getString("userType"));
    	logProduct.setProductId(productCode);
    	logProduct.setDataType(dataType);
    	logProduct.setParentId(jo.getString("id"));
    	logProduct.setForwardLevel(forwardLevel);
    	logProduct.setParams(params);
    	logProduct.setResult(result);
    	logProduct.setIsSuccess(isSuccess);
    	
    	if("2".equals(dataType)){
    		logProduct.setOut_webserviceName(out_webserviceName);
    		logProduct.setOut_webserviceUrl(out_webserviceUrl);
    		logProduct.setParams(params);
    		logProduct.setOut_Result(out_result);
    		logProduct.setIsSuccess(isSuccess);
    	}
    	
    	LOGGER.info("---【SendProductLogTask】---产品转发日志-"+logProduct.toString());
    	
        CommonMessageSender messageSender = new CommonMessageSender("logService_Queue", logProduct);
        ThreadPool.submitTask(messageSender);
    }

    @Override
    public void run() {
    	sendProductLog();
    }

}
