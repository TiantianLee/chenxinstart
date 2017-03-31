namespace java cn.com.chenxin.iface

struct LogInfo{
	1: string id;
	2: string userId;
	3: string userName;
	4: string userType;
	5: string groupId;
}

service DatasourceMarketSfhcThrift{

	
	//通过姓名和身份证号查询身份核查接口
	string findSfhcByNameAndCode(1:LogInfo LogInfo,2:string params);
	//通过姓名和手机号查询身份核查接口
	string findSfhcByNameAndPhone(1:LogInfo LogInfo,2:string params);
   
}