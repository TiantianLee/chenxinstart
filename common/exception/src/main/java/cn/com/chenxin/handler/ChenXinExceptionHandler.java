package cn.com.chenxin.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import cn.com.chenxin.exception.BusinessException;
import cn.com.chenxin.exception.ChenXinException;

import com.alibaba.fastjson.JSONObject;

/** 
 * 不必在Controller中对异常进行处理，抛出即可，由此异常解析器统一控制。<br> 
 * 如果controller中抛出HJDException，直接输出JSON格式异常信息，如果其他异常，返回异常错误页面。<br> 
 *  
 * @author LIYANG 
 *  
 * */  
public class ChenXinExceptionHandler extends SimpleMappingExceptionResolver implements HandlerExceptionResolver {
    /**
     * 
     */
    private static final Logger LOGGER = Logger.getLogger(ChenXinExceptionHandler.class);

    /**
     * 统一异常处理方法，如果返回INNOException，作为application/json格式返回异常信息，<br>
     * 如果作为其他异常，返回到异常信息页面
     * 
     * @param request HttpRequest
     * @param response HttpResponse
     * @param handler  异常处理器
     * @param ex       要处理的异常
     * 
     * @return ModelAndView  处理后的视图
     * 
     */
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex ) {
        
        if(ex instanceof ChenXinException){
            //对BusinessException进行处理
            if(ex instanceof BusinessException){
                BusinessException exception = (BusinessException)ex;
                response.setStatus(200);
                JSONObject obj = new JSONObject();
                obj.put("code", exception.getCode());
                obj.put("errMsg", exception.getErrMessage());
                if(null != exception.getData()){
                    obj.put("errData", exception.getData());
                }
                flushMessage(response, 200, obj);
                
            }else{
                //对其他类型异常进行处理
                ChenXinException exception = (ChenXinException) ex;
                String errorMessage = exception.getErrorMessage();
                int httpStatusCode = exception.getHttpStatusCode();
                String view = exception.getView();
                
                if(LOGGER.isInfoEnabled()){
                    LOGGER.info("errorMessage:"+errorMessage);
                    LOGGER.info("httpStatusCode:"+httpStatusCode);
                }
                
                if(null == view){
                    JSONObject obj = new JSONObject();
                    obj.put("errorCode", httpStatusCode);
                    obj.put("errorMessage", errorMessage);
                    flushMessage(response, httpStatusCode, obj);
                }else{
                    forwardToPage(response,view);
                }
                
                
            }
            return new ModelAndView();
        }else{
            ex.printStackTrace();
            return new ModelAndView("errorpage/exception").addObject("error", ex).addObject("errorInfo", ex.getCause());
        }
    }
    
    
    /**
     * 把指定的对象输出到前端浏览器、
     * @param response ServletHttpResponse
     * @param httpStatusCode  HttpStatus
     * @param obj   要输出的对象信息
     */
    private void flushMessage(HttpServletResponse response,int httpStatusCode,JSONObject obj){
        //设置异常处理返回编码格式和返回类型
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Prama", "no-cache");  
        response.setStatus(httpStatusCode);
        try {
            PrintWriter out = response.getWriter();
            out.write(obj.toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            LOGGER.error("创建错误信息时，获取response.getWriter()出现错误");
            e.printStackTrace();
        }
    }
    
    /**
     * 跳转到指定页面
     * @param response ServletHttpResponse
     * @param view  返回的视图
     */
    private void forwardToPage(HttpServletResponse response,String view){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Prama", "no-cache");  
        response.setStatus(200);
        try {
            response.sendRedirect(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
