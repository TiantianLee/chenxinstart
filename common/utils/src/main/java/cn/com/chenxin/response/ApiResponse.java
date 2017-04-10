/**    
 * @author LIYANG  
 * @date 2016年3月1日 上午11:17:15 
 * @version V1.0   
 */
package cn.com.chenxin.response;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author LIYANG
 *
 * @since
 */
public class ApiResponse {

    /**
     * 返回码
     */
    private String resultCode;
    /**
     * 返回消息
     */
    private String message;
    
    /**
     * 原因码
     */
    private Object reasonCode;
    
    /**
     * 返回数据
     */
    private Object data;
    
    

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    public Object getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(Object reasonCode) {
        this.reasonCode = reasonCode;
    }

    /**
     * 正常返回
     * @param data 需要返回的数据
     * @return     封装的返回格式
     */
    public static ApiResponse ok(String resultCode,Object reasonCode,String message,Object data){
        ApiResponse res = new ApiResponse();
        res.setResultCode(resultCode);
        res.setReasonCode(reasonCode);
        res.setMessage(message);
        res.setData(data);
        return res;
    }
    public static ApiResponse ok(JSONObject data){
        ApiResponse res = new ApiResponse();
        res.setResultCode(data.getString("resultCode"));
        res.setReasonCode(data.getString("reasonCode"));
        res.setMessage(data.getString("message"));
        res.setData(data.getString("data"));
        return res;
    }
    
    /**
     * 错误时返回
     * @param apiCode   返回的错误码
     * @return          封装的错误消息
     */
    public static ApiResponse error(String apiCode){
        ApiResponse res = new ApiResponse();
        res.setResultCode(apiCode);
        res.setMessage(ApiCode.getMessage(apiCode));
        res.setData("");
        res.setReasonCode("");
        return res;
    }

}
