package cn.com.chenxin.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import cn.com.chenxin.current.CurrentUtil;
import cn.com.chenxin.entity.Log_platform;
import cn.com.chenxin.message.CommonMessageSender;
import cn.com.chenxin.model.SysUser;
import cn.com.chenxin.pool.threadpool.ThreadPool;

import com.alibaba.fastjson.JSONObject;

public class SendOperateLogTask implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(SendOperateLogTask.class);
    
    private HttpServletRequest request;
    private String accessType;
    private String operateContent;
    private String params;
 
    public SendOperateLogTask(HttpServletRequest request,String accessType,String operateContent,String params) {

        this.request = request;
        this.accessType = accessType;
        this.operateContent = operateContent;
        this.params = params;
    }

    /**
     * 
     * @param request
     *            请求体
     * @param sysUser
     *            当前用户信息
     * @param accessType
     *            访问方式(1:平台;2:接口)
     * @param operateContent
     *            操作内容
     * @param param
     *            请求参数
     */
    public void sendOperateLog() {
        Enumeration<String> names = request.getHeaderNames();
        JSONObject headers = new JSONObject();
        headers.put("ip", request.getRemoteHost());
        while (names.hasMoreElements()) {
            String name = names.nextElement().toString();
            headers.put(name, request.getHeader(name));
        }
        SysUser sysUser=CurrentUtil.getCurrentUser(request);
        Log_platform logPlatForm = new Log_platform();
        logPlatForm.setUserId(sysUser.getId());
        logPlatForm.setUserName(sysUser.getUsername());
        logPlatForm.setUserType(sysUser.getUserType());
        logPlatForm.setAccessType(accessType);
        logPlatForm.setOperateContent(operateContent);
        logPlatForm.setParams(params);
        logPlatForm.setIpAddress(request.getRemoteHost());
        logPlatForm.setRequestHeader(headers.toJSONString());
        
        LOGGER.info("---【SendProductLogTask】---产品转发日志-"+logPlatForm.toString());
        
        CommonMessageSender messageSender = new CommonMessageSender("logService_Queue", logPlatForm);
        ThreadPool.submitTask(messageSender);
    }

    @Override
    public void run() {
        sendOperateLog();
    }

}
