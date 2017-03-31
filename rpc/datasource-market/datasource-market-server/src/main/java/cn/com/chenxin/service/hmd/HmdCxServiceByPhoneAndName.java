package cn.com.chenxin.service.hmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.chenxin.dao.JsHmdWdxMapper;
import cn.com.chenxin.model.JsHmdWdx;

/**
 * 
 * 
 * @author jiangqi
 *
 * @since 0.0.1-SNAPSHOT
 */
@Service
public class HmdCxServiceByPhoneAndName {
    /**
     * Logger for this class
     */
 //   private static final Logger LOGGER = Logger.getLogger(HmdCxServiceImpl.class);
    
    /**
     * 
     */
    @Autowired
    private JsHmdWdxMapper wdMapper;

    /**
     * 
     * @param xm 姓名
     * @param sjhm 手机号码
     * @return 查询数据集市结果
     */
    public String findHmd(String xm, String sjhm) {
        // Integer queryGrsx = this.grsxMapper.queryGrsx(xm);
        // logger.info("queryGrsxf  Result:"+queryGrsx);
        // Integer queryGrsxX = this.grxXMapper.queryGrsxX(xm);
        // logger.info("queryGrsxX Result:"+queryGrsxX);
        JsHmdWdx queryWd = this.wdMapper.queryWd(xm, sjhm);
        JSONObject resObj = new JSONObject();
        JSONArray arrObj = new JSONArray();
        JSONObject dataObj = new JSONObject();
   //     LOGGER.info("queryWd Result:" + queryWd);
        if (null != queryWd) {
            resObj.put("resultCode", "1");
            arrObj.add("A102");
            resObj.put("reasonCode", arrObj);
            dataObj.put("gmsfhm", queryWd.getGmsfhm());//身份证号
            dataObj.put("sjhm", queryWd.getSjhm());//手机号码
            dataObj.put("lendCity", queryWd.getJkcs());//借款城市
            dataObj.put("lendDate", queryWd.getJkrq());//借款日期
            dataObj.put("lendMoney", queryWd.getJkje());//借款金额
            dataObj.put("province", "");//省份
            dataObj.put("filingTime", null);//立案时间
            dataObj.put("executionTime", null);//执行时间
            dataObj.put("executionCourt", "");//执行法院
            dataObj.put("executionNumber", "");//执行文号
            dataObj.put("caseNo", "");//案号
            dataObj.put("performanceStatus", "");//履行情况
            dataObj.put("hasPerformanceStatus", "");//已履行情况
            dataObj.put("failurePerform", "");//未履行情况
            dataObj.put("specificCircumstances", "");//具体情况
            dataObj.put("riskType", "");//风险类别
            dataObj.put("overdueDays", "");//逾期天数
            dataObj.put("overdueAmount", "");//逾期金额
            dataObj.put("overdueTime", "");//逾期日期
            dataObj.put("badType", "");//不良类型
            dataObj.put("caseTime", "");//案发时间
            resObj.put("data", dataObj);
            return resObj.toString();
        }
        resObj.put("resultCode", "2");
        arrObj.add("");
        resObj.put("reasonCode", arrObj);
        dataObj.put("gmsfhm", "");//身份证号
        dataObj.put("sjhm", "");//手机号码
        dataObj.put("lendCity", "");//借款城市
        dataObj.put("lendDate", null);//借款日期
        dataObj.put("lendMoney", null);//借款金额
        dataObj.put("province", "");//省份
        dataObj.put("filingTime", null);//立案时间
        dataObj.put("executionTime", null);//执行时间
        dataObj.put("executionCourt", "");//执行法院
        dataObj.put("executionNumber", "");//执行文号
        dataObj.put("caseNo", "");//案号
        dataObj.put("performanceStatus", "");//履行情况
        dataObj.put("hasPerformanceStatus", "");//已履行情况
        dataObj.put("failurePerform", "");//未履行情况
        dataObj.put("specificCircumstances", "");//具体情况
        dataObj.put("riskType", "");//风险类别
        dataObj.put("overdueDays", "");//逾期天数
        dataObj.put("overdueAmount", "");//逾期金额
        dataObj.put("overdueTime", "");//逾期日期
        dataObj.put("badType", "");//不良类型
        dataObj.put("caseTime", "");//案发时间
        resObj.put("data", dataObj);
        return resObj.toString();
    }
}
