package cn.com.chenxin.service.hmd;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.chenxin.dao.JsHmdGrsxTmpMapper;
import cn.com.chenxin.dao.JsHmdGrsxXTmpMapper;
import cn.com.chenxin.dao.JsHmdWdxMapper;
import cn.com.chenxin.model.JsHmdGrsxTmp;
import cn.com.chenxin.model.JsHmdGrsxXTmp;
import cn.com.chenxin.model.JsHmdWdx;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 
 * @author jiangqi
 *
 * @since 0.0.1-SNAPSHOT
 */
@Service
public class HmdCxServiceByNameAndCode {
    /**
     * Logger for this class
     */
     private static final Logger LOGGER = Logger.getLogger(HmdCxServiceByNameAndCode.class);

    /**
     * 
     */
    @Autowired
    private JsHmdGrsxTmpMapper grsxMapper;
    /**
     * 
     */
    @Autowired
    private JsHmdGrsxXTmpMapper grxXMapper;
    /**
     * 
     */
    @Autowired
    private JsHmdWdxMapper wdMapper;

    /**
     * 
     * @param xm
     *            姓名
     * @param gmsfhm
     *            公民身份号码
     * @return 查询数据集市结果
     */
    public String findHmd(String xm, String gmsfhm) {
        JsHmdGrsxTmp queryGrsx = this.grsxMapper.hmdCxService4queryGrsx(xm, gmsfhm);
         LOGGER.info("hmdCxService1queryGrsx  Result:" + queryGrsx);
        JsHmdGrsxXTmp queryGrsxX = this.grxXMapper.hmdCxService4queryGrsxX(xm, gmsfhm);
         LOGGER.info("hmdCxService1queryGrsxX Result:" + queryGrsxX);
        JsHmdWdx queryWd = this.wdMapper.hmdCxService4queryWd(xm, gmsfhm);
         LOGGER.info("hmdCxService1queryWd Result:" + queryWd);
        JSONObject resObj = new JSONObject();
        JSONArray arrObj = new JSONArray();
        JSONObject dataObj = new JSONObject();
        if (null != queryGrsx) {
            resObj.put("resultCode", "1");
            arrObj.add("A101");
            resObj.put("reasonCode", arrObj);
            dataObj.put("gmsfhm", queryGrsx.getGmsfhm());//身份证号
            dataObj.put("sjhm", "");//手机号码
            dataObj.put("lendCity", "");//借款城市
            dataObj.put("lendDate", null);//借款日期
            dataObj.put("lendMoney", null);//借款金额
            dataObj.put("province", queryGrsx.getSf());//省份
            dataObj.put("filingTime", queryGrsx.getLarq());//立案时间
            dataObj.put("executionTime", queryGrsx.getFbrq());//执行时间
            dataObj.put("executionCourt", queryGrsx.getZxfy());//执行法院
            dataObj.put("executionNumber", queryGrsx.getZxwh());//执行文号
            dataObj.put("caseNo", queryGrsx.getAh());//案号
            dataObj.put("performanceStatus", queryGrsx.getLxqk());//履行情况
            dataObj.put("hasPerformanceStatus", queryGrsx.getYlx());//已履行情况
            dataObj.put("failurePerform", queryGrsx.getWlx());//未履行情况
            dataObj.put("specificCircumstances", queryGrsx.getJtqk());//具体情况
            dataObj.put("riskType", "");//风险类别
            dataObj.put("overdueDays", "");//逾期天数
            dataObj.put("overdueAmount", "");//逾期金额
            dataObj.put("overdueTime", "");//逾期日期
            dataObj.put("badType", "");//不良类型
            dataObj.put("caseTime", "");//案发时间
            resObj.put("data", dataObj);
            return resObj.toString();
        }
        if (null != queryGrsxX) {
            resObj.put("resultCode", "1");
            arrObj.add("A101");
            resObj.put("reasonCode", arrObj);
            dataObj.put("gmsfhm", queryGrsxX.getGmsfhm());//身份证号
            dataObj.put("sjhm", "");//手机号码
            dataObj.put("lendCity", "");//借款城市
            dataObj.put("lendDate", null);//借款日期
            dataObj.put("lendMoney", null);//借款金额
            dataObj.put("province", queryGrsxX.getSf());//省份
            dataObj.put("filingTime", queryGrsxX.getLarq());//立案时间
            dataObj.put("executionTime", queryGrsxX.getFbrq());//执行时间
            dataObj.put("executionCourt", queryGrsxX.getZxfy());//执行法院
            dataObj.put("executionNumber", queryGrsxX.getZxwh());//执行文号
            dataObj.put("caseNo", queryGrsxX.getAh());//案号
            dataObj.put("performanceStatus", queryGrsxX.getLxqk());//履行情况
            dataObj.put("hasPerformanceStatus", queryGrsxX.getYlx());//已履行情况
            dataObj.put("failurePerform", queryGrsxX.getWlx());//未履行情况
            dataObj.put("specificCircumstances", queryGrsxX.getJtqk());//具体情况
            dataObj.put("riskType", "");//风险类别
            dataObj.put("overdueDays", "");//逾期天数
            dataObj.put("overdueAmount", "");//逾期金额
            dataObj.put("overdueTime", "");//逾期日期
            dataObj.put("badType", "");//不良类型
            dataObj.put("caseTime", "");//案发时间
            resObj.put("data", dataObj);
            return resObj.toString();
        }
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
