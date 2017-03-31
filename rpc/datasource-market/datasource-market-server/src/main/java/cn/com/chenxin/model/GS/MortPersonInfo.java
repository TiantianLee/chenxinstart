package cn.com.chenxin.model.GS;

import java.util.Date;
import javax.persistence.*;

@Table(name = "MORT_PERSON_INFO")
public class MortPersonInfo {
    @Column(name = "MORE_ID")
    private String moreId;

    @Column(name = "MORREG_ID")
    private String morregId;

    @Column(name = "PRIPID")
    private String pripid;

    @Column(name = "MORE")
    private String more;

    @Column(name = "BLICTYPE")
    private String blictype;

    @Column(name = "BLICNO")
    private String blicno;

    @Column(name = "MOR_LOC")
    private String morLoc;

    @Column(name = "S_EXT_NODENUM")
    private String sExtNodenum;

    @Column(name = "S_EXT_TIMESTAMP")
    private Date sExtTimestamp;

    @Column(name = "S_EXT_BATCH")
    private String sExtBatch;

    @Column(name = "S_EXT_SEQUENCE")
    private String sExtSequence;

    @Column(name = "S_EXT_VALIDFLAG")
    private String sExtValidflag;

    @Column(name = "S_EXT_ICODE")
    private String sExtIcode;

    @Column(name = "S_EXT_CODETIME")
    private Date sExtCodetime;

    @Column(name = "S_EXT_OCODE")
    private String sExtOcode;

    /**
     * @return MORE_ID
     */
    public String getMoreId() {
        return moreId;
    }

    /**
     * @param moreId
     */
    public void setMoreId(String moreId) {
        this.moreId = moreId;
    }

    /**
     * @return MORREG_ID
     */
    public String getMorregId() {
        return morregId;
    }

    /**
     * @param morregId
     */
    public void setMorregId(String morregId) {
        this.morregId = morregId;
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
     * @return MORE
     */
    public String getMore() {
        return more;
    }

    /**
     * @param more
     */
    public void setMore(String more) {
        this.more = more;
    }

    /**
     * @return BLICTYPE
     */
    public String getBlictype() {
        return blictype;
    }

    /**
     * @param blictype
     */
    public void setBlictype(String blictype) {
        this.blictype = blictype;
    }

    /**
     * @return BLICNO
     */
    public String getBlicno() {
        return blicno;
    }

    /**
     * @param blicno
     */
    public void setBlicno(String blicno) {
        this.blicno = blicno;
    }

    /**
     * @return MOR_LOC
     */
    public String getMorLoc() {
        return morLoc;
    }

    /**
     * @param morLoc
     */
    public void setMorLoc(String morLoc) {
        this.morLoc = morLoc;
    }

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
     * @return S_EXT_ICODE
     */
    public String getsExtIcode() {
        return sExtIcode;
    }

    /**
     * @param sExtIcode
     */
    public void setsExtIcode(String sExtIcode) {
        this.sExtIcode = sExtIcode;
    }

    /**
     * @return S_EXT_CODETIME
     */
    public Date getsExtCodetime() {
        return sExtCodetime;
    }

    /**
     * @param sExtCodetime
     */
    public void setsExtCodetime(Date sExtCodetime) {
        this.sExtCodetime = sExtCodetime;
    }

    /**
     * @return S_EXT_OCODE
     */
    public String getsExtOcode() {
        return sExtOcode;
    }

    /**
     * @param sExtOcode
     */
    public void setsExtOcode(String sExtOcode) {
        this.sExtOcode = sExtOcode;
    }
}