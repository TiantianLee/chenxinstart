package cn.com.chenxin.service.gs;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import cn.com.chenxin.dao.GS.MortGuaranteeInfoMapper;
import cn.com.chenxin.dao.GS.MortPersonInfoMapper;
import cn.com.chenxin.dao.GS.MortPrincipalClaimMapper;
import cn.com.chenxin.dao.GS.MortRegInfoMapper;
import cn.com.chenxin.model.GS.MortGuaranteeInfo;
import cn.com.chenxin.model.GS.MortPersonInfo;
import cn.com.chenxin.model.GS.MortPrincipalClaim;
import cn.com.chenxin.model.GS.MortRegInfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 动产抵押物信息Service
 * 
 * 动产抵押 MORT_GUARANTEE_INFO; 抵押登记信息 MORT_REG_INFO; 担保范围信息 MORT_PRINCIPAL_CLAIM;
 * 抵押人信息 MORT_PERSON_INFO;
 * 
 */
@Service
public class ChattelMortgageService {
	/**
	 * 抵押人信息
	 */
	@Autowired
	private MortPersonInfoMapper personInfoMapper;
	/**
	 * 动产抵押
	 */
	@Autowired
	private MortGuaranteeInfoMapper guaranteeInfoMapper;
	/**
	 * 担保范围信息
	 */
	@Autowired
	private MortPrincipalClaimMapper principalClaimMapper;
	/**
	 * 抵押登记信息
	 */
	@Autowired
	private MortRegInfoMapper regInfoMapper;

	public JSONObject getChattelMortgage(String pripid) {
		JSONObject resultJson = new JSONObject();
		 resultJson = this.getPersonInfo(pripid, resultJson);
		 resultJson = this.getGuaranteeInfo(resultJson);
		 resultJson = this.getPrincipalClaim(resultJson);
		 resultJson = this.getRegInfo(resultJson);
		return resultJson;
	}

	/**
	 * 
	 * 抵押登记信息 通过 morregId 返回数据库所有字段
	 * 
	 * @param resultJson
	 * @return
	 */
	public JSONObject getRegInfo(JSONObject resultJson) {
		JSONArray array = resultJson.getJSONArray("personInfo");
		JSONArray infoArray = new JSONArray();
		for (Object object : array) {
			JSONObject json = (JSONObject) object;
			String morregId = json.getString("morregId");
			if (StringUtils.isNotBlank(morregId)) {
				Example example = new Example(MortRegInfo.class);
				example.or().andEqualTo("morregId", morregId);
				List<MortRegInfo> list = regInfoMapper.selectByExample(example);
				if (list != null && !list.isEmpty()) {
					for (MortRegInfo mortRegInfo : list) {
						JSONObject jsonObject = new JSONObject();
						jsonObject = (JSONObject) JSONObject.toJSON(mortRegInfo);
						infoArray.add(jsonObject);
					}
				}
			}
		}
		resultJson.put("regInfo", infoArray);
		return resultJson;

	}

	/**
	 * 
	 * 担保范围信息 通过 morregId 返回数据库所有字段
	 * 
	 * @param resultJson
	 * @return
	 */
	public JSONObject getPrincipalClaim(JSONObject resultJson) {
		JSONArray array = resultJson.getJSONArray("personInfo");
		JSONArray infoArray = new JSONArray();
		for (Object object : array) {
			JSONObject json = (JSONObject) object;
			String morregId = json.getString("morregId");
			if (StringUtils.isNotBlank(morregId)) {
				Example example = new Example(MortPrincipalClaim.class);
				example.or().andEqualTo("morregId", morregId);
				List<MortPrincipalClaim> list = principalClaimMapper.selectByExample(example);
				if (list != null && !list.isEmpty()) {
					for (MortPrincipalClaim mortPrincipalClaim : list) {
						JSONObject jsonObject = new JSONObject();
						jsonObject = (JSONObject) JSONObject.toJSON(mortPrincipalClaim);
						infoArray.add(jsonObject);
					}
				}
			}
		}

		resultJson.put("principalClaim", infoArray);
		return resultJson;

	}

	/**
	 * 
	 * 动产抵押 通过 morregId 返回数据库所有字段
	 * 
	 * @param resultJson
	 * @return
	 */
	public JSONObject getGuaranteeInfo(JSONObject resultJson) {
		JSONArray array = resultJson.getJSONArray("personInfo");
		JSONArray GuaranteeInfoArray = new JSONArray();
		for (Object object : array) {
			JSONObject json = (JSONObject) object;
			String morregId = json.getString("morregId");
			if (StringUtils.isNotBlank(morregId)) {
				Example example = new Example(MortGuaranteeInfo.class);
				example.or().andEqualTo("morregId", morregId);
				List<MortGuaranteeInfo> list = guaranteeInfoMapper.selectByExample(example);
				if (list != null && !list.isEmpty()) {
					for (MortGuaranteeInfo mortGuaranteeInfo : list) {
						JSONObject jsonObject = new JSONObject();
						jsonObject = (JSONObject) JSONObject.toJSON(mortGuaranteeInfo);
						GuaranteeInfoArray.add(jsonObject);
					}
				}
			}
		}
		resultJson.put("guaranteeInfo", GuaranteeInfoArray);
		return resultJson;

	}

	/**
	 * 抵押人信息 获取 morregId
	 * 
	 * @param pripid
	 * @param resultJson
	 * @return
	 */
	public JSONObject getPersonInfo(String pripid, JSONObject resultJson) {
		pripid = pripid.trim();
		JSONArray array = new JSONArray();

		if (StringUtils.isNotBlank(pripid)) {
			Example example = new Example(MortPersonInfo.class);
			example.or().andEqualTo("pripid", pripid);
			List<MortPersonInfo> list = personInfoMapper.selectByExample(example);
			if (list != null && !list.isEmpty()) {
				for (MortPersonInfo mortPersonInfo : list) {
					JSONObject jsonObject = new JSONObject();
					jsonObject = (JSONObject) JSONObject.toJSON(mortPersonInfo);
					array.add(jsonObject);
				}
			}

		}
		resultJson.put("personInfo", array);
		return resultJson;

	}

}
