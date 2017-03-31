package cn.com.chenxin.dao;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import cn.com.chenxin.model.JsHmdGrsxTmp;

public interface JsHmdGrsxTmpMapper extends Mapper<JsHmdGrsxTmp> {
    
//    public abstract Integer hmdCxService1queryGrsx(@Param("gmsfhm") String paramString1);
    public abstract JsHmdGrsxTmp hmdCxService4queryGrsx(@Param("xm") String paramString1,@Param("gmsfhm") String paramString2);
}