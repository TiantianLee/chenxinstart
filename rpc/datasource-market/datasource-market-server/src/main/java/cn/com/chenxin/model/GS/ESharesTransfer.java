package cn.com.chenxin.model.GS;

import java.util.Date;
import javax.persistence.*;

@Table(name = "E_SHARES_TRANSFER")
public class ESharesTransfer {
    @Column(name = "S_EXT_NODENUM")
    private String sExtNodenum;

    @Column(name = "PRIPID")
    private String pripid;

    @Column(name = "TRA_ID")
    private String traId;

    @Column(name = "ALIENID")
    private String alienid;

    @Column(name = "ALIEN")
    private String alien;

    @Column(name = "CERTYPE")
    private String certype;

    @Column(name = "CERNO")
    private String cerno;

    @Column(name = "TRANAM")
    private String tranam;

    @Column(name = "TRANAMPR")
    private String tranampr;

    @Column(name = "TRANDATE")
    private String trandate;

    @Column(name = "TRANTYPE")
    private String trantype;

    @Column(name = "S_EXT_TIMESTAMP")
    private Date sExtTimestamp;

    @Column(name = "S_EXT_BATCH")
    private String sExtBatch;

    @Column(name = "S_EXT_SEQUENCE")
    private String sExtSequence;

    @Column(name = "S_EXT_VALIDFLAG")
    private String sExtValidflag;

    @Column(name = "INVID")
    private String invid;

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
     * @return TRA_ID
     */
    public String getTraId() {
        return traId;
    }

    /**
     * @param traId
     */
    public void setTraId(String traId) {
        this.traId = traId;
    }

    /**
     * @return ALIENID
     */
    public String getAlienid() {
        return alienid;
    }

    /**
     * @param alienid
     */
    public void setAlienid(String alienid) {
        this.alienid = alienid;
    }

    /**
     * @return ALIEN
     */
    public String getAlien() {
        return alien;
    }

    /**
     * @param alien
     */
    public void setAlien(String alien) {
        this.alien = alien;
    }

    /**
     * @return CERTYPE
     */
    public String getCertype() {
        return certype;
    }

    /**
     * @param certype
     */
    public void setCertype(String certype) {
        this.certype = certype;
    }

    /**
     * @return CERNO
     */
    public String getCerno() {
        return cerno;
    }

    /**
     * @param cerno
     */
    public void setCerno(String cerno) {
        this.cerno = cerno;
    }

    /**
     * @return TRANAM
     */
    public String getTranam() {
        return tranam;
    }

    /**
     * @param tranam
     */
    public void setTranam(String tranam) {
        this.tranam = tranam;
    }

    /**
     * @return TRANAMPR
     */
    public String getTranampr() {
        return tranampr;
    }

    /**
     * @param tranampr
     */
    public void setTranampr(String tranampr) {
        this.tranampr = tranampr;
    }

    /**
     * @return TRANDATE
     */
    public String getTrandate() {
        return trandate;
    }

    /**
     * @param trandate
     */
    public void setTrandate(String trandate) {
        this.trandate = trandate;
    }

    /**
     * @return TRANTYPE
     */
    public String getTrantype() {
        return trantype;
    }

    /**
     * @param trantype
     */
    public void setTrantype(String trantype) {
        this.trantype = trantype;
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

    /**
     * @return INVID
     */
    public String getInvid() {
        return invid;
    }

    /**
     * @param invid
     */
    public void setInvid(String invid) {
        this.invid = invid;
    }
}