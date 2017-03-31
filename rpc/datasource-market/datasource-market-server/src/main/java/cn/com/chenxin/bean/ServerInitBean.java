/**    
* @author LIYANG  
* @date 2016年3月23日 上午10:36:14 
* @version V1.0   
*/
package cn.com.chenxin.bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import cn.com.chenxin.caf.CAFInitialize;
import cn.com.chenxin.pool.threadpool.ThreadPool;

/**
 * 初始化account-server基础配置
 * 
 * @author LIYANG
 *
 * @since 
 */
public class ServerInitBean implements InitializingBean {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(ServerInitBean.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        //1.启动server监听
        LOGGER.info("启动marketServer服务.....");
        CAFInitialize.init("market-server", "1.0.0");;
        
        InitServer server = new InitServer();
        ThreadPool.submitTask(server);
    }

}
