package cn.com.chenxin.test.fullInfo;

import javax.xml.namespace.QName;



import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import com.alibaba.fastjson.JSONObject;

public class FullInfoTestBatch {
    public static RPCServiceClient getRpcClient(String url) {
        RPCServiceClient serviceClient = null;
        try {
            serviceClient = new RPCServiceClient();
            Options options = serviceClient.getOptions();
            EndpointReference targetEPR = new EndpointReference(url);
            options.setTo(targetEPR);
            options.setManageSession(true);
            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serviceClient;
    }

    public static void main(String[] args) throws Exception {
//        System.clearProperty("javax.net.ssl.trustStore");
//        System.clearProperty("javax.net.ssl.keyStoreType");
//        System.clearProperty("javax.net.ssl.keyStorePassword");
//        // 取文件所在位置
//        System.setProperty("javax.net.ssl.keyStore",
//                "C:/Users/jiangq/Desktop/248/Certificate/client.p12");
//        System.setProperty("javax.net.ssl.keyStorePassword", "chenxintest");
//        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
//        // 取文件所在位置
//        System.setProperty("javax.net.ssl.trustStore",
//                "C:/Users/jiangq/Desktop/248/Certificate/tomcat.keystore");
//        System.setProperty("javax.net.ssl.trustStorePassword", "chenxintest");
        
        long start = System.currentTimeMillis();
        
        //生产环境地址
        String url = "http://xxxx/xxxService?wsdl";
        

        String targertNameSpace = "http://xxxx.xxxxServiceImpl";
        RPCServiceClient serviceClient = FullInfoTestBatch.getRpcClient(url);
        String userCode = "xxxx";
        String passWord = "xxxx";
        // 接口中所需参数
        String xm = "xxxx";
//        String xm = "";
        String gmsfhm = "xxxx";
//        String gmsfhm = "";
        String sjhm = "xxxx";
        JSONObject json = new JSONObject();
        json.put("userCode", userCode);
        json.put("passWord", passWord);
        json.put("xm", xm);
        json.put("gmsfhm", gmsfhm);
        json.put("sjhm", sjhm);
        String jsonStr = json.toString();

        /**
         * 同步调用方法
         * */
        String result = "";
        try {
            // 引号中为接口的方法名
            result = serviceClient.invokeBlocking(new QName(targertNameSpace,
                    "findFullInfo"), new Object[] { jsonStr },
                    new Class[] { String.class })[0].toString();
            serviceClient.cleanupTransport();
        } catch (AxisFault e) {
            e.printStackTrace();
        }
        System.out.println("同步调用：" + result);
        System.out.println("共耗时"+(System.currentTimeMillis() - start)+" ms");
    }
}
