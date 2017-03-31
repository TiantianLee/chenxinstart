package cn.com.chenxin.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import cn.com.chenxin.dao.JsQyzxJyycMapper;
import cn.com.chenxin.model.JsQyzxJyyc;

/**
 * 经营异常
 * 
 * @author tiantian
 * @since 0.0.2-SNAPSHOT
 */
@Service
public class JyycService {
   /**
    * logger
    */
    private static final Logger LOGGER = Logger.getLogger(JyycService.class);

    /**
     * 经营异常mapper
     */
    @Autowired
    private JsQyzxJyycMapper jqjm;

    /**
     * 
     * 经营异常
     * 
     * @param gshm 工商号码
     * @return list
     */

    public List<JsQyzxJyyc> queryjyyc(String gshm) {
        LOGGER.info("调用宸信经营异常接口：" + gshm);
        Example example = new Example(JsQyzxJyyc.class);
        example.or().andEqualTo("yyzzzch", gshm);
        List<JsQyzxJyyc> list = this.jqjm.selectByExample(example);
        LOGGER.info("在宸信查询得到经营异常 " + list.size() + " 条");
        return list;
    }

}
