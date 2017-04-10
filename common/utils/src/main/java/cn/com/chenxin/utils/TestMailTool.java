/**   
 * 北京宸信征信有限公司  版权所有
 * @Title: TestMailTool.java 
 * @Package cn.com.chenxin.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author LIYANG  
 * @date 2015年12月25日 下午12:01:16 
 * @version V1.0   
 */
package cn.com.chenxin.utils;

import cn.com.chenxin.utils.email.EmailTools;

/**
 * 
 * @author LIYANG
 *
 * @since
 */
public class TestMailTool {

    public static void main(String[] args) {
        EmailTools et = new EmailTools("192.168.0.88", "ccsp@cxccs.com", "zzuly2010@163.com", null, "测试邮件", "这是一个测试邮件！", null, "ccsp", "123.abc", "25");
        String[] strs = et.sendMail();
        for (String string : strs) {
            System.out.println(string);
        }
    }
}
