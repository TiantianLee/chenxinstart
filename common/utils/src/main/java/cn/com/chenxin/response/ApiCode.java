/**    
* @author LIYANG  
* @date 2016年3月1日 上午11:20:24 
* @version V1.0   
*/
package cn.com.chenxin.response;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回API信息时的错误消息
 * 
 * @author LIYANG
 *
 * @since 
 */
public class ApiCode {
    
    /**
     * 用于存储API错误代码
     */
    private static Map<String,String> map = new HashMap<String, String>();

    /**
     * 没有权限访问该服务
     */
    public static final String NOT_AUTHORIZATION = "D001"; 
    
    /**
     * 用户信息错误
     */
    public static final String ERROR_USERINFO = "D002"; 
    
    /**
     * 账户余额不足
     */
    public static final String NO_BANLANCE = "D003"; 
    /**
     * 数据签名错误
     */
    public static final String SIGN_DATAERROR = "D004"; 
    
    /**
     * 参数过长
     */
    public static final String PARAM_TOOLANG = "D005"; 
    /**
     * 部分参数为空
     */
    public static final String PARAM_EMPTY = "D006"; 
    /**
     * 部分参数格式不正确
     */
    public static final String PARAM_PATTERN_ERROR = "D007"; 
    /**
     * 参数非法
     */
    public static final String PARAM_ILLEGAL = "D008"; 
    /**
     * 请求超时
     */
    public static final String REQUEST_TIMEOUT = "D009"; 
    /**
     * ip地址受限
     */
    public static final String IP_FORBIDDEN = "D010"; 
    
    /**
     * 测试量用完
     */
    public static final String NO_TEST_COUNT = "D011"; 
    
    /**
     * 根据APICode获取错误信息
     * @param apiCode   APIcode
     * @return          错误信息
     */
    public static String getMessage(String apiCode){
        return map.get(apiCode);
    }
    
    
    static {
        map.put(NOT_AUTHORIZATION, "没有权限访问该服务");
        map.put(ERROR_USERINFO, "用户信息错误");
        map.put(NO_BANLANCE, "账户余额不足，不能正常访问该服务");
        map.put(SIGN_DATAERROR, "参数数据加密错误");
        map.put(PARAM_TOOLANG, "数据参数不正确（输入参数过长）");
        map.put(PARAM_EMPTY, "参数数据不正确（部分参数为空）");
        map.put(PARAM_PATTERN_ERROR, "参数数据不正确（参数格式不正确）");
        map.put(PARAM_ILLEGAL, "参数数据不正确（参数输入项不合法）");
        map.put(REQUEST_TIMEOUT, "系统错误，结果返回超时");
        map.put(IP_FORBIDDEN, "无权查询数据（ IP 地址未绑定）");
        map.put(NO_TEST_COUNT, "无权查询数据（测试量已用完）");
    }
    
    
}
