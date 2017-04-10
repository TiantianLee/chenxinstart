package cn.com.chenxin.message;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;

import cn.com.chenxin.message.pool.ActiveMQConnectionPool;

/**
 * JMS 消息接收器
 * 
 * @author LIYANG
 *
 * @since 0.0.2-SNAPSHOT
 */
public class CommonMessageReceiver implements Runnable {
    /**
     * 消息队列名称
     */
    private String queue;
    /**
     * 消息接收监听器
     */
    private MessageListener listener;

    public CommonMessageReceiver(String queue, MessageListener listener) {
        this.queue = queue;
        this.listener = listener;
    }

    /**
     * 线程异步执行方法
     */
    public void run() {
        Session session = null;
        MessageConsumer consumer;
        Connection connection = null;
        try {
            connection = ActiveMQConnectionPool.getJMSConnection();
            Queue queue1 = new ActiveMQQueue(queue);
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            consumer = session.createConsumer(queue1);
            consumer.setMessageListener(listener);

        } catch (JMSException e) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

}
