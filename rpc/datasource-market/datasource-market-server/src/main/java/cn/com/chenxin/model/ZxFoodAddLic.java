package cn.com.chenxin.model;

import javax.persistence.*;

@Table(name = "ZX_FOOD_ADD_LIC")
public class ZxFoodAddLic {
    @Column(name = "NM_ID")
    private String nmId;

    @Column(name = "VC_ORIGIN")
    private String vcOrigin;

    @Column(name = "VC_URL")
    private String vcUrl;

    @Column(name = "VC_MD5")
    private String vcMd5;

    @Column(name = "DT_CREATEDATE")
    private String dtCreatedate;

    @Column(name = "VC_LICENSE_NUMBER")
    private String vcLicenseNumber;

    @Column(name = "VC_PROVINCE")
    private String vcProvince;

    @Column(name = "VC_COMPANY_NAME")
    private String vcCompanyName;

    @Column(name = "VC_PRODUCT_NAME")
    private String vcProductName;

    @Column(name = "VC_RESIDENCE")
    private String vcResidence;

    @Column(name = "VC_PRODUCTION_ADDRESS")
    private String vcProductionAddress;

    @Column(name = "DT_ISSUE")
    private String dtIssue;

    @Column(name = "DT_VALIDITY")
    private String dtValidity;

    @Column(name = "VC_EXPLANATION")
    private String vcExplanation;

    @Column(name = "VC_REPORTED_DEPARTMENT")
    private String vcReportedDepartment;

    @Column(name = "VC_DETAILS")
    private String vcDetails;

    /**
     * @return NM_ID
     */
    public String getNmId() {
        return nmId;
    }

    /**
     * @param nmId
     */
    public void setNmId(String nmId) {
        this.nmId = nmId;
    }

    /**
     * @return VC_ORIGIN
     */
    public String getVcOrigin() {
        return vcOrigin;
    }

    /**
     * @param vcOrigin
     */
    public void setVcOrigin(String vcOrigin) {
        this.vcOrigin = vcOrigin;
    }

    /**
     * @return VC_URL
     */
    public String getVcUrl() {
        return vcUrl;
    }

    /**
     * @param vcUrl
     */
    public void setVcUrl(String vcUrl) {
        this.vcUrl = vcUrl;
    }

    /**
     * @return VC_MD5
     */
    public String getVcMd5() {
        return vcMd5;
    }

    /**
     * @param vcMd5
     */
    public void setVcMd5(String vcMd5) {
        this.vcMd5 = vcMd5;
    }

    /**
     * @return DT_CREATEDATE
     */
    public String getDtCreatedate() {
        return dtCreatedate;
    }

    /**
     * @param dtCreatedate
     */
    public void setDtCreatedate(String dtCreatedate) {
        this.dtCreatedate = dtCreatedate;
    }

    /**
     * @return VC_LICENSE_NUMBER
     */
    public String getVcLicenseNumber() {
        return vcLicenseNumber;
    }

    /**
     * @param vcLicenseNumber
     */
    public void setVcLicenseNumber(String vcLicenseNumber) {
        this.vcLicenseNumber = vcLicenseNumber;
    }

    /**
     * @return VC_PROVINCE
     */
    public String getVcProvince() {
        return vcProvince;
    }

    /**
     * @param vcProvince
     */
    public void setVcProvince(String vcProvince) {
        this.vcProvince = vcProvince;
    }

    /**
     * @return VC_COMPANY_NAME
     */
    public String getVcCompanyName() {
        return vcCompanyName;
    }

    /**
     * @param vcCompanyName
     */
    public void setVcCompanyName(String vcCompanyName) {
        this.vcCompanyName = vcCompanyName;
    }

    /**
     * @return VC_PRODUCT_NAME
     */
    public String getVcProductName() {
        return vcProductName;
    }

    /**
     * @param vcProductName
     */
    public void setVcProductName(String vcProductName) {
        this.vcProductName = vcProductName;
    }

    /**
     * @return VC_RESIDENCE
     */
    public String getVcResidence() {
        return vcResidence;
    }

    /**
     * @param vcResidence
     */
    public void setVcResidence(String vcResidence) {
        this.vcResidence = vcResidence;
    }

    /**
     * @return VC_PRODUCTION_ADDRESS
     */
    public String getVcProductionAddress() {
        return vcProductionAddress;
    }

    /**
     * @param vcProductionAddress
     */
    public void setVcProductionAddress(String vcProductionAddress) {
        this.vcProductionAddress = vcProductionAddress;
    }

    /**
     * @return DT_ISSUE
     */
    public String getDtIssue() {
        return dtIssue;
    }

    /**
     * @param dtIssue
     */
    public void setDtIssue(String dtIssue) {
        this.dtIssue = dtIssue;
    }

    /**
     * @return DT_VALIDITY
     */
    public String getDtValidity() {
        return dtValidity;
    }

    /**
     * @param dtValidity
     */
    public void setDtValidity(String dtValidity) {
        this.dtValidity = dtValidity;
    }

    /**
     * @return VC_EXPLANATION
     */
    public String getVcExplanation() {
        return vcExplanation;
    }

    /**
     * @param vcExplanation
     */
    public void setVcExplanation(String vcExplanation) {
        this.vcExplanation = vcExplanation;
    }

    /**
     * @return VC_REPORTED_DEPARTMENT
     */
    public String getVcReportedDepartment() {
        return vcReportedDepartment;
    }

    /**
     * @param vcReportedDepartment
     */
    public void setVcReportedDepartment(String vcReportedDepartment) {
        this.vcReportedDepartment = vcReportedDepartment;
    }

    /**
     * @return VC_DETAILS
     */
    public String getVcDetails() {
        return vcDetails;
    }

    /**
     * @param vcDetails
     */
    public void setVcDetails(String vcDetails) {
        this.vcDetails = vcDetails;
    }
}