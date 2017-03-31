package cn.com.chenxin.model.GS;

import java.util.Date;
import javax.persistence.*;

@Table(name = "MORT_PRINCIPAL_CLAIM")
public class MortPrincipalClaim {
    @Column(name = "MORREG_ID")
    private String morregId;

    @Column(name = "PRICLASECKIND")
    private String priclaseckind;

    @Column(name = "PRICLASECAM")
    private String priclasecam;

    @Column(name = "WARCOV")
    private String warcov;

    @Column(name = "PEFPERFORM")
    private String pefperform;

    @Column(name = "PEFPERTO")
    private String pefperto;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "REGCAPCUR")
    private String regcapcur;

    @Column(name = "S_EXT_NODENUM")
    private String sExtNodenum;

    @Column(name = "S_EXT_TIMESTAMP")
    private String sExtTimestamp;

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
     * @return PRICLASECKIND
     */
    public String getPriclaseckind() {
        return priclaseckind;
    }

    /**
     * @param priclaseckind
     */
    public void setPriclaseckind(String priclaseckind) {
        this.priclaseckind = priclaseckind;
    }

    /**
     * @return PRICLASECAM
     */
    public String getPriclasecam() {
        return priclasecam;
    }

    /**
     * @param priclasecam
     */
    public void setPriclasecam(String priclasecam) {
        this.priclasecam = priclasecam;
    }

    /**
     * @return WARCOV
     */
    public String getWarcov() {
        return warcov;
    }

    /**
     * @param warcov
     */
    public void setWarcov(String warcov) {
        this.warcov = warcov;
    }

    /**
     * @return PEFPERFORM
     */
    public String getPefperform() {
        return pefperform;
    }

    /**
     * @param pefperform
     */
    public void setPefperform(String pefperform) {
        this.pefperform = pefperform;
    }

    /**
     * @return PEFPERTO
     */
    public String getPefperto() {
        return pefperto;
    }

    /**
     * @param pefperto
     */
    public void setPefperto(String pefperto) {
        this.pefperto = pefperto;
    }

    /**
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return REGCAPCUR
     */
    public String getRegcapcur() {
        return regcapcur;
    }

    /**
     * @param regcapcur
     */
    public void setRegcapcur(String regcapcur) {
        this.regcapcur = regcapcur;
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
    public String getsExtTimestamp() {
        return sExtTimestamp;
    }

    /**
     * @param sExtTimestamp
     */
    public void setsExtTimestamp(String sExtTimestamp) {
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
}