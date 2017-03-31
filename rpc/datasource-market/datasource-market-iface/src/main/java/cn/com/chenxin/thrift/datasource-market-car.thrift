namespace java cn.com.chenxin.iface

struct LogInfo{
	1: string id;
	2: string userId;
	3: string userName;
	4: string userType;
	5: string groupId;
}

service DatasourceMarketCarThrift{

	
	//通过姓名和身份证号查询车辆接口
	string findCarByNameAndCode(1:LogInfo LogInfo,2:string params);
	//通过姓名和手机号查询车辆接口
	string findCarByNameAndPhone(1:LogInfo LogInfo,2:string params);
	//得到结果码
	string getCode(1:LogInfo LogInfo,2:string params);
	//综合
	string findCar(1:LogInfo LogInfo,2:string params);
   
}