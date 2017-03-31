package cn.com.chenxin.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * @Description: 
 * @author : caoq
 * @update_author : 
 * @since: 0.0.1-SNAPSHOT
 */
@Table(name = "JS_GMD_JK")
public class JsGmdJk {
    /** 
     * @Description: xm :  
     */
    @Column(name = "XM")
    private String xm;

    /** 
     * @Description: gmsfhm :
     */
    @Column(name = "GMSFHM")
    private String gmsfhm;

    /** 
     * @Description: jkrq : 
     */
    @Column(name = "JKRQ")
    private Date jkrq;

    /** 
     * @Description: jkje :  
     */
    @Column(name = "JKJE")
    private BigDecimal jkje;

    /** 
     * @Description: jkzq 
     */
    @Column(name = "JKZQ")
    private String jkzq;

    /** 
     * @Description: shjg 
     */
    @Column(name = "SHJG")
    private String shjg;

    /** 
     * @Description: zsrq  
     */
    @Column(name = "ZSRQ")
    private Date zsrq;

    /** 
     * @Description: qyrq 
     */
    @Column(name = "QYRQ")
    private Date qyrq;

    /** 
     * @Description: sqcs  
     */
    @Column(name = "SQCS")
    private String sqcs;

    /** 
     * @Description: xxly  
     */
    @Column(name = "XXLY")
    private String xxly;

    /** 
     * @Description: lyfl 
     */
    @Column(name = "LYFL")
    private String lyfl;

    /** 
     * @Description: cjrq 
     */
    @Column(name = "CJRQ")
    private Date cjrq;

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
     * @return JKRQ
     */
    public Date getJkrq() {
        return jkrq;
    }

    /**
     * @Description: TODO
     * @param jkrq
     * void 
     * @time:2016年2月3日 上午9:50:44
     */
    public void setJkrq(Date jkrq) {
        this.jkrq = jkrq;
    }

    /**
     * @return JKJE
     */
    public BigDecimal getJkje() {
        return jkje;
    }

    /**
     * @param jkje
     */
    public void setJkje(BigDecimal jkje) {
        this.jkje = jkje;
    }

    /**
     * @return JKZQ
     */
    public String getJkzq() {
        return jkzq;
    }

    /**
     * @param jkzq
     */
    public void setJkzq(String jkzq) {
        this.jkzq = jkzq;
    }

    /**
     * @return SHJG
     */
    public String getShjg() {
        return shjg;
    }

    /**
     * @param shjg
     */
    public void setShjg(String shjg) {
        this.shjg = shjg;
    }

    /**
     * @return ZSRQ
     */
    public Date getZsrq() {
        return zsrq;
    }

    /**
     * @param zsrq
     */
    public void setZsrq(Date zsrq) {
        this.zsrq = zsrq;
    }

    /**
     * @return QYRQ
     */
    public Date getQyrq() {
        return qyrq;
    }

    /**
     * @param qyrq
     */
    public void setQyrq(Date qyrq) {
        this.qyrq = qyrq;
    }

    /**
     * @return SQCS
     */
    public String getSqcs() {
        return sqcs;
    }

    /**
     * @param sqcs
     */
    public void setSqcs(String sqcs) {
        this.sqcs = sqcs;
    }

    /**
     * @return XXLY
     */
    public String getXxly() {
        return xxly;
    }

    /**
     * @param xxly
     */
    public void setXxly(String xxly) {
        this.xxly = xxly;
    }

    /**
     * @return LYFL
     */
    public String getLyfl() {
        return lyfl;
    }

    /**
     * @param lyfl
     */
    public void setLyfl(String lyfl) {
        this.lyfl = lyfl;
    }

    /**
     * @return CJRQ
     */
    public Date getCjrq() {
        return cjrq;
    }

    /**
     * @param cjrq
     */
    public void setCjrq(Date cjrq) {
        this.cjrq = cjrq;
    }
}