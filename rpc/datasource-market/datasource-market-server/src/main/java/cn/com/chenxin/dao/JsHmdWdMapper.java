package cn.com.chenxin.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.chenxin.model.JsHmdWd;
import tk.mybatis.mapper.common.Mapper;

public interface JsHmdWdMapper extends Mapper<JsHmdWd> {
	
	public abstract Integer hmdCxService2queryWd(@Param("sjhm") String paramString1);
	public abstract Integer queryWd(@Param("xm") String paramString1, @Param("sjhm") String paramString2);
	public abstract Integer hmdCxService4queryWd(@Param("xm") String paramString1,@Param("gmsfhm") String paramString2);
	
}