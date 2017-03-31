package cn.com.chenxin.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.chenxin.model.WgGrEny;
import tk.mybatis.mapper.common.Mapper;

public interface WgGrEnyMapper extends Mapper<WgGrEny> {
    public abstract WgGrEny findByXmGmsfhm(@Param("xm") String paramString1,@Param("gmsfhm") String paramString2);
}