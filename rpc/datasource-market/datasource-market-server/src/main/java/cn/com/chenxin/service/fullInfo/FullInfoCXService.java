package cn.com.chenxin.service.fullInfo;

import java.util.UUID;

import org.apache.thrift.TException;

import cn.com.chenxin.iface.DatasourceMarketFullInfoThrift.Iface;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;
import cn.com.chenxin.utils.DES_Encrypt;
import cn.com.chenxin.utils.SpringInit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FullInfoCXService implements Iface {

    public String findFullInfo(LogInfo LogInfo, String params) {
        FullInfoService fullInfoService = (FullInfoService) SpringInit.getApplicationContext().getBean("fullInfoService");
        JSONObject paraObj = JSONObject.parseObject(params);
        String xm = paraObj.getString("xm");
        String sjhm = paraObj.getString("sjhm");
        String gmsfzh = paraObj.getString("gmsfhm");
        String userCode = paraObj.getString("userCode");
        String isSuccess = "1";
        if (userCode.length() < 8) {
            for (int i = 0; i < 8; i++) {
                userCode += userCode;
            }
            userCode = userCode.substring(0, 8);
        }
        try {
            xm = DES_Encrypt.encrypt(xm, userCode);
            sjhm = DES_Encrypt.encrypt(sjhm, userCode);
            gmsfzh = DES_Encrypt.encrypt(gmsfzh, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        xm = fullInfoService.translateCodeToDb(xm, userCode);
        sjhm = fullInfoService.translateCodeToDb(sjhm, userCode);
        gmsfzh = fullInfoService.translateCodeToDb(gmsfzh, userCode);
        JSONObject result = fullInfoService.getFullInfoByCondition(userCode, xm, sjhm, gmsfzh);

        // 添加日志
        String id = UUID.randomUUID().toString();
        String productcode = System.getProperty("fullInfo_getFullInfo");
        // 结果 来源
        String datasource = "1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
                result.toString(), isSuccess);
        ThreadPool.submitTask(sendProductLogTask);
        return result.toString();
    }

    public String findAirPortData(LogInfo LogInfo, String params) {
        FullInfoService fullInfoService = (FullInfoService) SpringInit.getApplicationContext().getBean("fullInfoService");
        JSONObject paraObj = JSONObject.parseObject(params);
        String sjhm = paraObj.getString("sjhm");
        String gmsfzh = paraObj.getString("gmsfhm");
        String userCode = paraObj.getString("userCode");
        String isSuccess = "1";
        if (userCode.length() < 8) {
            for (int i = 0; i < 8; i++) {
                userCode += userCode;
            }
            userCode = userCode.substring(0, 8);
        }
        try {
            sjhm = DES_Encrypt.encrypt(sjhm, userCode);
            gmsfzh = DES_Encrypt.encrypt(gmsfzh, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sjhm = fullInfoService.translateCodeToDb(sjhm, userCode);
        gmsfzh = fullInfoService.translateCodeToDb(gmsfzh, userCode);

        JSONObject result = fullInfoService.getFullInfoByAirPort(userCode, sjhm, gmsfzh);

        // 添加日志
        String id = UUID.randomUUID().toString();
        String productcode = System.getProperty("fullInfo_getAirPortData");
        // 结果 来源
        String datasource = "1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
                result.toString(), isSuccess);
        ThreadPool.submitTask(sendProductLogTask);
        return result.toString();
    }

    @Override
    public String findFullInfoA(LogInfo LogInfo, String params) throws TException {
        FullInfoAService fullInfoAService = (FullInfoAService) SpringInit.getApplicationContext().getBean("fullInfoAService");
        JSONObject paraObj = JSONObject.parseObject(params);
        String xm = paraObj.getString("xm");
        String sjhm = paraObj.getString("sjhm");
        String gmsfzh = paraObj.getString("gmsfhm");
        String userCode = paraObj.getString("userCode");
        String isSuccess = "1";
        if (userCode.length() < 8) {
            for (int i = 0; i < 8; i++) {
                userCode += userCode;
            }
            userCode = userCode.substring(0, 8);
        }
        try {
            xm = DES_Encrypt.encrypt(xm, userCode);
            sjhm = DES_Encrypt.encrypt(sjhm, userCode);
            gmsfzh = DES_Encrypt.encrypt(gmsfzh, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        xm = fullInfoAService.translateCodeToDb(xm, userCode);
        sjhm = fullInfoAService.translateCodeToDb(sjhm, userCode);
        gmsfzh = fullInfoAService.translateCodeToDb(gmsfzh, userCode);
        JSONObject result = fullInfoAService.getFullInfoAByCondition(userCode, xm, sjhm, gmsfzh);

        // 添加日志
        String id = UUID.randomUUID().toString();
        String productcode = System.getProperty("fullInfo_getFullInfoA");
        // 结果 来源
        String datasource = "1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
                result.toString(), isSuccess);
        ThreadPool.submitTask(sendProductLogTask);
        return result.toString();
    }
   
    public String findFullInfoC(LogInfo LogInfo, String params) throws TException {
    	FullInfoTBService fullInfoCService = (FullInfoTBService) SpringInit.getApplicationContext().getBean("fullInfoTBService");
        JSONObject paraObj = JSONObject.parseObject(params);
        String xm = paraObj.getString("xm");
        String sjhm = paraObj.getString("sjhm");
        String gmsfhm = paraObj.getString("gmsfhm");
        String userCode = paraObj.getString("userCode");
        String isSuccess = "1";
        if (userCode.length() < 8) {
            for (int i = 0; i < 8; i++) {
                userCode += userCode;
            }
            userCode = userCode.substring(0, 8);
        }
        try {
            xm = DES_Encrypt.encrypt(xm, userCode);
            sjhm = DES_Encrypt.encrypt(sjhm, userCode);
            gmsfhm = DES_Encrypt.encrypt(gmsfhm, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        xm = fullInfoCService.translateCodeToDb(xm, userCode);
        sjhm = fullInfoCService.translateCodeToDb(sjhm, userCode);
        gmsfhm = fullInfoCService.translateCodeToDb(gmsfhm, userCode);
        JSONObject result = fullInfoCService.getFullInfoC(LogInfo, userCode, xm, sjhm, gmsfhm);

        // 添加日志
        String id = UUID.randomUUID().toString();
        String productcode = System.getProperty("fullInfo_getFullInfoC");
        // 结果 来源
        String datasource = "1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
                result.toString(), isSuccess);
        ThreadPool.submitTask(sendProductLogTask);
        return result.toString();
    }

    /* (non-Javadoc)
     * @see cn.com.chenxin.iface.DatasourceMarketFullInfoThrift.Iface#findFullInfoA2(cn.com.chenxin.iface.LogInfo, java.lang.String)
     */
    @Override
    public String findFullInfoA2(LogInfo LogInfo, String params) throws TException {
        FullInfoA2Service fullInfoAService = (FullInfoA2Service) SpringInit.getApplicationContext().getBean("fullInfoA2Service");
        JSONObject paraObj = JSONObject.parseObject(params);
        String xm = paraObj.getString("xm");
        String sjhm = paraObj.getString("sjhm");
        String gmsfzh = paraObj.getString("gmsfhm");
        String userCode = paraObj.getString("userCode");
        String isSuccess = "1";
        if (userCode.length() < 8) {
            for (int i = 0; i < 8; i++) {
                userCode += userCode;
            }
            userCode = userCode.substring(0, 8);
        }
        try {
            xm = DES_Encrypt.encrypt(xm, userCode);
            sjhm = DES_Encrypt.encrypt(sjhm, userCode);
            gmsfzh = DES_Encrypt.encrypt(gmsfzh, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        xm = fullInfoAService.translateCodeToDb(xm, userCode);
        sjhm = fullInfoAService.translateCodeToDb(sjhm, userCode);
        gmsfzh = fullInfoAService.translateCodeToDb(gmsfzh, userCode);
        JSONObject result = fullInfoAService.getFullInfoA2ByCondition(userCode, xm, sjhm, gmsfzh);

        // 添加日志
        String id = UUID.randomUUID().toString();
        String productcode = System.getProperty("fullInfo_getFullInfoA2");
        // 结果 来源
        String datasource = "1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
                result.toString(), isSuccess);
        ThreadPool.submitTask(sendProductLogTask);
        return result.toString();
    }

}
