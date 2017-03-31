/**    
* @author tiantian 
* @date 2016年3月23日 上午11:01:54 
* @version V1.0   
*/
package cn.com.chenxin.account;

import org.apache.log4j.Logger;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import cn.com.chenxin.cache.ClientCache;
import cn.com.chenxin.caf.exception.CafException;
import cn.com.chenxin.iface.DatasourceMarketBasicThrift;
import cn.com.chenxin.iface.DatasourceMarketCarThrift;
import cn.com.chenxin.iface.DatasourceMarketFoodThrift;
import cn.com.chenxin.iface.DatasourceMarketFullInfoThrift;
import cn.com.chenxin.iface.DatasourceMarketGreyThrift;
import cn.com.chenxin.iface.DatasourceMarketGsThrift;
import cn.com.chenxin.iface.DatasourceMarketHmdThrift;
import cn.com.chenxin.iface.DatasourceMarketJtBankThrift;
import cn.com.chenxin.iface.DatasourceMarketSfhcThrift;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author tiantian
 *
 * @since 
 */
public class DatasourceMarketPlatformClient {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(DatasourceMarketPlatformClient.class);
    
    /**
     * 获取SDK
     * @return
     */
    public static DatasourceMarketHmdThrift.Client getSdk(){
        try {
            JSONObject host = ClientCache.getHostByService("market-server", "1.0.0");
            TTransport transport = new TSocket(host.getString("host"), host.getIntValue("port"), 20000);
            LOGGER.info("datasource-market-client  transport:"+host.getString("host")+"--"+host.getIntValue("port"));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"DatasourceMarketHmdThrift");
            DatasourceMarketHmdThrift.Client client = new DatasourceMarketHmdThrift.Client(mp1);
            transport.open();
            return client;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (CafException e) {
            e.printStackTrace();
        }
        return null;
    }
    
   /**
     * 获取SDK身份核查
     * @return
     */
    public static DatasourceMarketSfhcThrift.Client getSdkSfhc(){
        try {
            JSONObject host = ClientCache.getHostByService("market-server", "1.0.0");
            TTransport transport = new TSocket(host.getString("host"), host.getIntValue("port"), 20000);
            LOGGER.info("datasource-market-client  transport:"+host.getString("host")+"--"+host.getIntValue("port"));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"DatasourceMarketSfhcThrift");
            DatasourceMarketSfhcThrift.Client client = new DatasourceMarketSfhcThrift.Client(mp1);
            transport.open();
            return client;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (CafException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 获取SDK车辆
     * @return
     */
    public static DatasourceMarketCarThrift.Client getSdkCar(){
        try {
            JSONObject host = ClientCache.getHostByService("market-server", "1.0.0");
            TTransport transport = new TSocket(host.getString("host"), host.getIntValue("port"), 20000);
            LOGGER.info("datasource-market-client  transport:"+host.getString("host")+"--"+host.getIntValue("port"));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"DatasourceMarketCarThrift");
            DatasourceMarketCarThrift.Client client = new DatasourceMarketCarThrift.Client(mp1);
            transport.open();
            return client;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (CafException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 获取SDK灰名单
     * @return
     */
    public static DatasourceMarketGreyThrift.Client getSdkGrey(){
        try {
            JSONObject host = ClientCache.getHostByService("market-server", "1.0.0");
            TTransport transport = new TSocket(host.getString("host"), host.getIntValue("port"), 20000);
            LOGGER.info("datasource-market-client  transport:"+host.getString("host")+"--"+host.getIntValue("port"));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"DatasourceMarketGreyThrift");
            DatasourceMarketGreyThrift.Client client = new DatasourceMarketGreyThrift.Client(mp1);
            transport.open();
            return client;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (CafException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 获取SDK
     * @return
     */
    public static DatasourceMarketFullInfoThrift.Client getSdkFullInfo(){
        try {
            JSONObject host = ClientCache.getHostByService("market-server", "1.0.0");
            TTransport transport = new TSocket(host.getString("host"), host.getIntValue("port"), 20000);
            LOGGER.info("datasource-market-client  transport:"+host.getString("host")+"--"+host.getIntValue("port"));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"DatasourceMarketFullInfoThrift");
            DatasourceMarketFullInfoThrift.Client client = new DatasourceMarketFullInfoThrift.Client(mp1);
            transport.open();
            return client;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (CafException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取SDK
     * @return
     */
    public static DatasourceMarketBasicThrift.Client getSdkBasic(){
        try {
            JSONObject host = ClientCache.getHostByService("market-server", "1.0.0");
            TTransport transport = new TSocket(host.getString("host"), host.getIntValue("port"), 20000);
            LOGGER.info("datasource-market-client  transport:"+host.getString("host")+"--"+host.getIntValue("port"));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"DatasourceMarketBasicThrift");
            DatasourceMarketBasicThrift.Client client = new DatasourceMarketBasicThrift.Client(mp1);
            transport.open();
            return client;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (CafException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取SDK食品安全
     * @return
     */
    public static DatasourceMarketFoodThrift.Client getSdkFood(){
        try {
            JSONObject host = ClientCache.getHostByService("market-server", "1.0.0");
            TTransport transport = new TSocket(host.getString("host"), host.getIntValue("port"), 20000);
            LOGGER.info("datasource-market-client  transport:"+host.getString("host")+"--"+host.getIntValue("port"));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"DatasourceMarketFoodThrift");
           // DatasourceMarketSfhcThrift.Client client = new DatasourceMarketSfhcThrift.Client(mp1);
            DatasourceMarketFoodThrift.Client  client = new DatasourceMarketFoodThrift.Client(mp1);
            transport.open();
            return client;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (CafException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static DatasourceMarketJtBankThrift.Client getSdkJtBank(){
        try {
            JSONObject host = ClientCache.getHostByService("market-server", "1.0.0");
            TTransport transport = new TSocket(host.getString("host"), host.getIntValue("port"), 20000);
            LOGGER.info("datasource-market-client  transport:"+host.getString("host")+"--"+host.getIntValue("port"));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"DatasourceMarketJtBankThrift");
           // DatasourceMarketSfhcThrift.Client client = new DatasourceMarketSfhcThrift.Client(mp1);
            DatasourceMarketJtBankThrift.Client  client = new DatasourceMarketJtBankThrift.Client(mp1);
            transport.open();
            return client;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (CafException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static DatasourceMarketGsThrift.Client getSdkMarketGs(){
        try {
            JSONObject host = ClientCache.getHostByService("market-server", "1.0.0");
            TTransport transport = new TSocket(host.getString("host"), host.getIntValue("port"), 20000);
            LOGGER.info("datasource-market-client  transport:"+host.getString("host")+"--"+host.getIntValue("port"));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"DatasourceMarketGsThrift");
            
            DatasourceMarketGsThrift.Client  client = new DatasourceMarketGsThrift.Client(mp1);
            transport.open();
            return client;
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (CafException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
