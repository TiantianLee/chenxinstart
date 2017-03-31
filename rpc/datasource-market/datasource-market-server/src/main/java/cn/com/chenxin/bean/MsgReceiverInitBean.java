package cn.com.chenxin.bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import cn.com.chenxin.message.pool.ActiveMQConnectionPool;

/**
 * 初始化mq连接
 * 
 * @author lxl
 * @since 0.0.2-SNAPSHOT
 */
public class MsgReceiverInitBean implements InitializingBean {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger
            .getLogger(MsgReceiverInitBean.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("初始化jyycService mq连接");
        String url = System.getProperty("LogMQServerURL");
        ActiveMQConnectionPool.initFactory(null, null, url, 5, 100);
    }

}
