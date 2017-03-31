package cn.com.chenxin.service.hmd;

import java.util.UUID;

import cn.com.chenxin.iface.DatasourceMarketHmdThrift.Iface;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;
import cn.com.chenxin.utils.SpringInit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HmdCxService implements Iface {

    /*
     * 根具姓名和身份证号码查找黑名单接口信息
     */
    @Override
    public String findHmdByNameAndCode(LogInfo LogInfo, String params) {
        HmdCxServiceByNameAndCode hmdCxServiceByNameAndCode = (HmdCxServiceByNameAndCode) SpringInit.getApplicationContext().getBean(
                "hmdCxServiceByNameAndCode");
        JSONObject jsonParams = JSONObject.parseObject(params);
        String xm = jsonParams.getString("xm");
        String gmsfhm = jsonParams.getString("gmsfhm");
        JSONObject resObj = new JSONObject();
        String isSuccess = "1";
        String str = "";
        try {
            str = hmdCxServiceByNameAndCode.findHmd(xm, gmsfhm);
            resObj = JSONObject.parseObject(str);
        } catch (Exception e) {
            JSONArray arrObj = new JSONArray();
            JSONObject dataObj = new JSONObject();
            resObj.put("resultCode", "-1");
            arrObj.add("");
            resObj.put("reasonCode", arrObj);
            dataObj.put("gmsfhm", "");//身份证号
            dataObj.put("sjhm", "");//手机号码
            dataObj.put("lendCity", "");// 借款城市
            dataObj.put("lendDate", null);// 借款日期
            dataObj.put("lendMoney", null);// 借款金额
            dataObj.put("province", "");// 省份
            dataObj.put("filingTime", null);// 立案时间
            dataObj.put("executionTime", null);// 执行时间
            dataObj.put("executionCourt", "");// 执行法院
            dataObj.put("executionNumber", "");// 执行文号
            dataObj.put("caseNo", "");// 案号
            dataObj.put("performanceStatus", "");// 履行情况
            dataObj.put("hasPerformanceStatus", "");// 已履行情况
            dataObj.put("failurePerform", "");// 未履行情况
            dataObj.put("specificCircumstances", "");// 具体情况
            dataObj.put("badType", "");// 不良类型
            dataObj.put("caseTime", "");// 案发时间
            dataObj.put("riskType", "");// 风险类别
            dataObj.put("overdueDays", "");// 逾期天数
            dataObj.put("overdueAmount", "");// 逾期金额
            dataObj.put("overdueTime", "");// 逾期日期
            resObj.put("data", dataObj);
            str = resObj.toString();
            e.printStackTrace();
        }
        // 添加日志
        String id = UUID.randomUUID().toString();
        String productcode = System.getProperty("hmd_namecode");
        // 结果 来源
        String datasource = "1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
                resObj.toString(), isSuccess);
        ThreadPool.submitTask(sendProductLogTask);

        return str;
    }

    /*
     * 根具电话和姓名查找黑名单接口信息
     */
    @Override
    public String findHmdByNameAndPhone(LogInfo LogInfo, String params) {
        // hmdCxServiceByNameAndCode
        HmdCxServiceByPhoneAndName hmdCxServiceByPhoneAndName = (HmdCxServiceByPhoneAndName) SpringInit.getApplicationContext().getBean(
                "hmdCxServiceByPhoneAndName");
        JSONObject jsonParams = JSONObject.parseObject(params);
        String sjhm = jsonParams.getString("sjhm");
        String xm = jsonParams.getString("xm");
        // HmdCxServiceByPhoneAndName pn = new HmdCxServiceByPhoneAndName();
        JSONObject resObj = new JSONObject();
        String isSuccess = "1";
        String str = "";
        try {
            str = hmdCxServiceByPhoneAndName.findHmd(xm, sjhm);
            resObj = JSONObject.parseObject(str);
        } catch (Exception e) {
            JSONArray arrObj = new JSONArray();
            JSONObject dataObj = new JSONObject();
            resObj.put("resultCode", "-1");
            arrObj.add("");
            dataObj.put("gmsfhm", "");//身份证号
            dataObj.put("sjhm", "");//手机号码
            dataObj.put("lendCity", "");// 借款城市
            dataObj.put("lendDate", null);// 借款日期
            dataObj.put("lendMoney", null);// 借款金额
            dataObj.put("province", "");// 省份
            dataObj.put("filingTime", null);// 立案时间
            dataObj.put("executionTime", null);// 执行时间
            dataObj.put("executionCourt", "");// 执行法院
            dataObj.put("executionNumber", "");// 执行文号
            dataObj.put("caseNo", "");// 案号
            dataObj.put("performanceStatus", "");// 履行情况
            dataObj.put("hasPerformanceStatus", "");// 已履行情况
            dataObj.put("failurePerform", "");// 未履行情况
            dataObj.put("specificCircumstances", "");// 具体情况
            dataObj.put("badType", "");// 不良类型
            dataObj.put("caseTime", "");// 案发时间
            dataObj.put("riskType", "");// 风险类别
            dataObj.put("overdueDays", "");// 逾期天数
            dataObj.put("overdueAmount", "");// 逾期金额
            dataObj.put("overdueTime", "");// 逾期日期
            resObj.put("data", dataObj);
            str = resObj.toString();
            e.printStackTrace();
        }

        // 添加日志
        String id = UUID.randomUUID().toString();
        String productcode = System.getProperty("hmd_namephone");
        // 结果 来源
        String datasource = "1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
                resObj.toString(), isSuccess);
        ThreadPool.submitTask(sendProductLogTask);

        return str;
    }

    /*
     * 根据姓名和身份证号码查找DH失信、网贷(现在没有数据，接口为空)(non-Javadoc)
     */
    @Override
    public String findDhHmdByNameAndCode(LogInfo LogInfo, String params) {
        JSONObject resObj = new JSONObject();
        JSONObject dataObj = new JSONObject();
        JSONArray arr = new JSONArray();
        resObj.put("resultCode", "-1");
        arr.add("");
        resObj.put("reasonCode", arr);
        dataObj.put("riskType", "");
        dataObj.put("overdueDays", "");
        dataObj.put("overdueAmount", "");
        dataObj.put("overdueTime", "");
        return resObj.toString();
    }

    /*
     * 根据姓名和手机号码查找DH网贷(现在没有数据，接口为空)(non-Javadoc)
     */
    @Override
    public String findDhHmdByNameAndPhone(LogInfo LogInfo, String params) {
        JSONObject resObj = new JSONObject();
        JSONObject dataObj = new JSONObject();
        JSONArray arr = new JSONArray();
        resObj.put("resultCode", "-1");
        arr.add("");
        resObj.put("reasonCode", arr);
        dataObj.put("riskType", "");
        dataObj.put("overdueDays", "");
        dataObj.put("overdueAmount", "");
        dataObj.put("overdueTime", "");
        return resObj.toString();
    }

}
