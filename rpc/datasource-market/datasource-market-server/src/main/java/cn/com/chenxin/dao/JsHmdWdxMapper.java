package cn.com.chenxin.dao;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import cn.com.chenxin.model.JsHmdWdx;

public interface JsHmdWdxMapper extends Mapper<JsHmdWdx> {
    
//    public abstract Integer hmdCxService1queryWd(@Param("gmsfhm") String paramString1);
//    public abstract Integer hmdCxService2queryWd(@Param("sjhm") String paramString1);
    public abstract JsHmdWdx queryWd(@Param("xm") String paramString1, @Param("sjhm") String paramString2);
    public abstract JsHmdWdx hmdCxService4queryWd(@Param("xm") String paramString1,@Param("gmsfhm") String paramString2);
}