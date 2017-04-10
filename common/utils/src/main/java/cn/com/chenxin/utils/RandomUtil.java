package cn.com.chenxin.utils;

import java.util.Random;


public class RandomUtil {

    private static final String NUMSTR = "0123456789";
    private static final String LOWER_STR = "qwertyuiopasdfghjklzxcvbnm";
    private static final String UPPER_STR = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String NUM_LOWER_STR = "0123456789qwertyuiopasdfghjklzxcvbnm";
    private static final String NUM_UPPER_STR = "0123456789QWERTYUIOPASDFGHJKLZXCVBNM";
    
    /**
     * 获取指定长度的数字随机数
     * @param len
     * @return
     */
    public static String getRandomNumStr(int len){
        return getLenRandom(NUMSTR, len);
    }
    /**
     * 获取指定长度的小写字母随机数
     * @param len
     * @return
     */
    public static String getRandomLowerStr(int len){
        return getLenRandom(LOWER_STR, len);
    }
    /**
     * 获取指定长度的大写字母随机数
     * @param len
     * @return
     */
    public static String getRandomUpperStr(int len){
        return getLenRandom(UPPER_STR, len);
    }
    /**
     * 获取指定长度的数字和大写字母混合随机数
     * @param len
     * @return
     */
    public static String getRandomUpperAndNumStr(int len){
        return getLenRandom(NUM_UPPER_STR, len);
    }
    /**
     * 获取指定长度的数字和小写字母混合随机数
     * @param len
     * @return
     */
    public static String getRandomLowerAndNumStr(int len){
        return getLenRandom(NUM_LOWER_STR, len);
    }
    
    
    
    
    /**
     * 根据指定的基础字符串和指定长度返回指定长度的随机数
     * @param baseStr       基础字符串
     * @param len           指定长度
     * @return              生成后的随机数
     */
    public static String getLenRandom(String baseStr,int len){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(baseStr.charAt(r.nextInt(baseStr.length())));
        }
        return sb.toString();
    }
    
}
