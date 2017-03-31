/**    
* @author LIYANG  
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
import cn.com.chenxin.iface.datasourceMarkeThrift;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author LIYANG
 *
 * @since 
 */
public class DatasourceMarketClient {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(DatasourceMarketClient.class);
    
    /**
     * 获取SDK
     * @return
     */
    public static datasourceMarkeThrift.Client getSdk(){
        try {
            JSONObject host = ClientCache.getHostByService("market-server", "1.0.0");
            TTransport transport = new TSocket(host.getString("host"), host.getIntValue("port"), 20000);
            LOGGER.info("datasource-market-client  transport:"+host.getString("host")+"--"+host.getIntValue("port"));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"datasourceMarkeThrift");
            datasourceMarkeThrift.Client client = new datasourceMarkeThrift.Client(mp1);
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
