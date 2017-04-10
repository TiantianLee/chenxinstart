package cn.com.chenxin.exception;
/**
 * 禁止异常，HTTP STATUS 403
 * 
 * @author LIYANG
 *
 * @since 0.0.1-SNAPSHOT
 */
public class ForbiddenException extends ChenXinException {

    /**
     * 唯一版本号
     */
    private static final long serialVersionUID = 3186744565883843256L;
    
    /**
     * 错误状态码
     */
    private static final int HTTPSTATUSCODE = 403;
    
    public ForbiddenException() {
        super();
    }
    
    public ForbiddenException(String errorMessage) {
        super(HTTPSTATUSCODE, errorMessage);
    }
    
    public ForbiddenException(int httpStatusCode,String errorMessage){
        super(httpStatusCode, errorMessage);
    }

    public static int getHttpstatuscode() {
        return HTTPSTATUSCODE;
    }
    
    

}
