package cn.com.chenxin.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.chenxin.model.JsSfhcXmGmsfhm;
import tk.mybatis.mapper.common.Mapper;

public interface JsSfhcXmGmsfhmMapper extends Mapper<JsSfhcXmGmsfhm> {
	
	public abstract Integer sfhcCxService1QueryXmGmsfhm(@Param("xm") String paramString1,@Param("gmsfhm") String paramString2);
	
	public abstract Integer sfhcCxService1QueryGmsfhm(@Param("gmsfhm") String paramString2);

}