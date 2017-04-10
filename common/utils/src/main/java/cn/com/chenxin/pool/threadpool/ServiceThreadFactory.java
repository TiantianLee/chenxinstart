package cn.com.chenxin.pool.threadpool;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadFactory;

/**
 * 线程创建工场
 * 
 * @author LIYANG
 *
 * @since 0.0.1-SNAPSHOT
 */
public class ServiceThreadFactory implements ThreadFactory {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(ServiceThreadFactory.class);

    /**
     * 统一创建线程工厂方法
     */
    @Override
    public Thread newThread(Runnable runnable) {
        LOGGER.info("线程池初始化工场开始创建线程......");
        return new Thread(runnable);
    }

}
