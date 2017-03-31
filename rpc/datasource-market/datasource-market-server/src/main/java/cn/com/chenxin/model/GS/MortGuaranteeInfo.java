package cn.com.chenxin.model.GS;

import java.util.Date;
import javax.persistence.*;

@Table(name = "MORT_GUARANTEE_INFO")
public class MortGuaranteeInfo {
    @Column(name = "GUA_ID")
    private String guaId;

    @Column(name = "MORREG_ID")
    private String morregId;

    @Column(name = "GUANAME")
    private String guaname;

    @Column(name = "OWN")
    private String own;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "GUADES")
    private String guades;

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

    /**
     * @return GUA_ID
     */
    public String getGuaId() {
        return guaId;
    }

    /**
     * @param guaId
     */
    public void setGuaId(String guaId) {
        this.guaId = guaId;
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
     * @return GUANAME
     */
    public String getGuaname() {
        return guaname;
    }

    /**
     * @param guaname
     */
    public void setGuaname(String guaname) {
        this.guaname = guaname;
    }

    /**
     * @return OWN
     */
    public String getOwn() {
        return own;
    }

    /**
     * @param own
     */
    public void setOwn(String own) {
        this.own = own;
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
     * @return GUADES
     */
    public String getGuades() {
        return guades;
    }

    /**
     * @param guades
     */
    public void setGuades(String guades) {
        this.guades = guades;
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
}