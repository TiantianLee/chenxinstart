/**    
* @author    
* @date 2016年4月26日 上午11:35:08 
* @version V1.0   
*/
package cn.com.chenxin.service.fullInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.chenxin.model.DicAirportIp;
import cn.com.chenxin.model.JsAirportdata;
import cn.com.chenxin.model.JsXxjk;
import cn.com.chenxin.utils.DES_Encrypt;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author  
 *
 * @since 
 */
@Service
public class FullInfoAService {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(FullInfoAService.class);
    
    @Autowired
    private XxjkService xxjkService;
    
    private String key = "xxxx";
    
    /**
     * 根据条件查询全量信息
     * @param userCode      用户Code
     * @param userName      用户名
     * @param logId         日志Id
     * @param xm            姓名
     * @param sjhm          手机号码
     * @param gmsfzh        身份证号
     */
    public JSONObject getFullInfoAByCondition(String userCode,String xm,String sjhm,String gmsfzh){
        LOGGER.info("客户调用查询数据补全服务：usercode="+userCode);
        List<JsXxjk> xxjkList = this.xxjkService.getXxjkInfoByCondition(sjhm, gmsfzh);
        
        JSONObject resObj = new JSONObject();
        JSONArray arrObj = new JSONArray();
        arrObj.add("");
        resObj.put("reasonCode", arrObj);
        JSONObject dataObj = new JSONObject();
        dataObj.put("xm", translateCodeToUser(xm, userCode));
        dataObj.put("sjhm", translateCodeToUser(sjhm, userCode));
        dataObj.put("gmsfzh", translateCodeToUser(gmsfzh, userCode));
        if(xxjkList.isEmpty()){
            resObj.put("resultCode", "0");
        }else{
            resObj.put("resultCode", "3");
            //地址信息
            JSONArray addressArr = new JSONArray();
            //电话信息
            JSONArray TelephoneArr = new JSONArray();
            //关系人电话
            JSONArray TelephoneArr1 = new JSONArray();
            //邮箱
            JSONArray MArr = new JSONArray();
            //虚拟身份
            JSONArray VArr = new JSONArray();
            //资产信息
            JSONArray PArr = new JSONArray();
            //企业信息
            JSONArray EArr = new JSONArray();
            
            for (JsXxjk jsXxjk : xxjkList) {
                String dz = jsXxjk.getDz();
                String email = jsXxjk.getEmail();
                String qymc = jsXxjk.getQymc();
                String qq = jsXxjk.getQq();
                String zc = jsXxjk.getZc();
                String telephone = jsXxjk.getSjhm();
                //添加地址信息
                if(StringUtils.isNoneBlank(dz)){
                    String security_user = translateCodeToUserBySource(dz, userCode);
                    if(!addressArr.contains(security_user)){
                        addressArr.add(security_user);
                    }
                }
                //添加邮箱信息
                if(StringUtils.isNoneBlank(email)){
                    String security_user = translateCodeToUserBySource(email, userCode);
                    if(!MArr.contains(security_user)){
                        MArr.add(security_user);
                    }
                }
                //添加企业信息信息
                if(StringUtils.isNoneBlank(qymc)){
                    String security_user = translateCodeToUserBySource(qymc, userCode);
                    if(!EArr.contains(security_user)){
                        EArr.add(security_user);
                    }
                }
                //添加虚拟信息
                if(StringUtils.isNoneBlank(qq)){
                    String security_user = translateCodeToUserBySource(qq, userCode);
                    if(!VArr.contains(security_user)){
                        VArr.add(security_user);
                    }
                }
//                //添加虚拟信息
//                if(StringUtils.isNoneBlank(zc)){
//                    String security_user = translateCodeToUserBySource(zc, userCode);
//                    if(!PArr.contains(security_user)){
//                        PArr.add(security_user);
//                    }
//                }
                //添加手机号码
                if(StringUtils.isNoneBlank(telephone)){
                    String security_user = translateCodeToUser(telephone, userCode);
                    if(!TelephoneArr.contains(security_user) && !telephone.equals(sjhm)){
                        TelephoneArr.add(security_user);
                    }
                }
            }
            
            dataObj.put("A", addressArr);
            dataObj.put("T", TelephoneArr);
            dataObj.put("T1", TelephoneArr1);
            dataObj.put("M", MArr);
            dataObj.put("V", VArr);
//            dataObj.put("P", PArr);
            dataObj.put("E", EArr);
            
        }
        resObj.put("data", dataObj);
        return resObj;
    }
    
