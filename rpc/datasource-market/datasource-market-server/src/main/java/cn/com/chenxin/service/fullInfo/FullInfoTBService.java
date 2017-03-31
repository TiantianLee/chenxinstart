package cn.com.chenxin.service.fullInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import cn.com.chenxin.dao.ExpTbMapper;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.model.ExpTb;
import cn.com.chenxin.utils.DES_Encrypt;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
public class FullInfoTBService {
	private static final Logger LOGGER = Logger
			.getLogger(FullInfoTBService.class);
	private String key = "ccsp!@#$";
	@Autowired
	private ExpTbMapper expTbMapper;

	public JSONObject getFullInfoC(LogInfo LogInfo, String userCode, String xm,
			String sjhm, String gmsfhm) {

		JSONObject jo = new JSONObject();
		List<ExpTb> list = new ArrayList<ExpTb>();
		// LOGGER.info("【数据补全C】参数");

			LOGGER.info("【数据补全C】参数xm=" + xm + "sjhm=" + sjhm + "gmsfhm=" + gmsfhm);
			Example example = new Example(ExpTb.class);

		
				example.or().andEqualTo("sjhm", sjhm);

		
			list = this.expTbMapper.selectByExample(example);
		
		if (list.isEmpty()) {
			LOGGER.info("【数据补全C】查询无数据");
			jo.put("resultCode", "0");
		} else {
			LOGGER.info("【数据补全C】第一次查询获得数据");
			JSONArray rList = new JSONArray();
			List<ExpTb>rList1=new ArrayList<ExpTb>();
			for (ExpTb expTb : list) {
				Example ex=new Example(ExpTb.class);
				String xm1="";
				if(StringUtils.isNotBlank( expTb.getXm())){
					xm=expTb.getXm().substring(0, 1);
				}
				ex.or().andLike("xm", "%"+xm1+"%").andEqualTo("dq", expTb.getDq()).andEqualTo("cs", expTb.getCs()).andEqualTo("sf", expTb.getSf());

				rList1=this.expTbMapper.selectByExample(ex);
				
			}
			rList1.addAll(list);
			//去重
			 List<ExpTb> tempList= new ArrayList<ExpTb>();  
			    for(ExpTb i:list){  
			        if(!tempList.contains(i)){  
			            tempList.add(i);  
			        }  
			    }  
			
			//返回加密    
			for (ExpTb expTb : tempList) {
				Example ex=new Example(ExpTb.class);
				ex.or().andEqualTo("sjhm", expTb.getSjhm()).andEqualTo("dq", expTb.getDq()).andEqualTo("cs", expTb.getCs()).andEqualTo("sf", expTb.getSf());
				expTb.setName(xm);
				expTb.setGmsfhm(gmsfhm);
				this.expTbMapper.updateByExampleSelective(expTb, ex);
				ExpTb expTb1 = new ExpTb();
				
				
				expTb1.setCs(translateCodeToUserBySource(expTb.getCs(),
						userCode));
				expTb1.setDz(translateCodeToUserBySource(expTb.getDz(),
						userCode));
				expTb1.setSf(translateCodeToUserBySource(expTb.getSf(),
						userCode));
				expTb1.setDq(translateCodeToUserBySource(expTb.getDq(),
						userCode));
				try {
					expTb1.setSjhm(DES_Encrypt.encrypt(DES_Encrypt.decrypt(expTb.getSjhm(),
							key),userCode));
					expTb1.setDhhm(DES_Encrypt.encrypt(DES_Encrypt.decrypt(expTb.getDhhm(),
							key),userCode));
					expTb1.setXm(DES_Encrypt.encrypt(DES_Encrypt.decrypt(expTb.getXm(),
							key),userCode));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				rList.add(expTb1);
			}
			jo.put("resultCode", "3");
			jo.put("data", rList);
		}

		return jo;
	}

	/**
	 * 加密映射，将数据用用户信息加密
	 * 
	 * @param source
	 *            源数据
	 * @param userCode
	 *            用户Code
	 * @return
	 */
	public String translateCodeToUserBySource(String source, String userCode) {
		try {
			if (userCode.length() > 8) {
				return DES_Encrypt.encrypt(source, userCode);
			} else {
				for (int i = 0; i < 8; i++) {
					userCode += userCode;
				}
				userCode = userCode.substring(0, 8);
				return DES_Encrypt.encrypt(source, userCode);
			}
		} catch (IOException e) {
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 加密映射，将数据库加密数据转换为用户加密数据
	 * 
	 * @param data
	 *            源加密数据
	 * @param userCode
	 *            用户Code
	 * @return
	 */
	public String translateCodeToUser(String data, String userCode) {
		try {
			String source = DES_Encrypt.decrypt(data, key);
			if (userCode.length() > 8) {
				return DES_Encrypt.encrypt(source, userCode);
			} else {
				for (int i = 0; i < 8; i++) {
					userCode += userCode;
				}
				userCode = userCode.substring(0, 8);
				return DES_Encrypt.encrypt(source, userCode);
			}
		} catch (IOException e) {
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 加密映射，将用户加密数据转换为数据库加密数据
	 * 
	 * @param data
	 *            源加密数据
	 * @param userCode
	 *            用户Code
	 * @return
	 */
	public String translateCodeToDb(String data, String userCode) {
		try {
			String source;
			if (userCode.length() > 8) {
				source = DES_Encrypt.decrypt(data, userCode);
			} else {
				for (int i = 0; i < 8; i++) {
					userCode += userCode;
				}
				userCode = userCode.substring(0, 8);
				source = DES_Encrypt.decrypt(data, userCode);
			}

			return DES_Encrypt.encrypt(source, key);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
public static void main(String[] args) {
	try {
		System.out.println(DES_Encrypt.decrypt("kVYBKGDMVDk=", "administrator"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String a="administrator".substring(0,8);
	System.out.println(a);
}
}
