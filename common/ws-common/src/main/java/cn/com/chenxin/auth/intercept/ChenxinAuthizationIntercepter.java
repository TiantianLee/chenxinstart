package cn.com.chenxin.auth.intercept;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;

import cn.com.chenxin.constant.SessionConstant;
import cn.com.chenxin.response.Response;

public class ChenxinAuthizationIntercepter extends HandlerInterceptorAdapter {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(ChenxinAuthizationIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            Permission auth = ((HandlerMethod) handler).getMethodAnnotation(Permission.class);
            // 没有声明需要权限,或者声明不验证权限
            if (auth == null ){
                return true;
            } else {
                List<String> permissionList = (List<String>) request.getSession().getAttribute(SessionConstant.SESSION_PERMISSIONLIST_KEY);
                if(null == permissionList){
                    logger.info("用户未登录，未能找到权限对象");
                    flushNotLoginMessage(response);
                    return false;
                }else{
                    String[] values = auth.value();
                    AuthType type = auth.type();
                    if(type.equals(AuthType.AND)){
                        //权限必须全部满足
                        boolean flag = false;
                        for (String permission : values) {
                            if(permissionList.contains(permission)){
                                flag = true;
                            }else{
                                flushNotAuthMessage(response);
                                flag = false;
                                return false;
                            }
                        }
                        return flag;
                        
                    }else if(type.equals(AuthType.OR)){
                        //权限满足任意一个即可
                        boolean flag = false;
                        for (String permission : values) {
                            if(permissionList.contains(permission)){
                                return true;
                            }else{
                                flushNotAuthMessage(response);
                                flag = false;
                                return false;
                            }
                        }
                        return flag;
                    }else{
                        return false;
                    }
                }
            }
        } else{
            return true;
        }
    }
    
    /**
     * 用户未登陆时返回该错误
     * @param response
     */
    private void flushNotAuthMessage(HttpServletResponse response){
      //设置异常处理返回编码格式和返回类型
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        JSONObject json = new JSONObject();
        json.put("errorCode", "401");
        json.put("message", "用户没有该权限");
        try {
            PrintWriter out = response.getWriter();
            out.write(json.toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            logger.error("创建错误信息时，获取response.getWriter()出现错误");
            e.printStackTrace();
        }
    }
    
    
    /**
     * 用户未登陆时返回该错误
     * @param response
     */
    private void flushNotLoginMessage(HttpServletResponse response){
      //设置异常处理返回编码格式和返回类型
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
//        InnoResponse res = Response.exception("00401", "Please Login First!");
        JSONObject json = new JSONObject();
        json.put("errorCode", "401");
        json.put("message", "用户未登录");
        try {
            response.sendError(401, "用户未登录");
            PrintWriter out = response.getWriter();
            out.write(json.toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            logger.error("创建错误信息时，获取response.getWriter()出现错误");
            e.printStackTrace();
        }
    }

}
