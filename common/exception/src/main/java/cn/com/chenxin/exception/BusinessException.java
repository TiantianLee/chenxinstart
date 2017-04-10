package cn.com.chenxin.exception;

/**
 * 业务处理异常，错误代码为200
 * 
 * @author LIYANG
 *
 * @since 0.0.1-SNAPSHOT
 */
public class BusinessException extends ChenXinException {

    /**
     * 唯一版本号
     */
    private static final long serialVersionUID = 8797907368529530407L;

    /**
     * http 错误代码
     */
    private static final int HTTPSTATUSCODE = 200;
    /**
     * 错误代码
     */
    private String code;
    /**
     * 错误信息
     */
    private String errMessage;
    /**
     * 错误需要返回的数据
     */
    private Object data;

    public BusinessException() {
        super();
    }

    public BusinessException(String code, String message) {
        this.code = code;
        this.errMessage = message;
    }

    public BusinessException(String code) {
        super(code);
        this.code = code;
    }

    public BusinessException(String code, String message, Object data) {
        this.code = code;
        this.errMessage = message;
        this.data = data;
    }

    public BusinessException(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public static int getHttpstatuscode() {
        return HTTPSTATUSCODE;
    }

}
