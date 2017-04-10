package cn.com.chenxin.test.sjzwsc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import com.alibaba.fastjson.JSONObject;
public class SjzwscTestBatch {

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
        }
        return serviceClient;
    }

    public static void main(String[] args) {
        String url = "http://xxxx/services/xxxxService?wsdl ";
        String targertNameSpace = "http://xxxx.xxxServiceImpl";
        RPCServiceClient serviceClient = getRpcClient(url);
        String userCode = "xxxx"; 
        String passWord = "xxxxx"; 

        try {
            System.setOut(new PrintStream(new File("D:/result1.txt")));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        JSONObject json = new JSONObject();
        json.put("userCode", userCode);
        json.put("passWord", passWord);
        
        Map<String,String> map = new HashMap<String, String>();
        map.put("7","13405914534");
        map.put("27","13599494145");
        map.put("80","15160008265");
        map.put("86","15259117232");
        map.put("87","15259904126");
        map.put("114","18359820820");
        map.put("10","13512636141");
        map.put("49","13766791373");
        map.put("67","13936791556");
        map.put("105","18245345021");
        map.put("106","18246148437");
        map.put("120","18745400911");
        map.put("15","13654007690");
        map.put("92","15841983777");
        map.put("103","15998224891");
        map.put("5","13561254458");
        map.put("13","13553023151");
        map.put("64","15053752315");
        map.put("72","15169236345");
        map.put("77","15098761900");
        map.put("79","15244405982");
        map.put("91","15963335273");
        map.put("8","13503525873");
        map.put("21","13703569687");
        map.put("24","13734057778");
        map.put("25","13633463515");
        map.put("29","13643462850");
        map.put("94","15935445656");
        map.put("95","15935768358");
        map.put("104","18306849777");
        map.put("116","18734723578");
        map.put("20","13619155525");
        map.put("108","18392186485");

        
        
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String phone = map.get(key);

            try {
                // String sjhm = "1308425xxxx";//手机号码
                json.put("sjhm", phone);
                String jsonStr = json.toString();
                // 【同步调用】代码调用样例(请按实际业务应用场景选择)
                String result = serviceClient.invokeBlocking(new QName(targertNameSpace, "findPhone"), new Object[] { jsonStr },
                        new Class[] { String.class })[0].toString();
                System.out.println("No："+key+" "+phone + "@" + result);
            } catch (Exception e) {
                System.out.println("No："+key+" "+phone + "@未查到");
            }
        }

        try {
            serviceClient.cleanupTransport();
        } catch (AxisFault e) {
            e.printStackTrace();
        }

    }

}
