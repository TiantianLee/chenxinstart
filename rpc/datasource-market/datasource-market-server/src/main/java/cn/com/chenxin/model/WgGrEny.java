package cn.com.chenxin.model;

import javax.persistence.*;

@Table(name = "WG_GR_ENY")
public class WgGrEny {
    @Column(name = "XM")
    private String xm;

    @Column(name = "GMSFHM")
    private String gmsfhm;

    @Column(name = "XB")
    private String xb;

    @Column(name = "CSRQ")
    private String csrq;

    @Column(name = "SJHM")
    private String sjhm;

    @Column(name = "HYZK")
    private String hyzk;

    @Column(name = "DZ")
    private String dz;

    /**
     * @return XM
     */
    public String getXm() {
        return xm;
    }

    /**
     * @param xm
     */
    public void setXm(String xm) {
        this.xm = xm;
    }

    /**
     * @return GMSFHM
     */
    public String getGmsfhm() {
        return gmsfhm;
    }

    /**
     * @param gmsfhm
     */
    public void setGmsfhm(String gmsfhm) {
        this.gmsfhm = gmsfhm;
    }

    /**
     * @return XB
     */
    public String getXb() {
        return xb;
    }

    /**
     * @param xb
     */
    public void setXb(String xb) {
        this.xb = xb;
    }

    /**
     * @return CSRQ
     */
    public String getCsrq() {
        return csrq;
    }

    /**
     * @param csrq
     */
    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    /**
     * @return SJHM
     */
    public String getSjhm() {
        return sjhm;
    }

    /**
     * @param sjhm
     */
    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    /**
     * @return HYZK
     */
    public String getHyzk() {
        return hyzk;
    }

    /**
     * @param hyzk
     */
    public void setHyzk(String hyzk) {
        this.hyzk = hyzk;
    }

    /**
     * @return DZ
     */
    public String getDz() {
        return dz;
    }

    /**
     * @param dz
     */
    public void setDz(String dz) {
        this.dz = dz;
    }
}