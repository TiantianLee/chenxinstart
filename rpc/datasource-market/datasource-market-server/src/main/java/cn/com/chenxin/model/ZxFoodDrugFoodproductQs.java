package cn.com.chenxin.model;

import javax.persistence.*;

@Table(name = "ZX_FOOD_DRUG_FOODPRODUCT_QS")
public class ZxFoodDrugFoodproductQs {
    @Column(name = "VC_CODE")
    private String vcCode;

    @Column(name = "VC_NAME")
    private String vcName;

    @Column(name = "VC_PRODUCTER")
    private String vcProducter;

    @Column(name = "VC_ZHUSUO")
    private String vcZhusuo;

    @Column(name = "VC_PEODUCTADDRESS")
    private String vcPeoductaddress;

    @Column(name = "VC_JAINYANFANGSHI")
    private String vcJainyanfangshi;

    @Column(name = "VC_STARTTIME")
    private String vcStarttime;

    @Column(name = "VC_ENDTIME")
    private String vcEndtime;

    @Column(name = "VC_OFFICE")
    private String vcOffice;

    @Column(name = "VC_ORIGIN")
    private String vcOrigin;

    @Column(name = "VC_URL")
    private String vcUrl;

    @Column(name = "VC_TIME")
    private String vcTime;

    /**
     * @return VC_CODE
     */
    public String getVcCode() {
        return vcCode;
    }

    /**
     * @param vcCode
     */
    public void setVcCode(String vcCode) {
        this.vcCode = vcCode;
    }

    /**
     * @return VC_NAME
     */
    public String getVcName() {
        return vcName;
    }

    /**
     * @param vcName
     */
    public void setVcName(String vcName) {
        this.vcName = vcName;
    }

    /**
     * @return VC_PRODUCTER
     */
    public String getVcProducter() {
        return vcProducter;
    }

    /**
     * @param vcProducter
     */
    public void setVcProducter(String vcProducter) {
        this.vcProducter = vcProducter;
    }

    /**
     * @return VC_ZHUSUO
     */
    public String getVcZhusuo() {
        return vcZhusuo;
    }

    /**
     * @param vcZhusuo
     */
    public void setVcZhusuo(String vcZhusuo) {
        this.vcZhusuo = vcZhusuo;
    }

    /**
     * @return VC_PEODUCTADDRESS
     */
    public String getVcPeoductaddress() {
        return vcPeoductaddress;
    }

    /**
     * @param vcPeoductaddress
     */
    public void setVcPeoductaddress(String vcPeoductaddress) {
        this.vcPeoductaddress = vcPeoductaddress;
    }

    /**
     * @return VC_JAINYANFANGSHI
     */
    public String getVcJainyanfangshi() {
        return vcJainyanfangshi;
    }

    /**
     * @param vcJainyanfangshi
     */
    public void setVcJainyanfangshi(String vcJainyanfangshi) {
        this.vcJainyanfangshi = vcJainyanfangshi;
    }

    /**
     * @return VC_STARTTIME
     */
    public String getVcStarttime() {
        return vcStarttime;
    }

    /**
     * @param vcStarttime
     */
    public void setVcStarttime(String vcStarttime) {
        this.vcStarttime = vcStarttime;
    }

    /**
     * @return VC_ENDTIME
     */
    public String getVcEndtime() {
        return vcEndtime;
    }

    /**
     * @param vcEndtime
     */
    public void setVcEndtime(String vcEndtime) {
        this.vcEndtime = vcEndtime;
    }

    /**
     * @return VC_OFFICE
     */
    public String getVcOffice() {
        return vcOffice;
    }

    /**
     * @param vcOffice
     */
    public void setVcOffice(String vcOffice) {
        this.vcOffice = vcOffice;
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
     * @return VC_TIME
     */
    public String getVcTime() {
        return vcTime;
    }

    /**
     * @param vcTime
     */
    public void setVcTime(String vcTime) {
        this.vcTime = vcTime;
    }
}