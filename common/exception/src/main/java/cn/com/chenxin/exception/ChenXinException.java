package cn.com.chenxin.exception;
/**
 * 异常父类
 * 
 */
public class ChenXinException extends Exception {

    /**
     * 唯一版本号
     */
    private static final long serialVersionUID = 1142052391992934175L;
    
    /**错误提示信息*/
    protected String errorMessage;
    
    /**HTTP Status */
    protected int httpStatusCode;
    
    /**
     * 指定视图
     */
    protected String view;
    
    public ChenXinException() {
        super();
    }
    
    public ChenXinException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    
    public ChenXinException(int httpStatusCode,String errorMessage){
        this.httpStatusCode = httpStatusCode;
        this.errorMessage = errorMessage;
    }
    
    public ChenXinException(int httpStatusCode,String errorMessage,String view){
        this.httpStatusCode = httpStatusCode;
        this.errorMessage = errorMessage;
        this.view = view;
    }

    
    public String getErrorMessage() {
        return errorMessage;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
    
    

}
