/**    
* @author LIYANG  
* @date 2016年5月4日 下午3:06:57 
* @version V1.0   
*/
package cn.com.chenxin.service.fullInfo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import cn.com.chenxin.dao.DicAirportIpMapper;
import cn.com.chenxin.dao.JsAirportdataMapper;
import cn.com.chenxin.dao.JsXxjkMapper;
import cn.com.chenxin.model.DicAirportIp;
import cn.com.chenxin.model.JsAirportdata;
import cn.com.chenxin.model.JsXxjk;

/**
 * 
 * @author LIYANG
 *
 * @since 
 */
@Service
public class XxjkService {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(XxjkService.class);
    
    @Autowired
    private JsXxjkMapper xxjkMapper;
    @Autowired
    private JsAirportdataMapper jsAirportdataMapper;
    @Autowired
    private DicAirportIpMapper dicAirportIpMapper;
    
    /**
     * 根据手机号码和身份证号查询数据补全信息
     * @param sjhm      手机号码
     * @param gmsfhm    身份证号
     * @return
     */
    public List<JsXxjk> getXxjkInfoByCondition(String sjhm,String gmsfhm){
        LOGGER.info("根据公民身份号码和手机号码查询补全信息");
        Example example = new Example(JsXxjk.class);
        example.or().andEqualTo("sjhm", sjhm);
        example.or().andEqualTo("gmsfhm", gmsfhm);
        return this.xxjkMapper.selectByExample(example);
    }
    
    /**
     * 根据手机号码查询mac地址
     * @param sjhm
     * @return
     */
    public List<JsAirportdata> getMacByPhone(String sjhm) {
        LOGGER.info("根据手机号码查询mac地址");
        return this.jsAirportdataMapper.getMacBySjhm(sjhm);
    }
    
    /**
     * 根据身份号码查询mac地址
     * @param gmsfhm
     * @return
     */
    public List<JsAirportdata> getMacByIdCard(String gmsfhm) {
        LOGGER.info("根据公民身份号码查询mac地址");
        return this.jsAirportdataMapper.getMacByIdCard(gmsfhm);
    }

    /**
     * 根据mac地址获取手机号码、ip地址
     * @param mac
     * @return
     */
    public List<JsAirportdata> getPhoneByMac(List<Object> macList) {
        LOGGER.info("根据mac地址查询手机号码");
        Example example = new Example(JsAirportdata.class);
        example.or().andIn("mac", macList);
        return this.jsAirportdataMapper.selectByExample(example);
    }
    
    /**
     * 根据ip获取地址
     * @param ipList
     * @return
     */
    public List<DicAirportIp> getAddressByIp(List<Object> ipList) {
        LOGGER.info("根据ip获取地址");
        Example example = new Example(DicAirportIp.class);
        example.or().andIn("ipAddr", ipList);
        return this.dicAirportIpMapper.selectByExample(example);
    }
}
