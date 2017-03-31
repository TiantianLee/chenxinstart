package cn.com.chenxin.service.food;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import cn.com.chenxin.dao.ZxFoodAddLicMapper;
import cn.com.chenxin.dao.ZxFoodDrugFoodproductCsMapper;
import cn.com.chenxin.dao.ZxFoodDrugFoodproductQsMapper;
import cn.com.chenxin.iface.LogInfo;
import cn.com.chenxin.model.ZxFoodAddLic;
import cn.com.chenxin.model.ZxFoodDrugFoodproductCs;
import cn.com.chenxin.model.ZxFoodDrugFoodproductQs;
import cn.com.chenxin.pool.threadpool.ThreadPool;
import cn.com.chenxin.util.SendProductLogTask;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
public class FoodProductService {
	@Autowired
	private ZxFoodDrugFoodproductCsMapper csMapper;

	@Autowired
	private ZxFoodDrugFoodproductQsMapper qsMapper;

	@Autowired
	private ZxFoodAddLicMapper addLicMapper;

	private String isSuccess = "1";
	/**
	 * logger this class
	 */
	private static final Logger LOGGER = Logger.getLogger(FoodProductService.class);

	/**
	 * @Title: findFoodProduct
	 * @Description: 查询食品生产许可证
	 * @param @param LogInfo
	 * @param @param params
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String findFoodProduct(LogInfo LogInfo, String params) {
		JSONObject resultJson = new JSONObject();
		JSONObject obj = new JSONObject();
		JSONObject jsonParams = JSON.parseObject(params);
		String vcName = jsonParams.getString("company").trim(); // 获取公司名称

		ZxFoodDrugFoodproductCs foodproductCs = new ZxFoodDrugFoodproductCs();
		foodproductCs.setVcName(vcName);

		List<ZxFoodDrugFoodproductCs> csList = new ArrayList<ZxFoodDrugFoodproductCs>();
		List<ZxFoodDrugFoodproductQs> qsList = new ArrayList<ZxFoodDrugFoodproductQs>();
		try {
			csList = csMapper.select(foodproductCs);
		} catch (Exception e1) {
			isSuccess = "0";
		}
		if (csList != null && !csList.isEmpty()) {
			for (ZxFoodDrugFoodproductCs cs : csList) {
				resultJson.put("vcName", cs.getVcName()); // 企业名称
				resultJson.put("vcFadingren", cs.getVcFadingren()); // 法定代表人
				resultJson.put("vcFoodclass", cs.getVcFoodclass()); // 生产食品名称（类别）
				resultJson.put("vcJainyanfangshi", ""); // 检验方式
				resultJson.put("vcAllowcaode", cs.getVcAllowcaode()); // 许可证编号
				resultJson.put("vcOffice", cs.getVcOffice()); // 发证单位
				resultJson.put("vcStarttime", cs.getVcStarttime()); // 发证日期
				resultJson.put("vcEndtime", cs.getVcEndtime()); // 证书有效期
				resultJson.put("vcPeoductaddress", cs.getVcPeoductaddress()); // 生产地址
				resultJson.put("vcMingxi", cs.getVcMingxi()); // 详情
				// resultJson = (JSONObject) JSONObject.toJSON(cs);
				LOGGER.info("食品安全 cs表 返回数据 :" + resultJson);
			}
		} else {
			ZxFoodDrugFoodproductQs foodproductQs = new ZxFoodDrugFoodproductQs();
			foodproductQs.setVcName(vcName);
			
			try {
				qsList = qsMapper.select(foodproductQs);
			} catch (Exception e) {
				isSuccess = "0";
			}
			if (qsList != null && !qsList.isEmpty()) {
				for (ZxFoodDrugFoodproductQs qs : qsList) {
					resultJson.put("vcName", qs.getVcName()); // 企业名称
					resultJson.put("vcFadingren", ""); // 法定代表人
					resultJson.put("vcFoodclass", qs.getVcProducter()); // 生产食品名称（类别）
					resultJson.put("vcJainyanfangshi", qs.getVcJainyanfangshi()); // 检验方式
					resultJson.put("vcAllowcaode", qs.getVcCode()); // 许可证编号
					resultJson.put("vcOffice", qs.getVcOffice()); // 发证单位
					resultJson.put("vcStarttime", qs.getVcStarttime()); // 发证日期
					resultJson.put("vcEndtime", qs.getVcEndtime()); // 证书有效期
					resultJson.put("vcPeoductaddress", qs.getVcPeoductaddress()); // 生产地址
					resultJson.put("vcMingxi", ""); // 详情
					// resultJson = (JSONObject) JSONObject.toJSON(qs);
					LOGGER.info("食品安全 qs表 返回数据 :" + resultJson);
				}
			}

		}
		
		obj.put("reasonCode", "");
		obj.put("resultCode", "");
		obj.put("data", resultJson);
		// 添加日志
		String id = UUID.randomUUID().toString();
		String productcode = System.getProperty("food_product");
		// 结果 来源
		String datasource = "1";
		SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
		        obj.toString(), isSuccess);
		ThreadPool.submitTask(sendProductLogTask);
		return obj.toJSONString();

	}

	/**
	 * @Title: findAddLic
	 * @Description:      查询食品添加剂
	 * @param @param LogInfo
	 * @param @param params
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String findAddLic(LogInfo LogInfo, String params) {
		JSONObject resultJson = new JSONObject();
		JSONObject obj = new JSONObject();
		JSONObject jsonParams = JSON.parseObject(params);
		String vcName = jsonParams.getString("company").trim(); // 获取公司名称

		ZxFoodAddLic addLic = new ZxFoodAddLic();
		addLic.setVcCompanyName(vcName);
		List<ZxFoodAddLic> addliclist = new ArrayList<ZxFoodAddLic>();
		try {
			addliclist = addLicMapper.select(addLic);
		} catch (Exception e) {
			isSuccess = "0";
		}
		if (addliclist != null && !addliclist.isEmpty()) {
			for (ZxFoodAddLic lic : addliclist) {
				resultJson.put("vcName", lic.getVcCompanyName()); // 企业名称
				resultJson.put("vcFadingren", ""); // 法定代表人
				resultJson.put("vcFoodclass", lic.getVcProductName()); // 生产食品名称（类别）
				resultJson.put("vcExplanation", lic.getVcExplanation()); // 许可证说明
				resultJson.put("vcAllowcaode", lic.getVcLicenseNumber()); // 许可证编号
				resultJson.put("vcReportedDepartment", lic.getVcReportedDepartment()); // 上报部门
				resultJson.put("vcStarttime", lic.getDtIssue()); // 发证日期
				resultJson.put("vcEndtime", lic.getDtValidity()); // 证书有效期
				resultJson.put("vcPeoductaddress", lic.getVcProductionAddress()); // 生产地址
				resultJson.put("vcMingxi", lic.getVcDetails()); // 详情
				// resultJson = (JSONObject) JSONObject.toJSON(lic);
				LOGGER.info("食品添加剂  addlic表 返回数据 :" + resultJson);
			}
		}

		obj.put("reasonCode", "");
		obj.put("resultCode", "");
		obj.put("data", resultJson);
		// 添加日志
		String id = UUID.randomUUID().toString();
		String productcode = System.getProperty("foodAddLic_Lic");
		// 结果 来源
		String datasource = "1";
		SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
		        obj.toString(), isSuccess);
		ThreadPool.submitTask(sendProductLogTask);

		return obj.toJSONString();
	}

	/**
	 * 模糊查询
	 * 
	 * @param LogInfo
	 * @param params
	 * @return
	 */
	public String findLikeCompany(LogInfo LogInfo, String params) {
		JSONObject obj = new JSONObject();
		
		JSONArray array = new JSONArray();
		JSONObject jsonParams = JSON.parseObject(params);
		String vcName = jsonParams.getString("company").trim(); // 获取公司名称
		Example example = new Example(ZxFoodAddLic.class);
		example.or().andLike("vcCompanyName", "%" + vcName + "%");
		Example example1 = new Example(ZxFoodDrugFoodproductCs.class);
		example1.or().andLike("vcName", "%" + vcName + "%");
		Example example2 = new Example(ZxFoodDrugFoodproductQs.class);
		example2.or().andLike("vcName", "%" + vcName + "%");

		List<ZxFoodAddLic> list1 =  new ArrayList<ZxFoodAddLic>();
		list1 =addLicMapper.selectByExample(example);
		List<ZxFoodDrugFoodproductCs> list2 = new ArrayList<ZxFoodDrugFoodproductCs>();
		List<ZxFoodDrugFoodproductQs> list3 = new ArrayList<ZxFoodDrugFoodproductQs>();

		if (list1 == null || list1.isEmpty()) {
			list2 = csMapper.selectByExample(example1);
			if (list2 == null || list2.isEmpty()) {
				list3 = qsMapper.selectByExample(example2);
			}
		} else {
			for (ZxFoodAddLic lic : list1) {
				JSONObject resultJson = new JSONObject();
				resultJson.put("vcName", lic.getVcCompanyName()); // 企业名称
				resultJson.put("vcFadingren", ""); // 法定代表人
				resultJson.put("vcFoodclass", lic.getVcProductName()); // 生产食品名称（类别）
				resultJson.put("vcExplanation", lic.getVcExplanation()); // 许可证说明
				resultJson.put("vcAllowcaode", lic.getVcLicenseNumber()); // 许可证编号
				resultJson.put("vcReportedDepartment", lic.getVcReportedDepartment()); // 上报部门
				resultJson.put("vcStarttime", lic.getDtIssue()); // 发证日期
				resultJson.put("vcEndtime", lic.getDtValidity()); // 证书有效期
				resultJson.put("vcPeoductaddress", lic.getVcProductionAddress()); // 生产地址
				resultJson.put("vcMingxi", lic.getVcDetails()); // 详情
				array.add(resultJson);
				LOGGER.info("模糊查询_____食品添加剂  addlic表 返回数据 :" + resultJson);
			}
		}

		if (list2 != null && !list2.isEmpty()) {
			for (ZxFoodDrugFoodproductCs cs : list2) {
				JSONObject resultJson = new JSONObject();
				resultJson.put("vcName", cs.getVcName()); // 企业名称
				resultJson.put("vcFadingren", cs.getVcFadingren()); // 法定代表人
				resultJson.put("vcFoodclass", cs.getVcFoodclass()); // 生产食品名称（类别）
				resultJson.put("vcJainyanfangshi", ""); // 检验方式
				resultJson.put("vcAllowcaode", cs.getVcAllowcaode()); // 许可证编号
				resultJson.put("vcOffice", cs.getVcOffice()); // 发证单位
				resultJson.put("vcStarttime", cs.getVcStarttime()); // 发证日期
				resultJson.put("vcEndtime", cs.getVcEndtime()); // 证书有效期
				resultJson.put("vcPeoductaddress", cs.getVcPeoductaddress()); // 生产地址
				resultJson.put("vcMingxi", cs.getVcMingxi()); // 详情
				array.add(resultJson);
				LOGGER.info("模糊查询_____食品安全 cs表 返回数据 :" + resultJson);
			}
		}
		if (list3 != null && !list3.isEmpty()) {
			for (ZxFoodDrugFoodproductQs qs : list3) {
				JSONObject resultJson = new JSONObject();
				resultJson.put("vcName", qs.getVcName()); // 企业名称
				resultJson.put("vcFadingren", ""); // 法定代表人
				resultJson.put("vcFoodclass", qs.getVcProducter()); // 生产食品名称（类别）
				resultJson.put("vcJainyanfangshi", qs.getVcJainyanfangshi()); // 检验方式
				resultJson.put("vcAllowcaode", qs.getVcCode()); // 许可证编号
				resultJson.put("vcOffice", qs.getVcOffice()); // 发证单位
				resultJson.put("vcStarttime", qs.getVcStarttime()); // 发证日期
				resultJson.put("vcEndtime", qs.getVcEndtime()); // 证书有效期
				resultJson.put("vcPeoductaddress", qs.getVcPeoductaddress()); // 生产地址
				resultJson.put("vcMingxi", ""); // 详情
				array.add(resultJson);
				LOGGER.info("模糊查询_____食品安全 qs表 返回数据 :" + resultJson);
			}
		}
		
		obj.put("reasonCode", "");
		obj.put("resultCode", "");
		obj.put("data", array);
		// 添加日志
		String id = UUID.randomUUID().toString();
		String productcode = System.getProperty("foodMohu");
		// 结果 来源
		String datasource = "1";
		SendProductLogTask sendProductLogTask = new SendProductLogTask(JSON.toJSON(LogInfo), id, productcode, datasource, "1", params.toString(),
		        obj.toString(), isSuccess);
		ThreadPool.submitTask(sendProductLogTask);

		return obj.toJSONString();

	}
}
