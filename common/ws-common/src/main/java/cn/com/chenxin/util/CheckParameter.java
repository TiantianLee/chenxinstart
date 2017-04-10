package cn.com.chenxin.util;

import java.text.ParseException;

import com.alibaba.fastjson.JSONObject;

public class CheckParameter {

    public static JSONObject checkPara(JSONObject params) throws ParseException {
        JSONObject obj = new JSONObject();
        boolean flag = false;
        String productpara = params.getString("productpara");
        String[] paraFormat = productpara.split("\\+");
        for (int i = 0; i < paraFormat.length; i++) {
            String format = paraFormat[i];
            System.out.println(format);
            switch (format) {
            case "xm":
                String xm = params.getString("xm");
                if (!RegularUtil.isChineseName(xm)) {
                    obj.put("flag", flag);
                    obj.put("msg", "姓名校验未通过");
                    return obj;
                }
                break;
            case "gmsfhm":
                String gmsfhm = params.getString("gmsfhm");
                if (!RegularUtil.isCard(gmsfhm)) {
                    obj.put("flag", flag);
                    obj.put("msg", "身份证校验未通过");
                    return obj;
                }
                break;
            case "sjh":
                String sjhm = params.getString("sjhm");
                if (!RegularUtil.isMobileNO(sjhm)) {
                    obj.put("flag", flag);
                    obj.put("msg", "手机号码校验未通过");
                    return obj;
                }
                break;
            }
        }
        flag = true;
        obj.put("flag", flag);
        return obj;
    }

    public static void main(String[] args) throws ParseException {
//        String temp = "{'xm':'张明鹿','gmsfhm':'110222198211302414','productpara':'xm+gmsfhm'}";
//        JSONObject params = JSONObject.parseObject(temp);
//        System.out.println(checkPara(params));
        System.out.println(RegularUtil.isChineseName("道日斯嘎拉"));
        System.out.println(RegularUtil.isCard("152523198505041573"));
        System.out.println(RegularUtil.isMobileNO("15147948450"));
    }

}
