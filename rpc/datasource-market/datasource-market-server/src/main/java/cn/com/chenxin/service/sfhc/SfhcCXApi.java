package cn.com.chenxin.service.sfhc;

import org.apache.thrift.TException;

import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.iface.DatasourceMarketSfhcThrift.Iface;
import cn.com.chenxin.utils.SpringInit;

public class SfhcCXApi implements Iface {

    @Override
    public String findSfhcByNameAndCode(LogInfo LogInfo, String params) throws TException {
        SfhcCxService sfhcCxService= (SfhcCxService) SpringInit.getApplicationContext().getBean("sfhcCxService");
        String str=sfhcCxService.findSfhcByNameAndCode(LogInfo, params);
        return  str;
    }
    
    @Override
    public String findSfhcByNameAndPhone(LogInfo LogInfo, String params)
            throws TException {
        SfhcCxService sfhcCxService= (SfhcCxService) SpringInit.getApplicationContext().getBean("sfhcCxService");
        String str=sfhcCxService.findSfhcByNameAndPhone(LogInfo, params);
        return  str;
    }
}
