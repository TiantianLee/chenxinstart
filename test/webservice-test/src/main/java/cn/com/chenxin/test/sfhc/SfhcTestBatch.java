package cn.com.chenxin.test.sfhc;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import com.alibaba.fastjson.JSONObject;
public class SfhcTestBatch {
    
    
    public static RPCServiceClient getRpcClient(String url)
    {
        RPCServiceClient serviceClient = null;
        try
        {
            serviceClient = new RPCServiceClient();
            Options options = serviceClient.getOptions();
            EndpointReference targetEPR = new EndpointReference(url);
            options.setTo(targetEPR);
            options.setManageSession(true);   
            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT,true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return serviceClient;
    }

    
    
    public static void main(String[] args) throws AxisFault {
        String url = "http://localhost:8081/xxxx/services/xxxxService?wsdl";
        String targertNameSpace = "http://com.innofi.module.fw.service.impl.FwServiceImpl";
        RPCServiceClient serviceClient = getRpcClient(url);
        String userCode = "xxxx"; 
        String passWord = "xxxx"; 
        
        /**
         * 举例 
         * */
        String xm = "王某某";//姓名
        String gmsfhm = "110xxxxxxxxxxxxxxx";//公民身份号码
        String sjhm = "138xxxxxxxx";//手机号码
        String yhk = "xxxxxxxxxxxxxxxx";//银行卡号
        JSONObject json = new JSONObject();
        json.put("userCode", userCode);
        json.put("passWord", passWord);
        json.put("xm", xm);
        json.put("gmsfhm", gmsfhm);
        json.put("sjhm", sjhm);
        json.put("yhk", yhk);
        String jsonStr = json.toString();
        //【同步调用】代码调用样例(请按实际业务应用场景选择)
        String result = serviceClient.invokeBlocking(new QName(targertNameSpace,"findSfhc"), new Object[] { jsonStr }, new Class[] {String.class })[0].toString();
        serviceClient.cleanupTransport();

    }

}
