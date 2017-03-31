namespace java cn.com.chenxin.iface

struct LogInfo{
	1: string id;
	2: string userId;
	3: string userName;
	4: string userType;
	5: string groupId;
}

service DatasourceMarketFoodThrift{

	
	//查询食品生产许可获证企业(SC)(QS)
	string findFoodScAndQs(1:LogInfo LogInfo,2:string params);
	//查询食品添加剂生产许可获证企业
	string findFoodAddLic(1:LogInfo LogInfo,2:string params);
   //模糊查询
	string findLikeCompany(1:LogInfo LogInfo,2:string params);
}