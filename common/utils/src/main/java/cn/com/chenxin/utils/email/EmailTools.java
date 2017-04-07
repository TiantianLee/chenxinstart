package cn.com.chenxin.utils.email;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 实现邮件发送功能
 * 
 * @author LIYANG
 * 
 */
public class EmailTools {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LogManager.getLogger(EmailTools.class);

    /** 服务器地址*/
    private String host; 
    /** 发件人*/
    private String from; 
    /** 收件人 多个收件人以,分隔*/
    private String to; 
    /** 抄送人，多个抄送人用,分割*/
    private String cc; 
    /** 主题*/
    private String title; 
    /** 内容*/
    private String content; 
    /** 附件集*/
    private List<File> attachmentlist; 
    /** 用户名*/
    private String username; 
    /** 密码*/
    private String password; 
    /** 端口*/
    private String port;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<File> getAttachmentlist() {
        return attachmentlist;
    }

    public void setAttachmentlist(List<File> attachmentlist) {
        this.attachmentlist = attachmentlist;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    /**
     * 邮件工具类构造函数
     * @param host      邮箱服务器域名
     * @param from      邮件发送人账户
     * @param to        邮件发送到账户，如发送多人，用逗号隔开
     * @param cc        邮件抄送账户，如抄送多人，用逗号隔开
     * @param title     邮件标题
     * @param content   邮件正文
     * @param attachmentlist    邮件附件列表List<File>
     * @param username  邮件账户
     * @param password  邮件密码
     * @param port      邮件发送端口
     */
    public EmailTools(String host, String from, String to,String cc, String title, String content, List<File> attachmentlist,
            String username, String password, String port) {
        this.host = host;
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.title = title;
        this.content = content;
        this.attachmentlist = attachmentlist;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    /**
     * 邮件发送工具构造函数
     * @param to        邮件发送到账户，如发送多人，用逗号隔开
     * @param cc        邮件抄送账户，如抄送多人，用逗号隔开
     * @param title     邮件标题
     * @param content   邮件正文
     * @param attachmentlist    邮件附件列表List<File>
     */
    public EmailTools(String to,String cc, String title, String content, List<File> attachmentlist) {
        this.to = to;
        this.title = title;
        this.content = content;
        this.attachmentlist = attachmentlist;
        this.username = System.getProperty("mail.username");
        this.password = System.getProperty("mail.password");
        this.host = System.getProperty("mail.host");
        this.port = System.getProperty("mail.port");
        this.from = System.getProperty("mail.from");
    }

    /**
     * 发送邮件
     * 
     * @return 发送状态信息 index0：状态 0成功 1失败;index1：描述错误信息
     */
    public String[] sendMail() {
        String[] result = new String[2];

        Session session = null;
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.sendpartial", "true");
        props.put("mail.smtp.port", port);

        if (StringUtils.isBlank(username)) {// 不需要验证用户名密码
            session = Session.getDefaultInstance(props, null);
        } else {
            props.put("mail.smtp.auth", "true");
            EmailAuthenticator auth = new EmailAuthenticator(username, password);
            session = Session.getInstance(props, auth);
        }

        // 设置邮件发送信息
        try {
            // 创建邮件
            MimeMessage message = new MimeMessage(session);
            // 设置发件人地址
            message.setFrom(new InternetAddress(from));
            // 设置收件人地址（多个邮件地址）
            InternetAddress[] toAddr = InternetAddress.parse(to);
            if(null == cc){
                cc = "";
            }
            InternetAddress[] ccAddr = InternetAddress.parse(cc);
            message.addRecipients(Message.RecipientType.TO, toAddr);
            message.addRecipients(Message.RecipientType.CC, ccAddr);
            // 设置邮件主题
            message.setSubject(title);
            // 设置发送时间
            message.setSentDate(new Date());
            // 设置发送内容
            Multipart multipart = new MimeMultipart();
            MimeBodyPart contentPart = new MimeBodyPart();
            contentPart.setText(content);
            multipart.addBodyPart(contentPart);
            // 设置附件
            if (attachmentlist != null && attachmentlist.size() > 0) {
                for (int i = 0; i < attachmentlist.size(); i++) {
                    MimeBodyPart attachmentPart = new MimeBodyPart();

                    FileDataSource source = new FileDataSource(attachmentlist.get(i));
                    attachmentPart.setDataHandler(new DataHandler(source));
                    attachmentPart.setFileName(MimeUtility.encodeWord(attachmentlist.get(i).getName(), "gb2312", null));
                    multipart.addBodyPart(attachmentPart);
                }
            }
            
            message.setContent(multipart);

            // 登录SMTP服务器
            if (StringUtils.isBlank(username)) {
                // 不需验证
                Transport.send(message);
            } else {
                // 需要验证
                Transport transport = session.getTransport("smtp");
                transport.connect();
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }

            result[0] = "0";
            result[1] = "发送成功";

            LOGGER.info("邮件发送成功!发送人：" + from);

        } catch (MessagingException mex) {
            result[0] = "1";
            result[1] = "邮件服务器发生错误";

            if (mex instanceof AuthenticationFailedException) {
                result[1] = "用户名或密码错误";
            }
            LOGGER.error("邮件发送失败，用户名或密码错误");
            LOGGER.error(mex);
        } catch (Exception e) {
            result[0] = "1";
            result[1] = "系统异常";
            LOGGER.error("邮件发送失败，系统异常");
            LOGGER.error(e);
        }

        return result;
    }
    
    /**
     * 发送html格式的邮件
     * @return
     */
    public String[] sendHtmlMail() {  
        String[] result = new String[2];
        // 判断是否需要身份认证  
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.sendpartial", "true");
        props.put("mail.smtp.port", port);

        Session session = null;
        EmailAuthenticator auth = null;
        if (StringUtils.isBlank(username)) {// 不需要验证用户名密码
            session = Session.getDefaultInstance(props, null);
        } else {
            props.put("mail.smtp.auth", "true");
             auth = new EmailAuthenticator(username, password);
            session = Session.getInstance(props, auth);
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session  
        Session sendMailSession = Session  
                .getDefaultInstance(props, auth);  
        try {  
            // 根据session创建一个邮件消息  
            Message mailMessage = new MimeMessage(sendMailSession);  
            // 创建邮件发送者地址  
           Address fromAddress = new InternetAddress(from);  
            // 设置邮件消息的发送者  
            mailMessage.setFrom(fromAddress);  
            // 创建邮件的接收者地址，并设置到邮件消息中  
            /* Address toAddress = new InternetAddress(to);  
            // Message.RecipientType.TO属性表示接收者的类型为TO  
            mailMessage.setRecipient(Message.RecipientType.TO, toAddress); */ 
            InternetAddress[] toAddr = InternetAddress.parse(to);
            if(null == cc){
                cc = "";
            }
            InternetAddress[] ccAddr = InternetAddress.parse(cc);
            mailMessage.addRecipients(Message.RecipientType.TO, toAddr);
            mailMessage.addRecipients(Message.RecipientType.CC, ccAddr);
            // 设置邮件消息的主题  
            mailMessage.setSubject(title);  
            // 设置邮件消息发送的时间  
            mailMessage.setSentDate(new Date());  
              
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象  
            Multipart mainPart = new MimeMultipart();  
            // 创建一个包含HTML内容的MimeBodyPart  
            BodyPart html = new MimeBodyPart();  
            // 设置HTML内容  
            html.setContent(content, "text/html; charset=utf-8");  
            mainPart.addBodyPart(html);  
              
            //设置信件的附件(用本地上的文件作为附件)  
//            html = new MimeBodyPart();  
            
            if (attachmentlist != null && attachmentlist.size() > 0) {
                for (int i = 0; i < attachmentlist.size(); i++) {
                    html = new MimeBodyPart();

                    FileDataSource source = new FileDataSource(attachmentlist.get(i));
                    html.setDataHandler(new DataHandler(source));
                    html.setFileName(MimeUtility.encodeWord(attachmentlist.get(i).getName(), "gb2312", null));
                    mainPart.addBodyPart(html);
                }
            }
            
            /*FileDataSource fds = new FileDataSource("D:\\...javamail.doc");  
            DataHandler dh = new DataHandler(fds);  
            html.setFileName("javamail.doc");  
            html.setDataHandler(dh);  
            mainPart.addBodyPart(html);  */
              
            // 将MiniMultipart对象设置为邮件内容  
            mailMessage.setContent(mainPart);  
            mailMessage.saveChanges();  
              
            // 发送邮件  
            Transport.send(mailMessage);  
            result[0] = "0";
            result[1] = "发送成功";

            LOGGER.info("邮件发送成功!发送人：" + from);
        } catch (MessagingException mex) {
            result[0] = "1";
            result[1] = "邮件服务器发生错误";

            if (mex instanceof AuthenticationFailedException) {
                result[1] = "用户名或密码错误";
            }
            LOGGER.error("邮件发送失败，用户名或密码错误");
            LOGGER.error(mex);
        } catch (Exception e) {
            result[0] = "1";
            result[1] = "系统异常";
            LOGGER.error("邮件发送失败，系统异常");
            LOGGER.error(e);
        }
        return result;
    }  

}

/**
 * class MyAuthenticator用于邮件服务器认证 构造器需要用户名、密码作参数
 */
class EmailAuthenticator extends Authenticator {

    /**
     * 用户名
     */
    private String username = null;

    /**
     * 密码
     */
    private String password = null;

    /**
     * 邮箱认证方法
     * @param username 用户名
     * @param password  密码
     */
    public EmailAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}


