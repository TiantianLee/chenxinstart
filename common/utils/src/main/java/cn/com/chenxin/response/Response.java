package cn.com.chenxin.response;

import org.apache.log4j.Logger;

/**
 * REST 封装返回后的结果，application/json
 * 
 * @author LIYANG
 *
 * @since 0.0.1-SNAPSHOT
 */
public class Response {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = Logger.getLogger(Response.class);

    /**
     * 要处理的结果
     */
    private Object data;

    /**
     * 要执行的封装的对象
     * @param obj   封装的对象
     * @return Response对象
     */
    public static Response ok(Object obj) {
        Response response = new Response();
        response.setData(obj);
        return response;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
