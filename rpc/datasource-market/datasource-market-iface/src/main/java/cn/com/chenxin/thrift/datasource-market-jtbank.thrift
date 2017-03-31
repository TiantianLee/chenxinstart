namespace java cn.com.chenxin.iface

struct LogInfo{
	1: string id;
	2: string userId;
	3: string userName;
	4: string userType;
	5: string groupId;
}

service DatasourceMarketJtBankThrift{

	//海关
	string findJtBankHg(1:LogInfo LogInfo,2:string params);
	//车主
	string findJtBankCar(1:LogInfo LogInfo,2:string params);
	//房主
	string findJtBankFz(1:LogInfo LogInfo,2:string params);
   
}