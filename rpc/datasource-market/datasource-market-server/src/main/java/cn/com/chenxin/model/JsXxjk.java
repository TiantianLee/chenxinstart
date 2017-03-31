package cn.com.chenxin.model;

import javax.persistence.*;

@Table(name = "JS_XXJK")
public class JsXxjk {
    @Column(name = "DATA_SOURCE")
    private String dataSource;

    @Column(name = "XM")
    private String xm;

    @Column(name = "GMSFHM")
    private String gmsfhm;

    @Column(name = "SJHM")
    private String sjhm;

    @Column(name = "DZ")
    private String dz;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "QYMC")
    private String qymc;

    @Column(name = "QQ")
    private String qq;

    @Column(name = "ZC")
    private String zc;

    /**
     * @return DATA_SOURCE
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

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

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return QYMC
     */
    public String getQymc() {
        return qymc;
    }

    /**
     * @param qymc
     */
    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    /**
     * @return QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return ZC
     */
    public String getZc() {
        return zc;
    }

    /**
     * @param zc
     */
    public void setZc(String zc) {
        this.zc = zc;
    }
}