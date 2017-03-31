package cn.com.chenxin.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_HMD_GRSX_TMP")
public class JsHmdGrsxTmp {
    @Column(name = "XM")
    private String xm;

    @Column(name = "GMSFHM")
    private String gmsfhm;

    @Column(name = "SF")
    private String sf;

    @Column(name = "CS")
    private String cs;

    @Column(name = "LARQ")
    private Date larq;

    @Column(name = "FBRQ")
    private Date fbrq;

    @Column(name = "JLZQ")
    private BigDecimal jlzq;

    @Column(name = "ZXFY")
    private String zxfy;

    @Column(name = "ZXWH")
    private String zxwh;

    @Column(name = "AH")
    private String ah;

    @Column(name = "LXQK")
    private String lxqk;

    @Column(name = "YLX")
    private String ylx;

    @Column(name = "YLXJE")
    private BigDecimal ylxje;

    @Column(name = "WLX")
    private String wlx;

    @Column(name = "WLXJE")
    private BigDecimal wlxje;

    @Column(name = "JTQK")
    private String jtqk;

    @Column(name = "FXLB")
    private String fxlb;

    @Column(name = "XXLY")
    private String xxly;

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
     * @return LARQ
     */
    public Date getLarq() {
        return larq;
    }

    /**
     * @param larq
     */
    public void setLarq(Date larq) {
        this.larq = larq;
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

    /**
     * @return JLZQ
     */
    public BigDecimal getJlzq() {
        return jlzq;
    }

    /**
     * @param jlzq
     */
    public void setJlzq(BigDecimal jlzq) {
        this.jlzq = jlzq;
    }

    /**
     * @return ZXFY
     */
    public String getZxfy() {
        return zxfy;
    }

    /**
     * @param zxfy
     */
    public void setZxfy(String zxfy) {
        this.zxfy = zxfy;
    }

    /**
     * @return ZXWH
     */
    public String getZxwh() {
        return zxwh;
    }

    /**
     * @param zxwh
     */
    public void setZxwh(String zxwh) {
        this.zxwh = zxwh;
    }

    /**
     * @return AH
     */
    public String getAh() {
        return ah;
    }

    /**
     * @param ah
     */
    public void setAh(String ah) {
        this.ah = ah;
    }

    /**
     * @return LXQK
     */
    public String getLxqk() {
        return lxqk;
    }

    /**
     * @param lxqk
     */
    public void setLxqk(String lxqk) {
        this.lxqk = lxqk;
    }

    /**
     * @return YLX
     */
    public String getYlx() {
        return ylx;
    }

    /**
     * @param ylx
     */
    public void setYlx(String ylx) {
        this.ylx = ylx;
    }

    /**
     * @return YLXJE
     */
    public BigDecimal getYlxje() {
        return ylxje;
    }

    /**
     * @param ylxje
     */
    public void setYlxje(BigDecimal ylxje) {
        this.ylxje = ylxje;
    }

    /**
     * @return WLX
     */
    public String getWlx() {
        return wlx;
    }

    /**
     * @param wlx
     */
    public void setWlx(String wlx) {
        this.wlx = wlx;
    }

    /**
     * @return WLXJE
     */
    public BigDecimal getWlxje() {
        return wlxje;
    }

    /**
     * @param wlxje
     */
    public void setWlxje(BigDecimal wlxje) {
        this.wlxje = wlxje;
    }

    /**
     * @return JTQK
     */
    public String getJtqk() {
        return jtqk;
    }

    /**
     * @param jtqk
     */
    public void setJtqk(String jtqk) {
        this.jtqk = jtqk;
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