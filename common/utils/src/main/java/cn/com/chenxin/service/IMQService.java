package cn.com.chenxin.service;

/**
 * ApacheMQ RPC服务接口类
 * 
 * @author LIYANG
 * 
 * @since 0.0.2-SNAPSHOT
 *
 */
public interface IMQService {

    /**
     * 处理方法接口
     * @param params    参数
     * @return          返回字符串处理结果
     */
    String doService(Object... params);

}
