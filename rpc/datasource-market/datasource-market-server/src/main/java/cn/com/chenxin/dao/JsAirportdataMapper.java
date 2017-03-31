package cn.com.chenxin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import cn.com.chenxin.model.JsAirportdata;

public interface JsAirportdataMapper extends Mapper<JsAirportdata> {
    
    public abstract List<JsAirportdata> getMacBySjhm(@Param("sjhm") String sjhm);

    public abstract List<JsAirportdata> getMacByIdCard(@Param("gmsfhm") String gmsfhm);
}