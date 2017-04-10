package cn.com.chenxin.entity;

import java.io.Serializable;
import java.math.BigDecimal;


public class Log_product implements LogMessage,Serializable{

	private String id;

    private String groupId;

    private String userId;

    private String userName;

    private String userType;

    private String productId;

    private String productName;

    private String productType;

    private String dataType;

    private String outLogId;

    private String parentId;

    private String forwardLevel;

    private String params;

    private String Result;

    private String isSuccess;
    
    private String out_webserviceName;

    private String out_webserviceUrl;

    private String out_params;

    private String out_Result;

    private String out_isSuccess;

    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getOutLogId() {
		return outLogId;
	}

	public void setOutLogId(String outLogId) {
		this.outLogId = outLogId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	

	public String getForwardLevel() {
		return forwardLevel;
	}

	public void setForwardLevel(String forwardLevel) {
		this.forwardLevel = forwardLevel;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}



	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getOut_webserviceName() {
		return out_webserviceName;
	}

	public void setOut_webserviceName(String out_webserviceName) {
		this.out_webserviceName = out_webserviceName;
	}

	public String getOut_webserviceUrl() {
		return out_webserviceUrl;
	}

	public void setOut_webserviceUrl(String out_webserviceUrl) {
		this.out_webserviceUrl = out_webserviceUrl;
	}

	public String getOut_params() {
		return out_params;
	}

	public void setOut_params(String out_params) {
		this.out_params = out_params;
	}

	

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public String getOut_Result() {
		return out_Result;
	}

	public void setOut_Result(String out_Result) {
		this.out_Result = out_Result;
	}

	public String getOut_isSuccess() {
		return out_isSuccess;
	}

	public void setOut_isSuccess(String out_isSuccess) {
		this.out_isSuccess = out_isSuccess;
	}

	@Override
	public String toString() {
		return "Log_product [id=" + id + ", groupId=" + groupId + ", userId="
				+ userId + ", userName=" + userName + ", userType=" + userType
				+ ", productId=" + productId + ", productName=" + productName
				+ ", productType=" + productType + ", dataType=" + dataType
				+ ", outLogId=" + outLogId + ", parentId=" + parentId
				+ ", forwardLevel=" + forwardLevel + ", params=" + params
				+ ", Result=" + Result + ", isSuccess=" + isSuccess
				+ ", out_webserviceName=" + out_webserviceName
				+ ", out_webserviceUrl=" + out_webserviceUrl + ", out_params="
				+ out_params + ", out_Result=" + out_Result
				+ ", out_isSuccess=" + out_isSuccess + "]";
	}

  
}