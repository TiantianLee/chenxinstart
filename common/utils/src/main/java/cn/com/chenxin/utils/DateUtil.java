package cn.com.chenxin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 根据自定义格式返回日期格式化器
     * 
     * @param pattern
     * @return
     */
    public static SimpleDateFormat getSdf(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 获取当前月份
     * 
     * @return
     */
    public static String getCurrentMonth() {
        return getSdf("yyyyMM").format(new Date());
    }
    
    /**
     * 获取当前月份
     * @param pattern 日期格式
     * @return
     */
    public static String getCurrentMonth(String pattern) {
        return getSdf(pattern).format(new Date());
    }

    /**
     * 获取当前日期
     * 
     * @return
     */
    public static String getCurrentDate() {
        return getSdf("yyyyMMdd").format(new Date());
    }
    
    /**
     * 获取当前日期
     * @param pattern 日期格式
     * @return
     */
    public static String getCurrentDate(String pattern) {
        return getSdf(pattern).format(new Date());
    }

    /**
     * 计算月份加减
     * 
     * @param source
     * @param i
     * @return
     */
    public static String addMonth(String source, int i) {
        Calendar calendar;
        try {
            calendar = Calendar.getInstance();
            calendar.setTime(getSdf("yyyyMM").parse(source));
            calendar.add(Calendar.MONTH, i);
        } catch (ParseException e) {
            return "";
        }
        return getSdf("yyyyMM").format(calendar.getTime());
    }

    /**
     * 计算日期加减
     * 
     * @param source
     *            日期字符串
     * @param i
     *            加减天数
     * @return
     */
    public static String addDay(String source, int i) {
        Calendar calendar;
        try {
            calendar = Calendar.getInstance();
            calendar.setTime(getSdf("yyyyMMdd").parse(source));
            calendar.add(Calendar.DAY_OF_MONTH, i);
        } catch (ParseException e) {
            return "";
        }
        return getSdf("yyyyMMdd").format(calendar.getTime());
    }
    
    /**
     * 计算日期加减
     * 
     * @param source
     *            日期字符串
     * @param i
     *            加减天数
     * @param pattern 日期格式
     * @return
     */
    public static String addDay(String source, int i,String pattern) {
        Calendar calendar;
        try {
            calendar = Calendar.getInstance();
            calendar.setTime(getSdf(pattern).parse(source));
            calendar.add(Calendar.DAY_OF_MONTH, i);
        } catch (ParseException e) {
            return "";
        }
        return getSdf(pattern).format(calendar.getTime());
    }

    /**
     * 转换字符串日期格式
     * 
     * @param sourcePattern
     *            原始格式
     * @param targetPattern
     *            目标格式
     * @param dateStr
     *            日期字符串
     * @return
     * @throws ParseException
     */
    public static String convertStrDateFormat(String sourcePattern,
            String targetPattern, String dateStr) throws ParseException {
        return getSdf(targetPattern).format(
                getSdf(sourcePattern).parse(dateStr));
    }
    
    /**
     * 处理特殊日期格式  2015-06-09T00:00:00+08:00
     * @param complexDateStr
     * @return
     */
    public static String getComplexDate(String complexDateStr){
    	return complexDateStr.split("T")[0];
    }

}
