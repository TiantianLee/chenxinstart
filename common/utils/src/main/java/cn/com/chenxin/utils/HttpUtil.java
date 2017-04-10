package cn.com.chenxin.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

/**
 * HTTP 工具类，用于发送GET，POST
 * 
 * @author LIYANG
 *
 * @since 0.0.2-SNAPSHOT
 */
public class HttpUtil {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(HttpUtil.class);

    /**
     * 发送Http的GET请求，返回JSONObject
     * 
     * @param url
     *            请求路径
     * @return 请求返回结果
     * @throws IOException   请求异常抛出异常
     * @throws ClientProtocolException 请求异常抛出异常
     */
    public static String doJsonGet(String url) throws ClientProtocolException, IOException {
        LOGGER.info("请求地址为：" + url + " ;请求方式为： GET ;");
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        final MyResponseHandler<Object> handler = new MyResponseHandler<Object>();

        return httpclient.execute(httpget, handler).toString();
    }

    /**
     * 发送Http的GET请求，返回JSONObject
     * 
     * @param url
     *            请求路径
     * @param time
     *            请求获取数据超时时间
     * @return 请求返回结果
     * @throws IOException   请求异常抛出异常
     * @throws ClientProtocolException 请求异常抛出异常
     */
    public static String doJsonGet(String url, int time) throws ClientProtocolException, IOException {
        LOGGER.info("请求地址为：" + url + " ;请求方式为： GET ;");
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(time).build();
        httpget.setConfig(requestConfig);
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        final MyResponseHandler<Object> handler = new MyResponseHandler<Object>();

        return httpclient.execute(httpget, handler).toString();
    }

    /**
     * 发送HTTP POST请求，返回JSONObject数据
     * 
     * @param url
     *            请求路径
     * @param params
     *            请求参数
     * @return 请求返回结果
     * @throws IOException   请求异常抛出异常
     * @throws ClientProtocolException 请求异常抛出异常
     */
    public static String doJsonPost(String url, JSONObject params) throws ClientProtocolException, IOException {
        LOGGER.info("请求地址为：" + url + "请求方式为： POST ;请求参数为： " + params);
        HttpClient httpclient = HttpClients.createDefault();
        // HttpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        HttpPost httpPost = new HttpPost(url);

        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

        StringEntity entity = new StringEntity(params.toString(), "utf-8");// 解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        return httpclient.execute(httpPost, new MyResponseHandler<Object>()).toString();
    }

    /**
     * 发送HTTP POST请求，返回JSONObject数据
     * 
     * @param url
     *            请求路径
     * @param params
     *            请求参数
     * @param time
     *            请求获取数据超时时间
     * @return 请求返回结果
     * @throws IOException   请求异常抛出异常
     * @throws ClientProtocolException 请求异常抛出异常
     */
    public static String doJsonPost(String url, JSONObject params, int time) throws ClientProtocolException, IOException {
        LOGGER.info("请求地址为：" + url + "请求方式为： POST ;请求参数为： " + params + "请求获取数据超时时间" + time);
        HttpClient httpclient;
        HttpPost httpPost;
        httpclient = HttpClients.createDefault();

        httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(time).build();
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

        StringEntity entity = new StringEntity(params.toString(), "utf-8");// 解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");

        httpPost.setEntity(entity);

        return httpclient.execute(httpPost, new MyResponseHandler<Object>()).toString();
    }

    static class MyResponseHandler<T> implements ResponseHandler<Object> {

        @Override
        public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
            StatusLine statusLine = response.getStatusLine();
            HttpEntity entity = response.getEntity();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                if (entity == null) {
                    throw new ClientProtocolException("Response contains no content");
                }
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                String str = EntityUtils.toString(entity, charset);
                return str;
            } else {
                LOGGER.info("请求返回相应码为：" + statusLine.getStatusCode());
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                LOGGER.info("返回内容为：" + EntityUtils.toString(entity, charset));
                LOGGER.error("解析返回数据失败");
                throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
            }
        }
    }

}
