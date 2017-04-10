package cn.com.chenxin.pool.threadpool;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;

/**
 * 系统线程池，统一管理线程的创建和使用调度
 * 
 * @author LIYANG
 * @since 0.0.1-SNAPSHOT
 */
public class ThreadPool {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(ThreadPool.class);

    /**
     * 线程池
     */
    private static ExecutorService threadPool = null;

    static {
        LOGGER.info("初始化线程池......");
        threadPool = Executors.newFixedThreadPool(3, new ServiceThreadFactory());
        LOGGER.info("线程池初始化完毕.....");
    }

    /**
     * 向线程池提交任务，并返回执行结果
     * 
     * @param task CallableTask
     * @param <T> Object
     * @return Future<T> 线程执行结果
     */
    public static <T> Future<T> submitTask(Callable<T> task) {
        LOGGER.info("线程池开始执行Callable任务....");
        Future<T> future = threadPool.submit(task);
        LOGGER.info("线程池中活动线程数：" + ((ThreadPoolExecutor) threadPool).getActiveCount());
        return future;
    }

    /**
     * 向线程池中提交任务，返回线程状态
     * 
     * @param task 可执行的任务
     * @param <T> Object
     * @return  线程执行结果
     */
    public static <T> Future<T> submitTask(Runnable task) {
        LOGGER.info("线程池开始执行Runnable任务，并返回结果....");
        Future future = threadPool.submit(task);
        LOGGER.info("线程池中活动线程数：" + ((ThreadPoolExecutor) threadPool).getActiveCount());
        return future;
    }

    /**
     * 提交任务到线程池执行，无返回值
     * 
     * @param task 可执行任务
     */
    public static void executeTask(Runnable task) {
        LOGGER.info("线程池开始执行Runnable任务，无返回结果......");
        LOGGER.info("线程池中活动线程数：" + ((ThreadPoolExecutor) threadPool).getActiveCount());
        threadPool.execute(task);
    }

    /**
     * 提交批量任务到线程池
     * 
     * @param tasks  批量可执行任务
     * @return 批量执行后的结果
     * @throws InterruptedException 如果线程执行过程中出现中断，抛出异常
     */ 
    public static List<Future<Object>> executeAllTask(Collection<? extends Callable<Object>> tasks) throws InterruptedException {
        LOGGER.info("线程池开始批量执行任务......");
        List<Future<Object>> list = threadPool.invokeAll(tasks);
        LOGGER.info("线程池中活动线程数：" + ((ThreadPoolExecutor) threadPool).getActiveCount());
        return list;
    }

}
