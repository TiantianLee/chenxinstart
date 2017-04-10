package cn.com.chenxin.configration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.apache.log4j.filter.LoggerMatchFilter;
import org.apache.log4j.net.SMTPAppender;
import org.apache.log4j.xml.Log4jEntityResolver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.Log4jConfigurer;

/**
 * 配置文件处理类
 * 
 * @author LIYANG
 *
 * @since 0.0.2-SNAPSHOT
 */
public class PropertyPlaceholderConfigurerExt  extends PropertyPlaceholderConfigurer {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(PropertyPlaceholderConfigurerExt.class);
    
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
                    throws BeansException {
        String env = (String)props.get("env");
        LOGGER.info("当前开发环境为： "+env);
        SMTPAppender appender=(SMTPAppender) Logger.getRootLogger().getAppender("MAIL");
        appender.setSubject("Error-Message:"+env);
        appender.activateOptions();
        Properties p = new Properties();
        File file = null;
        try {
            file = new File(PropertyPlaceholderConfigurerExt.class.getClassLoader().getResource(env).getPath());
        } catch (RuntimeException e) {
            LOGGER.error("未能找到"+env+"目录");
        }
        if(null != file && file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                Properties temp = new Properties();
                try {
                    temp.load(new FileInputStream(f));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                Set<Object> keySet = temp.keySet();
                Iterator<Object> it = keySet.iterator();
                while(it.hasNext()){
                    String key = (String) it.next();
                    p.put(key, temp.getProperty(key));
                }
                
            }
            
        }
            
        Set<Object> set = p.keySet();
        for (Object key : set) {
            LOGGER.info("初始化配置文件参数："+key.toString()+" ==== "+p.getProperty(key.toString()));
            System.setProperty(key.toString(), p.getProperty(key.toString()));
        }
        
        super.processProperties(beanFactory, p);

    }

}
