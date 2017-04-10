package cn.com.chenxin.utils;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 获取产品转发的层级
 * @author Administrator
 *
 */
public class ProductLevelUtil {
    
    /**
     * 获取产品转发的层级
     * @param params
     * @return
     */
    public static int getParentLevel(JSONObject params){
        String level = params.getString("forwardLevel");
        Integer forwardLevel = 0;
        if(StringUtils.isNotBlank(level)){
            forwardLevel = Integer.parseInt(level);
        }
        return forwardLevel;
    }

}
