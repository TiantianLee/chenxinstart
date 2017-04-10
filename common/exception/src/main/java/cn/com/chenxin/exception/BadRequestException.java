package cn.com.chenxin.exception;

/**
 * 请求错误异常，错误代码为HTTP CODE 400
 * 
 */
public class BadRequestException extends ChenXinException {

    /**
     * 唯一版本号
     */
    private static final long serialVersionUID = 8797907368529530407L;
    
    /**
     * 错误码 400
     */
    private static final int HTTPSTATUSCODE = 400;
    
    public BadRequestException() {
        super();
    }
    
    public BadRequestException(String errorMessage) {
        super(HTTPSTATUSCODE, errorMessage);
    }
    
    public BadRequestException(int httpStatusCode,String errorMessage){
        super(httpStatusCode, errorMessage);
    }

    public static int getHttpstatuscode() {
        return HTTPSTATUSCODE;
    }
    
    

}
