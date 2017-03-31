package cn.com.chenxin.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.chenxin.model.JsSfhcXmSjhm;
import tk.mybatis.mapper.common.Mapper;

public interface JsSfhcXmSjhmMapper extends Mapper<JsSfhcXmSjhm> {
	
	public abstract Integer sfhcCxService2QueryXmSjhm(@Param("xm") String paramString1,@Param("sjhm") String paramString2);
	
	public abstract Integer sfhcCxService2QuerySjhm(@Param("sjhm") String paramString2);
	
}