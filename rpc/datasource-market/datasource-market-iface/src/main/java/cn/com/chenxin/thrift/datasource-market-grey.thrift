namespace java cn.com.chenxin.iface

struct LogInfo{
	1: string id;
	2: string userId;
	3: string userName;
	4: string userType;
	5: string groupId;
}

service DatasourceMarketGreyThrift{

	
	//通过姓名和身份证号查询灰名单接口
	string findGreyByNameAndCode(1:LogInfo LogInfo,2:string params);
	
}