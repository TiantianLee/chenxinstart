package cn.com.chenxin.message;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.log4j.Logger;

import cn.com.chenxin.entity.LogMessage;
import cn.com.chenxin.message.pool.ActiveMQConnectionPool;

/**
 * JMS消息发送器
 * 
 * @author LIYANG
 *
 * @since 0.0.2-SNAPSHOT
 */
public class CommonMessageSender implements Runnable {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(CommonMessageSender.class);

    /**
     * 消息队列名称
     */
    private String queue;
    /**
     * 文本消息内容
     */
    private String messageText;
    /**
     * 对象消息内容
     */
    private LogMessage messageObject;
    
    
    

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

	public LogMessage getMessageObject() {
		return messageObject;
	}

	public void setMessageObject(LogMessage messageObject) {
		this.messageObject = messageObject;
	}

	public CommonMessageSender(String queue,String messageText ) {
        this.queue = queue;
        this.messageText = messageText;
    }
    
    public CommonMessageSender(String queue,LogMessage messageObject){
    	this.queue = queue;
        this.messageObject = messageObject;
    }

    /**
     * 线程异步执行方法
     */
    public void run() {
        LOGGER.info("CommomMessageSender线程执行开始：   queue:" + queue);

        Session session = null;
        Destination destination;
        MessageProducer producer;

        try {
        	Connection connection = ActiveMQConnectionPool.getJMSConnection();
            LOGGER.info("messageSender线程执行开始     connection:" + connection);
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(queue);
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            Message message=null;
            if(messageText!=null){
            	message = session.createTextMessage(messageText);
            }else if(messageObject!=null){
            	message = session.createObjectMessage(messageObject);
            }
            producer.send(message);

            session.close();
        } catch (Exception e) {
        	LOGGER.error(e);
            e.printStackTrace();
        }
    }


}
