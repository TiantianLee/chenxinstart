package cn.com.chenxin.test.lsjh;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * 
 * 绕过ssl证书调用接口
 * 
 * @author TianTian
 *
 * @since 0.0.1-SNAPSHOT
 */
@SuppressWarnings("deprecation")
public class HttpUtilByTian {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(HttpUtilByTian.class);

    /**
     * 绕过ssl证书调用get接口
     * 
     * @param url
     * @return String 接口返回数据
     */
    @SuppressWarnings({ "resource" })
    public String doGet(String url) {
        LOGGER.info("请求地址为：" + url + " ;请求方式为： GET ;");
        String temp_id = "";
        HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例
        X509TrustManager xtm = new X509TrustManager() { // 创建TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        try {
            // TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext
            SSLContext ctx = SSLContext.getInstance("SSL");

            // 使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
            ctx.init(null, new TrustManager[] { xtm }, null);

            // 创建SSLSocketFactory
            SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);

            // 通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上
            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", socketFactory, 443));
            httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

            // 创建HttpGet方法的实例
            HttpGet httpGet = new HttpGet(url); // 创建HttpPost
            HttpResponse response = httpClient.execute(httpGet);

            // 执行
            if (response.getStatusLine().getStatusCode() == 200) {
                // 读取内容
                HttpEntity entity = response.getEntity(); // 获取响应实体
                if (null != entity) {
                    temp_id = EntityUtils.toString(entity, "UTF-8");
                }
            } else {
                System.out.println("获取response时，认证平台发生内部错误！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw new Exception("认证失败，原因：[认证系统异常].");
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            // 释放连接
            httpClient.getConnectionManager().shutdown(); // 关闭连接,释放资源
        }
        return temp_id;
    }
}
