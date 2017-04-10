package cn.com.chenxin.message;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import cn.com.chenxin.message.pool.ActiveMQConnectionPool;

/**
 * JMS消息发送器
 * 
 * @author LIYANG
 *
 * @since 0.0.2-SNAPSHOT
 */
public class MessageSender implements Runnable {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(MessageSender.class);

    /**
     * 消息队列名称
     */
    private String queue;
    /**
     * 文本消息内容
     */
    private String messageText;

    public MessageSender(String queue, String messageText) {
        this.queue = queue;
        this.messageText = messageText;
    }

    /**
     * 线程异步执行方法
     */
    public void run() {
        LOGGER.info("messageSender线程执行开始：  messageText:" + messageText + "    queue:" + queue);

        Session session = null;
        Destination destination;
        MessageProducer producer;
        Connection connection = ActiveMQConnectionPool.getJMSConnection();

        try {
            LOGGER.info("messageSender线程执行开始     connection:" + connection);
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(queue);
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage message = session.createTextMessage(messageText);
            LOGGER.info("messageSender线程执行开始     message:" + message);
            producer.send(message);

            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

}
