package cn.com.chenxin.dao;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import cn.com.chenxin.model.JsHmdGrsxX;

public interface JsHmdGrsxXMapper extends Mapper<JsHmdGrsxX> {
	
	public abstract Integer queryGrsxX(@Param("xm") String paramString);
	public abstract Integer hmdCxService4queryGrsxX(@Param("xm") String paramString1,@Param("gmsfhm") String paramString2);
	
}