/**    
* @author TianTian  
* @date 2016年5月5日 上午11:37:29 
* @version V1.0   
*/
package cn.com.chenxin.test.lsjh;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 揽胜聚合数据测试代码
 * 
 * @author TianTian
 *
 * @since 
 */
public class LsjhTestBatch {
    
    private static String apps_android = "com.rrh.jdb,com.lufax.android";
    private static String apps_apple = "983151079,615961912";
    private static String juheUrl = "https://xxxxx";
    private static String juheAppkey = "xxxx";
    private static String juhetoken = "xxxx";
    private static int juhePlatform_android = 2;
    private static int juhePlatform_apple = 1;
    
    
    public static void main(String[] args) {
        /*JSONArray trackmthArray = new JSONArray();
        JSONArray tagsArray = new JSONArray();
        JSONArray appsArray = new JSONArray();
        JSONArray appusesArray = new JSONArray();
        JSONObject jhJsonObject = new JSONObject();*/
        
          String phonenum1 = "1383817xxxx";
//        String phonenum1 = "1371650xxxx";
        
        String resultFirst = "";
        String resultFirst1 = "";
        String phonenum0 = "86" + phonenum1;
        String phonenum = MD5Utils.getMD5Str(phonenum0);
        String url = juheUrl + "?appkey=" + juheAppkey + "&token=" + juhetoken + "&phonenum=" + phonenum + "&platform=" + juhePlatform_android
                + "&apps=" + apps_android;
        String url1 = juheUrl + "?appkey=" + juheAppkey + "&token=" + juhetoken + "&phonenum=" + phonenum + "&platform=" + juhePlatform_apple
                + "&apps=" + apps_apple;
        HttpUtilByTian t = new HttpUtilByTian();
        resultFirst = t.doGet(url);
        resultFirst1 = t.doGet(url1);
        System.out.println(resultFirst);
        System.out.println(resultFirst1);
    }
    

}
