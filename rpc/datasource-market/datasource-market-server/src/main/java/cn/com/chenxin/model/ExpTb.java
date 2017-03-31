package cn.com.chenxin.model;

import javax.persistence.*;

@Table(name = "EXP_TB")
public class ExpTb {
    @Column(name = "XM")
    private String xm;

    @Column(name = "DZ")
    private String dz;

    @Column(name = "DHHM")
    private String dhhm;

    @Column(name = "SJHM")
    private String sjhm;

    @Column(name = "SF")
    private String sf;

    @Column(name = "CS")
    private String cs;

    @Column(name = "DQ")
    private String dq;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GMSFHM")
    private String gmsfhm;

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
     * @return DHHM
     */
    public String getDhhm() {
        return dhhm;
    }

    /**
     * @param dhhm
     */
    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
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
     * @return SF
     */
    public String getSf() {
        return sf;
    }

    /**
     * @param sf
     */
    public void setSf(String sf) {
        this.sf = sf;
    }

    /**
     * @return CS
     */
    public String getCs() {
        return cs;
    }

    /**
     * @param cs
     */
    public void setCs(String cs) {
        this.cs = cs;
    }

    /**
     * @return DQ
     */
    public String getDq() {
        return dq;
    }

    /**
     * @param dq
     */
    public void setDq(String dq) {
        this.dq = dq;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
}