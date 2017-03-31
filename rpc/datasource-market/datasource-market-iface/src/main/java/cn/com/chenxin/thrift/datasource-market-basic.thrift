namespace java cn.com.chenxin.iface

struct LogInfo{
	1: string id;
	2: string userId;
	3: string userName;
	4: string userType;
	5: string groupId;
}

service DatasourceMarketBasicThrift{

	
	//通过姓名和身份证号查询数据库个人信息
	string findBasicByNameAndCode(1:LogInfo LogInfo,2:string params);
   
}