    /**
     * 客户调用查询机场数据补全服务
     * @param khId
     * @param userCode
     * @param khName
     * @param logId
     * @param sjhm
     * @param gmsfzh
     * @return
     */
    public JSONObject getFullInfoByAirPort(String userCode,String sjhm,String gmsfzh) {
        LOGGER.info("客户调用查询机场数据补全服务：usercode="+userCode);
        List<JsAirportdata> sjList = xxjkService.getMacByPhone(sjhm);
        List<JsAirportdata> idList = xxjkService.getMacByIdCard(gmsfzh);
        
        JSONObject resObj = new JSONObject();
        JSONArray arrObj = new JSONArray();
        arrObj.add("");
        resObj.put("reasonCode", arrObj);
        JSONObject dataObj = new JSONObject();
        dataObj.put("sjhm", translateCodeToUser(sjhm, userCode));
        dataObj.put("gmsfzh", translateCodeToUser(gmsfzh, userCode));
        if(sjList.isEmpty() && idList.isEmpty()) {
            resObj.put("resultCode", "0");
        } else {
            resObj.put("resultCode", "3");
            JSONArray phoneArr = new JSONArray();
            JSONArray addressArr = new JSONArray();
            List<Object> macList = new ArrayList<Object>();
            //手机号查mac
            if(!sjList.isEmpty()) {
                for(JsAirportdata jsAirportdata : sjList) {
                    macList.add(jsAirportdata.getMac());
                }
            }
            //身份号码查mac
            if(!idList.isEmpty()) {
                for(JsAirportdata jsAirportdata : idList) {
                    macList.add(jsAirportdata.getMac());
                }
            }
            //通过mac集合查手机号
            List<JsAirportdata> dataList = xxjkService.getPhoneByMac(macList);
            List<Object> ipList = new ArrayList<Object>();
            if(!dataList.isEmpty()) {
                List<String> tempList = new ArrayList<String>();
                for(JsAirportdata jsAirportdata : dataList) {
                    String phone = jsAirportdata.getIdnum();
                    tempList.add(phone);
                    String ip = jsAirportdata.getRemoteip();
                    ipList.add(ip);
                }
                List<String> phoneList = new ArrayList<String>();
                for(String str : tempList) {
                    if(!tempList.contains(str)) {
                        phoneList.add(str);
                    }
                }
                for(int i=0;i<phoneList.size();i++) {
                    String phone = phoneList.get(i);
                    if(!sjhm.equals(phone)) {
                      phoneArr.add(translateCodeToUserBySource(phone, userCode));
                  }
                }
            }
            //通过ip集合查地址
            if(!ipList.isEmpty()) {
                //通过ip查地址
                List<DicAirportIp> addressList = xxjkService.getAddressByIp(ipList);
                if(!addressList.isEmpty()) {
                    for(DicAirportIp dicAirportIp : addressList) {
                        String portName = dicAirportIp.getPortName();
                        addressArr.add(translateCodeToUserBySource(portName, userCode));
                    }
                }
            }
            dataObj.put("NT", phoneArr);
            dataObj.put("NA", addressArr);
        }
        resObj.put("data", dataObj);
        return resObj;
    }
    
    /**
     * 加密映射，将数据用用户信息加密
     * @param source          源数据
     * @param userCode        用户Code
     * @return
     */
    public String translateCodeToUserBySource(String source,String userCode){
        try {
            if(userCode.length()>8){
                return DES_Encrypt.encrypt(source, userCode);
            }else{
                for (int i = 0; i < 8; i++) {
                    userCode += userCode;
                }
                userCode = userCode.substring(0, 8);
                return DES_Encrypt.encrypt(source, userCode);
            }
        } catch (IOException e) {
        } catch (Exception e) {
        }
        return "";
    }
    
    /**
     * 加密映射，将数据库加密数据转换为用户加密数据
     * @param data          源加密数据
     * @param userCode      用户Code
     * @return
     */
    public String translateCodeToUser(String data,String userCode){
        try {
            String source = DES_Encrypt.decrypt(data, key);
            if(userCode.length()>8){
                return DES_Encrypt.encrypt(source, userCode);
            }else{
                for (int i = 0; i < 8; i++) {
                    userCode += userCode;
                }
                userCode = userCode.substring(0, 8);
                return DES_Encrypt.encrypt(source, userCode);
            }
        } catch (IOException e) {
        } catch (Exception e) {
        }
        return "";
    }
    
    /**
     * 加密映射，将用户加密数据转换为数据库加密数据
     * @param data          源加密数据
     * @param userCode      用户Code
     * @return
     */
    public String translateCodeToDb(String data,String userCode){
        try {
            String source;
            if(userCode.length()>8){
                source = DES_Encrypt.decrypt(data, userCode);
            }else{
                for (int i = 0; i < 8; i++) {
                    userCode += userCode;
                }
                userCode = userCode.substring(0, 8);
                source = DES_Encrypt.decrypt(data, userCode);
            }
            
            return DES_Encrypt.encrypt(source, key);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    
    public static void main(String[] args) throws IOException, Exception {
        System.out.println(DES_Encrypt.decrypt("bYtr44j3aI9xQmxTQx+NxA==", "xxxx"));
    }
}
