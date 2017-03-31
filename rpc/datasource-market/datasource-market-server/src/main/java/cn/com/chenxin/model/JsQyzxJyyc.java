package cn.com.chenxin.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_QYZX_JYYC")
public class JsQyzxJyyc {
    @Column(name = "QYMC")
    private String qymc;

    @Column(name = "YYZZZCH")
    private String yyzzzch;

    @Column(name = "LRYY")
    private String lryy;

    @Column(name = "LRRQ")
    private Date lrrq;

    @Column(name = "LRJG")
    private String lrjg;

    @Column(name = "YCYY")
    private String ycyy;

    @Column(name = "YCRQ")
    private Date ycrq;

    @Column(name = "YCJG")
    private String ycjg;

    @Column(name = "LYID")
    private BigDecimal lyid;

    @Column(name = "CJRQ")
    private Date cjrq;

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
     * @return LRYY
     */
    public String getLryy() {
        return lryy;
    }

    /**
     * @param lryy
     */
    public void setLryy(String lryy) {
        this.lryy = lryy;
    }

    /**
     * @return LRRQ
     */
    public Date getLrrq() {
        return lrrq;
    }

    /**
     * @param lrrq
     */
    public void setLrrq(Date lrrq) {
        this.lrrq = lrrq;
    }

    /**
     * @return LRJG
     */
    public String getLrjg() {
        return lrjg;
    }

    /**
     * @param lrjg
     */
    public void setLrjg(String lrjg) {
        this.lrjg = lrjg;
    }

    /**
     * @return YCYY
     */
    public String getYcyy() {
        return ycyy;
    }

    /**
     * @param ycyy
     */
    public void setYcyy(String ycyy) {
        this.ycyy = ycyy;
    }

    /**
     * @return YCRQ
     */
    public Date getYcrq() {
        return ycrq;
    }

    /**
     * @param ycrq
     */
    public void setYcrq(Date ycrq) {
        this.ycrq = ycrq;
    }

    /**
     * @return YCJG
     */
    public String getYcjg() {
        return ycjg;
    }

    /**
     * @param ycjg
     */
    public void setYcjg(String ycjg) {
        this.ycjg = ycjg;
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
}