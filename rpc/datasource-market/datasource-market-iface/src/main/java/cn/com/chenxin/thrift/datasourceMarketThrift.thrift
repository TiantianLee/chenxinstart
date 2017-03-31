namespace java cn.com.chenxin.face

    struct LogInfo{
	1: string id;
	2: string userId;
	3: string userName;
	4: string groupId;
}

 service datasourceMarkeThrift {
    string zxbg_jyyc(1:LogInfo logInfo,2:string para);
 }