package cn.com.chenxin.exception;
/**
 * 未授权异常 错误代码401
 * 
 */
public class UnauthorizedException extends ChenXinException {

    /**
     * 唯一版本号
     */
    private static final long serialVersionUID = -1857021965804560039L;
    
    /**
     * 异常代码HTTPStatus 401
     */
    private static final int HTTPSTATUSCODE = 401;
    
    public UnauthorizedException() {
        super();
    }
    
    public UnauthorizedException(String errorMessage) {
        super(HTTPSTATUSCODE, errorMessage);
    }
    
    public UnauthorizedException(String errorMessage,String view) {
        super(HTTPSTATUSCODE, errorMessage,view);
    }
    
    public UnauthorizedException(int httpStatusCode,String errorMessage){
        super(httpStatusCode, errorMessage);
    }

    public static int getHttpstatuscode() {
        return HTTPSTATUSCODE;
    }


}
