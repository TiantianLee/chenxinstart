package cn.com.chenxin.service.gs;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import cn.com.chenxin.dao.GS.ELiquidationMapper;
import cn.com.chenxin.dao.GS.ESharesFrostMapper;
import cn.com.chenxin.dao.GS.ESharesImpawnMapper;
import cn.com.chenxin.dao.GS.ESharesTransferMapper;
import cn.com.chenxin.model.GS.ELiquidation;
import cn.com.chenxin.model.GS.ESharesFrost;
import cn.com.chenxin.model.GS.ESharesImpawn;
import cn.com.chenxin.model.GS.ESharesTransfer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 企业投资信息 Service 企业变更信息
 * 
 * 股权冻结 E_SHARES_FROST; 
 * 股权质押 E_SHARES_IMPAWN; 
 * 股权转让 E_SHARES_TRANSFER; 
 * 清算整理
 * E_LIQUIDATION;
 * 
 * @author caoq
 * 
 *
 */
@Service
public class CorporateInvestmentService {
	@Autowired
	private ESharesFrostMapper frostMapper;
	@Autowired
	private ESharesImpawnMapper impawnMapper;
	@Autowired
	private ESharesTransferMapper transferMapper;
	@Autowired
	private ELiquidationMapper liquidationMapper;
	
	public JSONObject getCorporateInvestment(String pripid) {
		JSONObject resultJson = new JSONObject();
		if (StringUtils.isNotBlank(pripid.trim())) {
			resultJson = this.getLiquidation(pripid, resultJson);
			resultJson = this.getFrost(pripid, resultJson);
			resultJson = this.getImpawn(pripid, resultJson);
			resultJson = this.getTransfer(pripid, resultJson);
        }
		return resultJson;
	    
    }

	/**
	 * 
	 *清算整理
	 * @param pripid
	 * @param resultJson
	 * @return
	 */
	public JSONObject getLiquidation(String pripid,JSONObject resultJson) {
		JSONArray array = new JSONArray();
		 
		Example example = new Example(ELiquidation.class);
		example.or().andEqualTo("pripid", pripid);
		List<ELiquidation> list = liquidationMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			for (ELiquidation eliquidation : list) {
				JSONObject json = (JSONObject) JSONObject.toJSON(eliquidation);
				array.add(json);
			}
	        
        }
		resultJson.put("liquidation", array);
		return resultJson;
	   
    }
	
	
	
	/**
	 * 
	 *股权转让
	 * @param pripid
	 * @param resultJson
	 * @return
	 */
	public JSONObject getTransfer(String pripid,JSONObject resultJson) {
		JSONArray array = new JSONArray();
		 
		Example example = new Example(ESharesTransfer.class);
		example.or().andEqualTo("pripid", pripid);
		List<ESharesTransfer> list = transferMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			for (ESharesTransfer esharesTransfer : list) {
				String tranam = this.delNumber(esharesTransfer.getTranam());
				String tranampr = this.delNumber(esharesTransfer.getTranampr())+"%";
				String trantype = esharesTransfer.getTrantype().replace("!", "--");
				esharesTransfer.setTrantype(trantype);
				
				esharesTransfer.setTranam(tranam);
				esharesTransfer.setTranampr(tranampr);
				JSONObject json = (JSONObject) JSONObject.toJSON(esharesTransfer);
				array.add(json);
			}
	        
        }
		resultJson.put("transfer", array);
		return resultJson;
	   
    }

	/**
	 * 
	 *股权质押
	 * @param pripid
	 * @param resultJson
	 * @return
	 */
	public JSONObject getImpawn(String pripid,JSONObject resultJson) {
		JSONArray array = new JSONArray();
		 
		Example example = new Example(ESharesImpawn.class);
		example.or().andEqualTo("pripid", pripid);
		List<ESharesImpawn> list = impawnMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			for (ESharesImpawn esharesImpawn : list) {
				String impam = this.delNumber(esharesImpawn.getImpam());
				esharesImpawn.setImpam(impam);
				JSONObject json = (JSONObject) JSONObject.toJSON(esharesImpawn);
				array.add(json);
			}
	        
        }
		resultJson.put("impawn", array);
		return resultJson;
	   
    }
	
	
	
	
	/**
	 * 
	 * 股权冻结 
	 * @param pripid
	 * @param resultJson
	 * @return
	 */
	public JSONObject getFrost(String pripid,JSONObject resultJson) {
		JSONArray array = new JSONArray();
		 
		Example example = new Example(ESharesFrost.class);
		example.or().andEqualTo("pripid", pripid);
		List<ESharesFrost> list = frostMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			for (ESharesFrost eSharesFrost : list) {
			 
				String	froam = this.delNumber(eSharesFrost.getFroam());
				String	sharfroprop = this.delNumber(eSharesFrost.getSharfroprop())+"%";
				eSharesFrost.setFroam(froam);
				eSharesFrost.setSharfroprop(sharfroprop);
				JSONObject json = (JSONObject) JSONObject.toJSON(eSharesFrost);
				
				array.add(json);
			}
	        
        }
		resultJson.put("frost", array);
		return resultJson;
	   
    }
	public  String delNumber(String string) {
		string = string.replace("+", "");
		Float aaaFloat = Float.valueOf(string);
		string = String.valueOf(aaaFloat);
		return string;
	    
    }
	
}
