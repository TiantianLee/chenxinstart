package cn.com.chenxin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_HMD_GRSX_X")
public class JsHmdGrsxX {
    @Column(name = "XM")
    private String xm;

    @Column(name = "GMSFHM")
    private String gmsfhm;

    @Column(name = "ZXFY")
    private String zxfy;

    @Column(name = "SF")
    private String sf;

    @Column(name = "AH")
    private String ah;

    @Column(name = "LXQK")
    private String lxqk;

    @Column(name = "JTQK")
    private String jtqk;

    @Column(name = "FBRQ")
    private Date fbrq;

    @Column(name = "LARQ")
    private Date larq;

    @Column(name = "YYNR")
    private String yynr;

    @Column(name = "YYSJ")
    private Date yysj;

    @Column(name = "FXLB")
    private String fxlb;

    @Column(name = "XXLY")
    private String xxly;

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
     * @return YYNR
     */
    public String getYynr() {
        return yynr;
    }

    /**
     * @param yynr
     */
    public void setYynr(String yynr) {
        this.yynr = yynr;
    }

    /**
     * @return YYSJ
     */
    public Date getYysj() {
        return yysj;
    }

    /**
     * @param yysj
     */
    public void setYysj(Date yysj) {
        this.yysj = yysj;
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