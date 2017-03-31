package cn.com.chenxin.dao;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import cn.com.chenxin.model.JsHmdGrsxXTmp;

public interface JsHmdGrsxXTmpMapper extends Mapper<JsHmdGrsxXTmp> {
    
//    public abstract Integer hmdCxService1queryGrsxX(@Param("gmsfhm") String paramString1);
    public abstract JsHmdGrsxXTmp hmdCxService4queryGrsxX(@Param("xm") String paramString1,@Param("gmsfhm") String paramString2);
}