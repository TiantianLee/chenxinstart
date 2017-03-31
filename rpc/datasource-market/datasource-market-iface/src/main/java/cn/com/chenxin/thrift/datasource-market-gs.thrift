namespace java cn.com.chenxin.iface

struct LogInfo{
	1: string id;
	2: string userId;
	3: string userName;
	4: string userType;
	5: string groupId;
}

service DatasourceMarketGsThrift{

	//动产抵押物信息  企业投资信息  企业变更信息
	string findMorCorInvestment(1:LogInfo LogInfo,2:string params);
	   
   
}