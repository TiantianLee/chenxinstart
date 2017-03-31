package cn.com.chenxin.model.GS;

import java.util.Date;
import javax.persistence.*;

@Table(name = "E_SHARES_FROST")
public class ESharesFrost {
    @Column(name = "S_EXT_NODENUM")
    private String sExtNodenum;

    @Column(name = "PRIPID")
    private String pripid;

    @Column(name = "FRO_ID")
    private String froId;

    @Column(name = "FROAM")
    private String froam;

    @Column(name = "SHARFROPROP")
    private String sharfroprop;

    @Column(name = "FROAUTH")
    private String froauth;

    @Column(name = "FROFROM")
    private String frofrom;

    @Column(name = "FROTO")
    private String froto;

    @Column(name = "FRODOCNO")
    private String frodocno;

    @Column(name = "FROREASON")
    private String froreason;

    @Column(name = "EXESTATE")
    private String exestate;

    @Column(name = "CORENTNAME")
    private String corentname;

    @Column(name = "THAWAUTH")
    private String thawauth;

    @Column(name = "THAWDOCNO")
    private String thawdocno;

    @Column(name = "THAWDATE")
    private String thawdate;

    @Column(name = "FROZSIGN")
    private String frozsign;

    @Column(name = "THAWCOMMENT")
    private String thawcomment;

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
     * @return FRO_ID
     */
    public String getFroId() {
        return froId;
    }

    /**
     * @param froId
     */
    public void setFroId(String froId) {
        this.froId = froId;
    }

    /**
     * @return FROAM
     */
    public String getFroam() {
        return froam;
    }

    /**
     * @param froam
     */
    public void setFroam(String froam) {
        this.froam = froam;
    }

    /**
     * @return SHARFROPROP
     */
    public String getSharfroprop() {
        return sharfroprop;
    }

    /**
     * @param sharfroprop
     */
    public void setSharfroprop(String sharfroprop) {
        this.sharfroprop = sharfroprop;
    }

    /**
     * @return FROAUTH
     */
    public String getFroauth() {
        return froauth;
    }

    /**
     * @param froauth
     */
    public void setFroauth(String froauth) {
        this.froauth = froauth;
    }

    /**
     * @return FROFROM
     */
    public String getFrofrom() {
        return frofrom;
    }

    /**
     * @param frofrom
     */
    public void setFrofrom(String frofrom) {
        this.frofrom = frofrom;
    }

    /**
     * @return FROTO
     */
    public String getFroto() {
        return froto;
    }

    /**
     * @param froto
     */
    public void setFroto(String froto) {
        this.froto = froto;
    }

    /**
     * @return FRODOCNO
     */
    public String getFrodocno() {
        return frodocno;
    }

    /**
     * @param frodocno
     */
    public void setFrodocno(String frodocno) {
        this.frodocno = frodocno;
    }

    /**
     * @return FROREASON
     */
    public String getFroreason() {
        return froreason;
    }

    /**
     * @param froreason
     */
    public void setFroreason(String froreason) {
        this.froreason = froreason;
    }

    /**
     * @return EXESTATE
     */
    public String getExestate() {
        return exestate;
    }

    /**
     * @param exestate
     */
    public void setExestate(String exestate) {
        this.exestate = exestate;
    }

    /**
     * @return CORENTNAME
     */
    public String getCorentname() {
        return corentname;
    }

    /**
     * @param corentname
     */
    public void setCorentname(String corentname) {
        this.corentname = corentname;
    }

    /**
     * @return THAWAUTH
     */
    public String getThawauth() {
        return thawauth;
    }

    /**
     * @param thawauth
     */
    public void setThawauth(String thawauth) {
        this.thawauth = thawauth;
    }

    /**
     * @return THAWDOCNO
     */
    public String getThawdocno() {
        return thawdocno;
    }

    /**
     * @param thawdocno
     */
    public void setThawdocno(String thawdocno) {
        this.thawdocno = thawdocno;
    }

    /**
     * @return THAWDATE
     */
    public String getThawdate() {
        return thawdate;
    }

    /**
     * @param thawdate
     */
    public void setThawdate(String thawdate) {
        this.thawdate = thawdate;
    }

    /**
     * @return FROZSIGN
     */
    public String getFrozsign() {
        return frozsign;
    }

    /**
     * @param frozsign
     */
    public void setFrozsign(String frozsign) {
        this.frozsign = frozsign;
    }

    /**
     * @return THAWCOMMENT
     */
    public String getThawcomment() {
        return thawcomment;
    }

    /**
     * @param thawcomment
     */
    public void setThawcomment(String thawcomment) {
        this.thawcomment = thawcomment;
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