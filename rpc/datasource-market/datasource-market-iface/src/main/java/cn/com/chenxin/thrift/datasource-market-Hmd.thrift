namespace java cn.com.chenxin.iface

struct LogInfo{
	1: string id;
	2: string userId;
	3: string userName;
	4: string userType;
	5: string groupId;
}

service DatasourceMarketHmdThrift{

     
    //通过姓名和身份证号查询黑名单接口
	string findHmdByNameAndCode(1:LogInfo LogInfo,2:string params);
    //通过姓名和身份证查询DH接口
	string findDhHmdByNameAndCode(1:LogInfo LogInfo,2:string params);
	//通过姓名和手机号查询黑名单接口
	string findHmdByNameAndPhone(1:LogInfo LogInfo,2:string params);
	//通过姓名和电话查询黑DH名单接口
	string findDhHmdByNameAndPhone(1:LogInfo LogInfo,2:string params);
	
	
}