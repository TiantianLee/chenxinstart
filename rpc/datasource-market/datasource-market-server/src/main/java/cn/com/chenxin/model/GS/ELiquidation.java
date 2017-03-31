package cn.com.chenxin.model.GS;

import java.util.Date;
import javax.persistence.*;

@Table(name = "E_LIQUIDATION")
public class ELiquidation {
    @Column(name = "S_EXT_NODENUM")
    private String sExtNodenum;

    @Column(name = "PRIPID")
    private String pripid;

    @Column(name = "LIGENTITY")
    private String ligentity;

    @Column(name = "LIGPRINCIPAL")
    private String ligprincipal;

    @Column(name = "LIQMEN")
    private String liqmen;

    @Column(name = "ADDR")
    private String addr;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "LIGST")
    private String ligst;

    @Column(name = "LIGENDDATE")
    private String ligenddate;

    @Column(name = "DEBTTRANEE")
    private String debttranee;

    @Column(name = "CLAIMTRANEE")
    private String claimtranee;

    @Column(name = "S_EXT_TIMESTAMP")
    private Date sExtTimestamp;

    @Column(name = "S_EXT_BATCH")
    private String sExtBatch;

    @Column(name = "S_EXT_SEQUENCE")
    private String sExtSequence;

    @Column(name = "S_EXT_VALIDFLAG")
    private String sExtValidflag;

    /**
     * @return S_EXT_NODENUM
     */
    public String getsExtNodenum() {
        return sExtNodenum;
    }

    /**
     * @param sExtNodenum
     */
    public void setsExtNodenum(String sExtNodenum) {
        this.sExtNodenum = sExtNodenum;
    }

    /**
     * @return PRIPID
     */
    public String getPripid() {
        return pripid;
    }

    /**
     * @param pripid
     */
    public void setPripid(String pripid) {
        this.pripid = pripid;
    }

    /**
     * @return LIGENTITY
     */
    public String getLigentity() {
        return ligentity;
    }

    /**
     * @param ligentity
     */
    public void setLigentity(String ligentity) {
        this.ligentity = ligentity;
    }

    /**
     * @return LIGPRINCIPAL
     */
    public String getLigprincipal() {
        return ligprincipal;
    }

    /**
     * @param ligprincipal
     */
    public void setLigprincipal(String ligprincipal) {
        this.ligprincipal = ligprincipal;
    }

    /**
     * @return LIQMEN
     */
    public String getLiqmen() {
        return liqmen;
    }

    /**
     * @param liqmen
     */
    public void setLiqmen(String liqmen) {
        this.liqmen = liqmen;
    }

    /**
     * @return ADDR
     */
    public String getAddr() {
        return addr;
    }

    /**
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * @return TEL
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return LIGST
     */
    public String getLigst() {
        return ligst;
    }

    /**
     * @param ligst
     */
    public void setLigst(String ligst) {
        this.ligst = ligst;
    }

    /**
     * @return LIGENDDATE
     */
    public String getLigenddate() {
        return ligenddate;
    }

    /**
     * @param ligenddate
     */
    public void setLigenddate(String ligenddate) {
        this.ligenddate = ligenddate;
    }

    /**
     * @return DEBTTRANEE
     */
    public String getDebttranee() {
        return debttranee;
    }

    /**
     * @param debttranee
     */
    public void setDebttranee(String debttranee) {
        this.debttranee = debttranee;
    }

    /**
     * @return CLAIMTRANEE
     */
    public String getClaimtranee() {
        return claimtranee;
    }

    /**
     * @param claimtranee
     */
    public void setClaimtranee(String claimtranee) {
        this.claimtranee = claimtranee;
    }

    /**
     * @return S_EXT_TIMESTAMP
     */
    public Date getsExtTimestamp() {
        return sExtTimestamp;
    }

    /**
     * @param sExtTimestamp
     */
    public void setsExtTimestamp(Date sExtTimestamp) {
        this.sExtTimestamp = sExtTimestamp;
    }

    /**
     * @return S_EXT_BATCH
     */
    public String getsExtBatch() {
        return sExtBatch;
    }

    /**
     * @param sExtBatch
     */
    public void setsExtBatch(String sExtBatch) {
        this.sExtBatch = sExtBatch;
    }

    /**
     * @return S_EXT_SEQUENCE
     */
    public String getsExtSequence() {
        return sExtSequence;
    }

    /**
     * @param sExtSequence
     */
    public void setsExtSequence(String sExtSequence) {
        this.sExtSequence = sExtSequence;
    }

    /**
     * @return S_EXT_VALIDFLAG
     */
    public String getsExtValidflag() {
        return sExtValidflag;
    }

    /**
     * @param sExtValidflag
     */
    public void setsExtValidflag(String sExtValidflag) {
        this.sExtValidflag = sExtValidflag;
    }
}