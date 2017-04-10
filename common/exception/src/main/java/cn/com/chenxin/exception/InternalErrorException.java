package cn.com.chenxin.exception;
/**
 * 内部错误异常，异常代码500
 * 
 * @author LIYANG
 *
 * @since 0.0.1-SNAPSHOT
 */
public class InternalErrorException extends ChenXinException {

    /**
     * 唯一版本号
     */
    private static final long serialVersionUID = 3861793415068234718L;

    /**
     * HTTP状态码
     */
    private static final int HTTPSTATUSCODE = 500;
    
    public InternalErrorException() {
        super();
    }
    
    public InternalErrorException(String errorMessage) {
        super(HTTPSTATUSCODE, errorMessage);
    }
    
    public InternalErrorException(int httpStatusCode,String errorMessage){
        super(httpStatusCode, errorMessage);
    }

    public static int getHttpstatuscode() {
        return HTTPSTATUSCODE;
    }
    
}
