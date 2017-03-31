package cn.com.chenxin.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_HMD_WDX")
public class JsHmdWdx {
    @Column(name = "XM")
    private String xm;

    @Column(name = "GMSFHM")
    private String gmsfhm;

    @Column(name = "SJHM")
    private String sjhm;

    @Column(name = "JKCS")
    private String jkcs;

    @Column(name = "JKRQ")
    private Date jkrq;

    @Column(name = "JKQS")
    private String jkqs;

    @Column(name = "JKJE")
    private BigDecimal jkje;

    @Column(name = "YHJE")
    private BigDecimal yhje;

    @Column(name = "WHJE")
    private BigDecimal whje;

    @Column(name = "YQRQ")
    private Date yqrq;

    @Column(name = "YQTS")
    private BigDecimal yqts;

    @Column(name = "ZDYQTS")
    private BigDecimal zdyqts;

    @Column(name = "FXLB")
    private String fxlb;

    @Column(name = "FXXX")
    private String fxxx;

    @Column(name = "XXLX")
    private String xxlx;

    @Column(name = "LYFL")
    private String lyfl;

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
     * @return JKCS
     */
    public String getJkcs() {
        return jkcs;
    }

    /**
     * @param jkcs
     */
    public void setJkcs(String jkcs) {
        this.jkcs = jkcs;
    }

    /**
     * @return JKRQ
     */
    public Date getJkrq() {
        return jkrq;
    }

    /**
     * @param jkrq
     */
    public void setJkrq(Date jkrq) {
        this.jkrq = jkrq;
    }

    /**
     * @return JKQS
     */
    public String getJkqs() {
        return jkqs;
    }

    /**
     * @param jkqs
     */
    public void setJkqs(String jkqs) {
        this.jkqs = jkqs;
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
     * @return YHJE
     */
    public BigDecimal getYhje() {
        return yhje;
    }

    /**
     * @param yhje
     */
    public void setYhje(BigDecimal yhje) {
        this.yhje = yhje;
    }

    /**
     * @return WHJE
     */
    public BigDecimal getWhje() {
        return whje;
    }

    /**
     * @param whje
     */
    public void setWhje(BigDecimal whje) {
        this.whje = whje;
    }

    /**
     * @return YQRQ
     */
    public Date getYqrq() {
        return yqrq;
    }

    /**
     * @param yqrq
     */
    public void setYqrq(Date yqrq) {
        this.yqrq = yqrq;
    }

    /**
     * @return YQTS
     */
    public BigDecimal getYqts() {
        return yqts;
    }

    /**
     * @param yqts
     */
    public void setYqts(BigDecimal yqts) {
        this.yqts = yqts;
    }

    /**
     * @return ZDYQTS
     */
    public BigDecimal getZdyqts() {
        return zdyqts;
    }

    /**
     * @param zdyqts
     */
    public void setZdyqts(BigDecimal zdyqts) {
        this.zdyqts = zdyqts;
    }

    /**
     * @return FXLB
     */
    public String getFxlb() {
        return fxlb;
    }

    /**
     * @param fxlb
     */
    public void setFxlb(String fxlb) {
        this.fxlb = fxlb;
    }

    /**
     * @return FXXX
     */
    public String getFxxx() {
        return fxxx;
    }

    /**
     * @param fxxx
     */
    public void setFxxx(String fxxx) {
        this.fxxx = fxxx;
    }

    /**
     * @return XXLX
     */
    public String getXxlx() {
        return xxlx;
    }

    /**
     * @param xxlx
     */
    public void setXxlx(String xxlx) {
        this.xxlx = xxlx;
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