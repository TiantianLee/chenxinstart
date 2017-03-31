namespace java cn.com.chenxin.iface

struct LogInfo{
	1: string id;
	2: string userId;
	3: string userName;
	4: string userType;
	5: string groupId;
}

service DatasourceMarketFullInfoThrift{

	
	//通过姓名、身份证号和手机号查询信息补全接口
	string findFullInfo(1:LogInfo LogInfo,2:string params);
	//通过姓名、身份证号和手机号查询信息补全接口A
	string findFullInfoA(1:LogInfo LogInfo,2:string params);
	//通过姓名、身份证号和手机号查询信息补全接口A2
	string findFullInfoA2(1:LogInfo LogInfo,2:string params);
	//通过姓名和身份证号查询机场信息接口
	string findAirPortData(1:LogInfo LogInfo,2:string params);
	//通过姓名和手机号或电话号码查询快递信息接口
	string findFullInfoC(1:LogInfo LogInfo,2:string params);
   
}