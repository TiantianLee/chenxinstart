package cn.com.chenxin.message.pool;

import javax.jms.Connection;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnection;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.log4j.Logger;

/**
 * activeMQ连接池
 * @author LIYANG
 *
 */
public class ActiveMQConnectionPool {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(ActiveMQConnectionPool.class);

    /**
     * JMS连接工场
     */
    private static ActiveMQConnectionFactory factory;
    /**
     * JMS连接工场POOl
     */
    private static PooledConnectionFactory pooledFactory;
    /**
     * JMS连接池
     */
    private static PooledConnection pooledConnection;
    
    /**
     * 初始化ActiveMQ连接池工厂
     * @param username  用户名
     * @param password  密码
     * @param brokerURI  AMQ 连接地址
     * @param maxConnections 最大连接数
     * @param sessionPerConn 每个连接最大session数量
     */
    public static void initFactory(String username,String password,String brokerURI,int maxConnections,int sessionPerConn){
        LOGGER.info("开始初始化ActiveMQ连接池......");
        try {
            factory = new ActiveMQConnectionFactory(username,password,brokerURI);
            pooledFactory = new PooledConnectionFactory(factory);
            pooledFactory.setMaxConnections(maxConnections);
            pooledFactory.setCreateConnectionOnStartup(true);
            pooledFactory.setMaximumActiveSessionPerConnection(sessionPerConn);
            pooledConnection = (PooledConnection) pooledFactory.createConnection();
            LOGGER.info("ActiveMQ连接池初始化完成......");
        } catch (Exception e) {
            LOGGER.error("JMS连接池初始化失败......");
            e.printStackTrace();
        }
    }

    /**
     * 从连接池中获取MQ连接
     * @return JMS Connection
     */
    public static Connection getJMSConnection() {
        try {
            ActiveMQConnection amqC = (ActiveMQConnection) pooledConnection.getConnection();
            amqC.start();
            LOGGER.info("从连接池中获取连接，获取到的连接为："+amqC);
            return amqC;
        } catch (JMSException e) {
            LOGGER.error("从JMS连接池中获取MQ连接失败......");
            e.printStackTrace();
            return null;
        }
    }

}
