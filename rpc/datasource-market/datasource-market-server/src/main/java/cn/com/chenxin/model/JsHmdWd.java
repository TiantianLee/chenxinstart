package cn.com.chenxin.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_HMD_WD")
public class JsHmdWd {
    @Column(name = "XM")
    private String xm;

    @Column(name = "GMSFHM")
    private String gmsfhm;

    @Column(name = "SJHM")
    private String sjhm;

    @Column(name = "JKRQ")
    private Date jkrq;

    @Column(name = "JKQS")
    private String jkqs;

    @Column(name = "YQRQ")
    private Date yqrq;

    @Column(name = "ZDYQTS")
    private BigDecimal zdyqts;

    @Column(name = "FXLB")
    private String fxlb;

    @Column(name = "DKLX")
    private String dklx;

    @Column(name = "XXLY")
    private String xxly;

    @Column(name = "LYFL")
    private String lyfl;

    @Column(name = "CJRQ")
    private Date cjrq;

    @Column(name = "FBRQ")
    private Date fbrq;

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
     * @return DKLX
     */
    public String getDklx() {
        return dklx;
    }

    /**
     * @param dklx
     */
    public void setDklx(String dklx) {
        this.dklx = dklx;
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

    /**
     * @return FBRQ
     */
    public Date getFbrq() {
        return fbrq;
    }

    /**
     * @param fbrq
     */
    public void setFbrq(Date fbrq) {
        this.fbrq = fbrq;
    }
}