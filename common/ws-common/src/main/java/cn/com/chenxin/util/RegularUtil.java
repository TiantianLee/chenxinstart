package cn.com.chenxin.util;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.math.NumberUtils;

public class RegularUtil {

	//2-5位汉字中文名的正则校验
	public static boolean isChineseName(String xm) {
		Pattern p = Pattern.compile("[\u4E00-\u9FA5]{2,10}(?:·[\u4E00-\u9FA5]{2,10})*");
		Matcher m = p.matcher(xm);
		return m.matches();
    }
	
	//身份号码校验
	public static boolean isCard(String gmsfhm) throws ParseException {
		boolean flag = false;
		CheckUserCardNo checkUserCardNo = new CheckUserCardNo();
		String checkStr = checkUserCardNo.IDCardValidate(gmsfhm);
		if("该身份证有效！".equals(checkStr)) {
			flag = true;
		}
		return flag;
	}
	
	public static void main(String[] args) {
        try {
            if(isCard("140603199212071630")) {
                System.out.println("111");
            } else {
                System.out.println("22");
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	//手机号正则校验
	public static boolean isMobileNO(String sjhm){
		boolean flag = sjhm.startsWith("1");
		if(!flag) {
			return false;
		}
		boolean flag1 = NumberUtils.isDigits(sjhm);
		if(!flag1) {
			return false;
		}
		if(sjhm.length() != 11) {
			return false;
		}
		return true;
	}
	
	//银行卡正则校验
	public static boolean isBankCard(String yhk) {
		Pattern p = Pattern.compile("[0-9]{1,19}");
		Matcher m = p.matcher(yhk);
		return m.matches();
	}
	
	//监控周期
	public static boolean isJkzq(String jkzq) {
		if(jkzq.length()<=3) {
			return true;
		} else {
			return false;
		}
	}
	
	//监控器
	public static boolean isJkq(int jkq) {
		if(jkq >=0 && jkq < 10000) {
			return true;
		} else {
			return false;
		}
	}
	
	//监控周期的值不能大于监控期限的值
	public static boolean isGreater(String jkzq,int jkq) {
		int jkzqTemp = Integer.parseInt(jkzq);
		if(jkzqTemp <= jkq) {
			return true;
		} else {
			return false;
		}
	}
	
}
