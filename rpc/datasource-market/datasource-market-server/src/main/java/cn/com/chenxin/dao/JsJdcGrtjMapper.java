package cn.com.chenxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.chenxin.model.JsJdcGrtj;
import tk.mybatis.mapper.common.Mapper;

public interface JsJdcGrtjMapper extends Mapper<JsJdcGrtj> {
    public List<JsJdcGrtj> carXmGmsfhm(@Param(value = "gmsfhm") String gmsfhm,@Param(value = "xm") String xm);
}