package cn.com.chenxin.exception;
/**
 * NOT FOUND 异常 ，错误代码404
 * 
 * @author LIYANG
 *
 * @since 0.0.1-SNAPSHOT
 */
public class NotFoundException extends ChenXinException {

    /**
     * 唯一版本号
     */
    private static final long serialVersionUID = -8164095294982522535L;
    
    /**
     * 错误代码404
     */
    private static final int HTTPSTATUSCODE = 404;
    
    public NotFoundException() {
        super();
    }
    
    public NotFoundException(String errorMessage) {
        super(HTTPSTATUSCODE, errorMessage);
    }
    
    public NotFoundException(int httpStatusCode,String errorMessage){
        super(httpStatusCode, errorMessage);
    }

    public static int getHttpstatuscode() {
        return HTTPSTATUSCODE;
    }


}
