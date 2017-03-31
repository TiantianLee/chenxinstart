package cn.com.chenxin.utils;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 初始化ServletContextListener
 * 
 * @author LIYANG
 * @since 0.0.2-SNAPSHOT
 */
public class SpringInit implements ServletContextListener {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(SpringInit.class);

    /**
     * Spring 上下文
     */
    private static WebApplicationContext springContext;

    public SpringInit() {
        super();
        LOGGER.info("init  Spring WebApplicationContext .........");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        springContext = WebApplicationContextUtils.getWebApplicationContext(sce
                .getServletContext());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    public static ApplicationContext getApplicationContext() {
        return springContext;
    }

}
