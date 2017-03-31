package cn.com.chenxin.service.JtBank;

import org.apache.thrift.TException;

import cn.com.chenxin.iface.DatasourceMarketJtBankThrift.Iface;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.service.JtBank.car.CarSearchService;
import cn.com.chenxin.service.JtBank.hg.CustomsDataService;
import cn.com.chenxin.service.JtBank.house.HouseSerchService;
import cn.com.chenxin.utils.SpringInit;

import com.alibaba.fastjson.JSONObject;


/**
 * 交通银行需求数据
 * @author caoq
 *
 */
public class JtBankServiceApi implements Iface {
	
	@Override
    public String findJtBankHg(LogInfo LogInfo, String params) throws TException {
		CustomsDataService customsDataService = (CustomsDataService) SpringInit.getApplicationContext().getBean("customsDataService");
	   JSONObject jsonObject =  customsDataService.findJtBankHG(LogInfo, params);
		return jsonObject.toJSONString();
    }

	@Override
    public String findJtBankCar(LogInfo LogInfo, String params) throws TException {
	    CarSearchService carSearchService = (CarSearchService) SpringInit.getApplicationContext().getBean("carSearchService");
	    JSONObject jsonObject = carSearchService.findJtBankCar(LogInfo, params);
	    return jsonObject.toJSONString();
    }

	@Override
    public String findJtBankFz(LogInfo LogInfo, String params) throws TException {
	   HouseSerchService houseSerchService = (HouseSerchService) SpringInit.getApplicationContext().getBean("houseSerchService");
	    JSONObject jsonObject  = houseSerchService.findJtBankHouse(LogInfo, params);
	   return jsonObject.toJSONString();
    }

	
}
