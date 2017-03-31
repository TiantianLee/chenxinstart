package cn.com.chenxin.model;

import javax.persistence.*;

@Table(name = "ZX_FOOD_DRUG_FOODPRODUCT_CS")
public class ZxFoodDrugFoodproductCs {
    @Column(name = "VC_NAME")
    private String vcName;

    @Column(name = "VC_BELEIVECODE")
    private String vcBeleivecode;

    @Column(name = "VC_FADINGREN")
    private String vcFadingren;

    @Column(name = "VC_ZHUSUO")
    private String vcZhusuo;

    @Column(name = "VC_PEODUCTADDRESS")
    private String vcPeoductaddress;

    @Column(name = "VC_FOODCLASS")
    private String vcFoodclass;

    @Column(name = "VC_ALLOWCAODE")
    private String vcAllowcaode;

    @Column(name = "VC_JIANDUJIGOU")
    private String vcJiandujigou;

    @Column(name = "VC_JIANDUREN")
    private String vcJianduren;

    @Column(name = "VC_OFFICE")
    private String vcOffice;

    @Column(name = "VC_QIANFAREN")
    private String vcQianfaren;

    @Column(name = "VC_STARTTIME")
    private String vcStarttime;

    @Column(name = "VC_ENDTIME")
    private String vcEndtime;

    @Column(name = "VC_MINGXI")
    private String vcMingxi;

    @Column(name = "VC_ORIGIN")
    private String vcOrigin;

    @Column(name = "VC_URL")
    private String vcUrl;

    @Column(name = "VC_TIME")
    private String vcTime;

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
     * @return VC_BELEIVECODE
     */
    public String getVcBeleivecode() {
        return vcBeleivecode;
    }

    /**
     * @param vcBeleivecode
     */
    public void setVcBeleivecode(String vcBeleivecode) {
        this.vcBeleivecode = vcBeleivecode;
    }

    /**
     * @return VC_FADINGREN
     */
    public String getVcFadingren() {
        return vcFadingren;
    }

    /**
     * @param vcFadingren
     */
    public void setVcFadingren(String vcFadingren) {
        this.vcFadingren = vcFadingren;
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
     * @return VC_FOODCLASS
     */
    public String getVcFoodclass() {
        return vcFoodclass;
    }

    /**
     * @param vcFoodclass
     */
    public void setVcFoodclass(String vcFoodclass) {
        this.vcFoodclass = vcFoodclass;
    }

    /**
     * @return VC_ALLOWCAODE
     */
    public String getVcAllowcaode() {
        return vcAllowcaode;
    }

    /**
     * @param vcAllowcaode
     */
    public void setVcAllowcaode(String vcAllowcaode) {
        this.vcAllowcaode = vcAllowcaode;
    }

    /**
     * @return VC_JIANDUJIGOU
     */
    public String getVcJiandujigou() {
        return vcJiandujigou;
    }

    /**
     * @param vcJiandujigou
     */
    public void setVcJiandujigou(String vcJiandujigou) {
        this.vcJiandujigou = vcJiandujigou;
    }

    /**
     * @return VC_JIANDUREN
     */
    public String getVcJianduren() {
        return vcJianduren;
    }

    /**
     * @param vcJianduren
     */
    public void setVcJianduren(String vcJianduren) {
        this.vcJianduren = vcJianduren;
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
     * @return VC_QIANFAREN
     */
    public String getVcQianfaren() {
        return vcQianfaren;
    }

    /**
     * @param vcQianfaren
     */
    public void setVcQianfaren(String vcQianfaren) {
        this.vcQianfaren = vcQianfaren;
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
     * @return VC_MINGXI
     */
    public String getVcMingxi() {
        return vcMingxi;
    }

    /**
     * @param vcMingxi
     */
    public void setVcMingxi(String vcMingxi) {
        this.vcMingxi = vcMingxi;
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