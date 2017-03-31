package cn.com.chenxin.dao;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import cn.com.chenxin.model.JsHmdGrsx;

public interface JsHmdGrsxMapper extends Mapper<JsHmdGrsx> {
	
	public abstract Integer queryGrsx(@Param("xm") String paramString);
	public abstract Integer hmdCxService4queryGrsx(@Param("xm") String paramString1,@Param("gmsfhm") String paramString2);

}