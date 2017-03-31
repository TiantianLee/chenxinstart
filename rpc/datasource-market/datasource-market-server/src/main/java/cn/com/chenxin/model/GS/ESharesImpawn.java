package cn.com.chenxin.model.GS;

import java.util.Date;
import javax.persistence.*;

@Table(name = "E_SHARES_IMPAWN")
public class ESharesImpawn {
    @Column(name = "S_EXT_NODENUM")
    private String sExtNodenum;

    @Column(name = "PRIPID")
    private String pripid;

    @Column(name = "IMPORG_ID")
    private String imporgId;

    @Column(name = "IMPORG")
    private String imporg;

    @Column(name = "IMPORGTYPE")
    private String imporgtype;

    @Column(name = "IMPAM")
    private String impam;

    @Column(name = "IMPONRECDATE")
    private String imponrecdate;

    @Column(name = "IMPEXAEEP")
    private String impexaeep;

    @Column(name = "IMPSANDATE")
    private String impsandate;

    @Column(name = "IMPTO")
    private String impto;

    @Column(name = "EXESTATE")
    private String exestate;

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
     * @return IMPORG_ID
     */
    public String getImporgId() {
        return imporgId;
    }

    /**
     * @param imporgId
     */
    public void setImporgId(String imporgId) {
        this.imporgId = imporgId;
    }

    /**
     * @return IMPORG
     */
    public String getImporg() {
        return imporg;
    }

    /**
     * @param imporg
     */
    public void setImporg(String imporg) {
        this.imporg = imporg;
    }

    /**
     * @return IMPORGTYPE
     */
    public String getImporgtype() {
        return imporgtype;
    }

    /**
     * @param imporgtype
     */
    public void setImporgtype(String imporgtype) {
        this.imporgtype = imporgtype;
    }

    /**
     * @return IMPAM
     */
    public String getImpam() {
        return impam;
    }

    /**
     * @param impam
     */
    public void setImpam(String impam) {
        this.impam = impam;
    }

    /**
     * @return IMPONRECDATE
     */
    public String getImponrecdate() {
        return imponrecdate;
    }

    /**
     * @param imponrecdate
     */
    public void setImponrecdate(String imponrecdate) {
        this.imponrecdate = imponrecdate;
    }

    /**
     * @return IMPEXAEEP
     */
    public String getImpexaeep() {
        return impexaeep;
    }

    /**
     * @param impexaeep
     */
    public void setImpexaeep(String impexaeep) {
        this.impexaeep = impexaeep;
    }

    /**
     * @return IMPSANDATE
     */
    public String getImpsandate() {
        return impsandate;
    }

    /**
     * @param impsandate
     */
    public void setImpsandate(String impsandate) {
        this.impsandate = impsandate;
    }

    /**
     * @return IMPTO
     */
    public String getImpto() {
        return impto;
    }

    /**
     * @param impto
     */
    public void setImpto(String impto) {
        this.impto = impto;
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