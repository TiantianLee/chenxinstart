package cn.com.chenxin.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_QYZX_QYHY")
public class JsQyzxQyhy {
    @Column(name = "QYMC")
    private String qymc;

    @Column(name = "YYZZZCH")
    private String yyzzzch;

    @Column(name = "FRXM")
    private String frxm;

    @Column(name = "CLRQ")
    private Date clrq;

    @Column(name = "JYZT")
    private String jyzt;

    @Column(name = "GXRQ")
    private Date gxrq;

    @Column(name = "LYID")
    private BigDecimal lyid;

    @Column(name = "CJRQ")
    private Date cjrq;

    @Column(name = "SF")
    private String sf;

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
     * @return YYZZZCH
     */
    public String getYyzzzch() {
        return yyzzzch;
    }

    /**
     * @param yyzzzch
     */
    public void setYyzzzch(String yyzzzch) {
        this.yyzzzch = yyzzzch;
    }

    /**
     * @return FRXM
     */
    public String getFrxm() {
        return frxm;
    }

    /**
     * @param frxm
     */
    public void setFrxm(String frxm) {
        this.frxm = frxm;
    }

    /**
     * @return CLRQ
     */
    public Date getClrq() {
        return clrq;
    }

    /**
     * @param clrq
     */
    public void setClrq(Date clrq) {
        this.clrq = clrq;
    }

    /**
     * @return JYZT
     */
    public String getJyzt() {
        return jyzt;
    }

    /**
     * @param jyzt
     */
    public void setJyzt(String jyzt) {
        this.jyzt = jyzt;
    }

    /**
     * @return GXRQ
     */
    public Date getGxrq() {
        return gxrq;
    }

    /**
     * @param gxrq
     */
    public void setGxrq(Date gxrq) {
        this.gxrq = gxrq;
    }

    /**
     * @return LYID
     */
    public BigDecimal getLyid() {
        return lyid;
    }

    /**
     * @param lyid
     */
    public void setLyid(BigDecimal lyid) {
        this.lyid = lyid;
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
}