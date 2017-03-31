package cn.com.chenxin.model.JtBank;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_JDC_TEST100")
public class JsJdcTest100 {
    @Column(name = "CZ")
    private String cz;

    @Column(name = "SBMC")
    private String sbmc;

    @Column(name = "HPHM")
    private String hphm;

    @Column(name = "CLXH")
    private String clxh;

    @Column(name = "HPZL")
    private String hpzl;

    @Column(name = "DWGR")
    private String dwgr;

    @Column(name = "CLLX")
    private String cllx;

    @Column(name = "CJHM")
    private String cjhm;

    @Column(name = "CLZT")
    private String clzt;

    @Column(name = "CSYS")
    private String csys;

    @Column(name = "CCRQ")
    private Date ccrq;

    @Column(name = "DJRQ")
    private Date djrq;

    @Column(name = "GMSFHM")
    private String gmsfhm;

    @Column(name = "ZJLX")
    private String zjlx;

    @Column(name = "SJHM")
    private String sjhm;

    @Column(name = "SJHM_O")
    private String sjhmO;

    @Column(name = "QTHM")
    private String qthm;

    @Column(name = "DHHM")
    private String dhhm;

    @Column(name = "DZ")
    private String dz;

    @Column(name = "FDJH")
    private String fdjh;

    @Column(name = "FDJXH")
    private String fdjxh;

    @Column(name = "GCJK")
    private String gcjk;

    @Column(name = "SYXZ")
    private String syxz;

    @Column(name = "XZQH")
    private String xzqh;

    @Column(name = "YZBM")
    private String yzbm;

    @Column(name = "ZBZL")
    private BigDecimal zbzl;

    @Column(name = "ZZCS")
    private String zzcs;

    @Column(name = "ZZGJ")
    private String zzgj;

    @Column(name = "ZZL")
    private BigDecimal zzl;

    @Column(name = "PJ")
    private String pj;

    /**
     * @return CZ
     */
    public String getCz() {
        return cz;
    }

    /**
     * @param cz
     */
    public void setCz(String cz) {
        this.cz = cz;
    }

    /**
     * @return SBMC
     */
    public String getSbmc() {
        return sbmc;
    }

    /**
     * @param sbmc
     */
    public void setSbmc(String sbmc) {
        this.sbmc = sbmc;
    }

    /**
     * @return HPHM
     */
    public String getHphm() {
        return hphm;
    }

    /**
     * @param hphm
     */
    public void setHphm(String hphm) {
        this.hphm = hphm;
    }

    /**
     * @return CLXH
     */
    public String getClxh() {
        return clxh;
    }

    /**
     * @param clxh
     */
    public void setClxh(String clxh) {
        this.clxh = clxh;
    }

    /**
     * @return HPZL
     */
    public String getHpzl() {
        return hpzl;
    }

    /**
     * @param hpzl
     */
    public void setHpzl(String hpzl) {
        this.hpzl = hpzl;
    }

    /**
     * @return DWGR
     */
    public String getDwgr() {
        return dwgr;
    }

    /**
     * @param dwgr
     */
    public void setDwgr(String dwgr) {
        this.dwgr = dwgr;
    }

    /**
     * @return CLLX
     */
    public String getCllx() {
        return cllx;
    }

    /**
     * @param cllx
     */
    public void setCllx(String cllx) {
        this.cllx = cllx;
    }

    /**
     * @return CJHM
     */
    public String getCjhm() {
        return cjhm;
    }

    /**
     * @param cjhm
     */
    public void setCjhm(String cjhm) {
        this.cjhm = cjhm;
    }

    /**
     * @return CLZT
     */
    public String getClzt() {
        return clzt;
    }

    /**
     * @param clzt
     */
    public void setClzt(String clzt) {
        this.clzt = clzt;
    }

    /**
     * @return CSYS
     */
    public String getCsys() {
        return csys;
    }

    /**
     * @param csys
     */
    public void setCsys(String csys) {
        this.csys = csys;
    }

    /**
     * @return CCRQ
     */
    public Date getCcrq() {
        return ccrq;
    }

    /**
     * @param ccrq
     */
    public void setCcrq(Date ccrq) {
        this.ccrq = ccrq;
    }

    /**
     * @return DJRQ
     */
    public Date getDjrq() {
        return djrq;
    }

    /**
     * @param djrq
     */
    public void setDjrq(Date djrq) {
        this.djrq = djrq;
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
     * @return ZJLX
     */
    public String getZjlx() {
        return zjlx;
    }

    /**
     * @param zjlx
     */
    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
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
     * @return SJHM_O
     */
    public String getSjhmO() {
        return sjhmO;
    }

    /**
     * @param sjhmO
     */
    public void setSjhmO(String sjhmO) {
        this.sjhmO = sjhmO;
    }

    /**
     * @return QTHM
     */
    public String getQthm() {
        return qthm;
    }

    /**
     * @param qthm
     */
    public void setQthm(String qthm) {
        this.qthm = qthm;
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
     * @return FDJH
     */
    public String getFdjh() {
        return fdjh;
    }

    /**
     * @param fdjh
     */
    public void setFdjh(String fdjh) {
        this.fdjh = fdjh;
    }

    /**
     * @return FDJXH
     */
    public String getFdjxh() {
        return fdjxh;
    }

    /**
     * @param fdjxh
     */
    public void setFdjxh(String fdjxh) {
        this.fdjxh = fdjxh;
    }

    /**
     * @return GCJK
     */
    public String getGcjk() {
        return gcjk;
    }

    /**
     * @param gcjk
     */
    public void setGcjk(String gcjk) {
        this.gcjk = gcjk;
    }

    /**
     * @return SYXZ
     */
    public String getSyxz() {
        return syxz;
    }

    /**
     * @param syxz
     */
    public void setSyxz(String syxz) {
        this.syxz = syxz;
    }

    /**
     * @return XZQH
     */
    public String getXzqh() {
        return xzqh;
    }

    /**
     * @param xzqh
     */
    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    /**
     * @return YZBM
     */
    public String getYzbm() {
        return yzbm;
    }

    /**
     * @param yzbm
     */
    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    /**
     * @return ZBZL
     */
    public BigDecimal getZbzl() {
        return zbzl;
    }

    /**
     * @param zbzl
     */
    public void setZbzl(BigDecimal zbzl) {
        this.zbzl = zbzl;
    }

    /**
     * @return ZZCS
     */
    public String getZzcs() {
        return zzcs;
    }

    /**
     * @param zzcs
     */
    public void setZzcs(String zzcs) {
        this.zzcs = zzcs;
    }

    /**
     * @return ZZGJ
     */
    public String getZzgj() {
        return zzgj;
    }

    /**
     * @param zzgj
     */
    public void setZzgj(String zzgj) {
        this.zzgj = zzgj;
    }

    /**
     * @return ZZL
     */
    public BigDecimal getZzl() {
        return zzl;
    }

    /**
     * @param zzl
     */
    public void setZzl(BigDecimal zzl) {
        this.zzl = zzl;
    }

    /**
     * @return PJ
     */
    public String getPj() {
        return pj;
    }

    /**
     * @param pj
     */
    public void setPj(String pj) {
        this.pj = pj;
    }
}