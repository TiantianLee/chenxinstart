package cn.com.chenxin.service.food;

import org.apache.thrift.TException;

import cn.com.chenxin.iface.DatasourceMarketFoodThrift.Iface;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.utils.SpringInit;

public class FoodApi implements Iface {

    @Override
    public String findFoodScAndQs(LogInfo LogInfo, String params) throws TException {
        FoodProductService  service = (FoodProductService) SpringInit.getApplicationContext().getBean("foodProductService");
       String result = service.findFoodProduct(LogInfo, params);
        return result;
    }

    @Override
    public String findFoodAddLic(LogInfo LogInfo, String params) throws TException {
        FoodProductService  service = (FoodProductService) SpringInit.getApplicationContext().getBean("foodProductService");
        String result = service.findAddLic(LogInfo, params);
        return result;
    }

	@Override
    public String findLikeCompany(LogInfo LogInfo, String params) throws TException {
        FoodProductService  service = (FoodProductService) SpringInit.getApplicationContext().getBean("foodProductService");
        String result = service.findLikeCompany(LogInfo, params);
        return result;
	
    }

}
