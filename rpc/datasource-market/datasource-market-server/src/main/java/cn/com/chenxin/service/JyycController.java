package cn.com.chenxin.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.iface.datasourceMarkeThrift.Iface;
import cn.com.chenxin.model.JsQyzxJyyc;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;
import cn.com.chenxin.utils.SpringInit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 经营异常
 * 
 * @author lxl
 * @since 0.0.2-SNAPSHOT
 */

@Service
public class JyycController implements Iface{

    /**
     * logger
     */
    private static final Logger LOGGER = Logger.getLogger(JyycController.class);

    /**
     * 查询本地经营异常的接口
     * 
     * @param params
     *            {"gshm":"xxx"}
     * @return JSONObject
     */
    public String zxbg_jyyc(LogInfo logInfo, String params) {
        JyycService jyycservice = (JyycService)SpringInit.getApplicationContext().getBean("jyycService");
        LOGGER.info("查询经营异常传入的值：" + params);
        
        JSONObject jsonObj = JSONObject.parseObject(params);
    //    JyycService jyycservice = (JyycService) SpringInit.getApplicationContext().getBean("jyycService");
        // 调用查询经营异常的方法
        // Sender sender=new Sender();
        // sender.addcLog_yc(params);
        String gshm = jsonObj.getString("gshm");
        List<JsQyzxJyyc> list = jyycservice.queryjyyc(gshm);
        
        /*
         * if(list.size()==0){ params.put("ZfStatus", "2");
         * params.put("zfResult", "2#101");
         * 
         * }else{ params.put("ZfStatus", "1"); params.put("zfResult", "1#101");
         * } sender.updateCLog_yc(params);
         */
        UUID uuid = UUID.randomUUID();
        String logId = uuid.toString();
        String isSuccess = "1";
        if(list.size() < 1) {
            isSuccess = "0";
        }
        String productcode = System.getProperty("datasource-market");
        String result = "";
        if(list.size() > 0) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(list);
            result = jsonArray.toString();
        }
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(logInfo), logId, productcode, "1", "1.1", params, result, isSuccess);
        ThreadPool.submitTask(sendProductLogTask);
        return result;
    }
    

}
