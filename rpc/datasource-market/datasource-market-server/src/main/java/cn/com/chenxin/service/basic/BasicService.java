/**   
*  版权所有
* @Title: BasicService.java 
* @Package cn.com.chenxin.service.basic 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wangzhirui  
* @date 2016年7月13日 上午10:50:15 
* @version V1.0   
*/

package cn.com.chenxin.service.basic;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.thrift.TException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.com.chenxin.dao.JsJdcGrtjMapper;
import cn.com.chenxin.dao.WgGrEnyMapper;
import cn.com.chenxin.iface.DatasourceMarketBasicThrift.Iface;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.model.WgGrEny;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;
import cn.com.chenxin.utils.DES_Encrypt;
import cn.com.chenxin.utils.EnySha;
import cn.com.chenxin.utils.SpringInit;

/**
 * 
 * @author wangzhirui
 *
 * @since 
 */
public class BasicService implements Iface {
    private static final Logger LOGGER = Logger.getLogger(BasicService.class);
    /* (non-Javadoc)
     * @see cn.com.chenxin.iface.DatasourceMarketBasicThrift.Iface#findBasicByNameAndCode(cn.com.chenxin.iface.LogInfo, java.lang.String)
     */
    private String key = "xxxx";
    private String isSuccess = "1";
    @Override
    /**
     * 根据条件查询个人信息
     * @param LogInfo  日志记录
     * @param params  查询参数
     */
    public String findBasicByNameAndCode(LogInfo LogInfo, String params) throws TException {
     // TODO Auto-generated method stub
        WgGrEnyMapper wgGrEnyMapper = (WgGrEnyMapper) SpringInit.getApplicationContext().getBean("wgGrEnyMapper");
        JSONObject json=JSONObject.parseObject(params);
        String xm="";
        String gmsfhm="";
        //返回结果
        JSONObject resulitJson=new JSONObject();
        //对查询条件进行加密
        try {
            xm=EnySha.gcode(json.getString("xm"));
            gmsfhm=EnySha.gcode(json.getString("gmsfhm"));
            WgGrEny wgGreny= wgGrEnyMapper.findByXmGmsfhm(xm, gmsfhm);
            JSONObject data=new JSONObject();
            if(wgGreny!=null){
                data.put("csrq", DES_Encrypt.decrypt(wgGreny.getCsrq(), key) );
                data.put("dz",  DES_Encrypt.decrypt(wgGreny.getDz(), key));
                data.put("hyzk",  DES_Encrypt.decrypt(wgGreny.getHyzk(), key));
                data.put("xb",  DES_Encrypt.decrypt(wgGreny.getXb(), key));
                resulitJson.put("data", data);
                resulitJson.put("resultCode", "3");
            }else{
                resulitJson.put("data", data);
                resulitJson.put("resultCode", "0");
            }
        } catch (Exception e) {
            isSuccess = "-1";
            e.printStackTrace();
        }
     // 添加日志
        String id = UUID.randomUUID().toString();
        String productcode = System.getProperty("jbxx");
        // 结果 来源
        String datasource = "1";
        SendProductLogTask sendProductLogTask = new SendProductLogTask(
                JSON.toJSON(LogInfo), id, productcode, datasource, "1",
                params.toString(), resulitJson.toString(), isSuccess);
        ThreadPool.submitTask(sendProductLogTask);
        
        //处理查询结果
        return resulitJson.toString();
    }

}
