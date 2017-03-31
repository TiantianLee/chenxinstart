package cn.com.chenxin.model.GS;

import java.util.Date;
import javax.persistence.*;

@Table(name = "MORT_REG_INFO")
public class MortRegInfo {
    @Column(name = "MORREG_ID")
    private String morregId;

    @Column(name = "MORREGCNO")
    private String morregcno;

    @Column(name = "REGORG")
    private String regorg;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "REGIDATE")
    private String regidate;

    @Column(name = "MORCANREA")
    private String morcanrea;

    @Column(name = "CANDATE")
    private String candate;

    @Column(name = "PRIPID")
    private String pripid;

    @Column(name = "MORTGAGOR")
    private String mortgagor;

    @Column(name = "MORT_DOCTYPE")
    private String mortDoctype;

    @Column(name = "MORT_DOCID")
    private String mortDocid;

    @Column(name = "MORT_LOC")
    private String mortLoc;

    @Column(name = "MORE_TYPE")
    private String moreType;

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

    @Column(name = "ENTTYPE")
    private String enttype;

    @Column(name = "S_EXT_OCODE")
    private String sExtOcode;

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
     * @return MORREGCNO
     */
    public String getMorregcno() {
        return morregcno;
    }

    /**
     * @param morregcno
     */
    public void setMorregcno(String morregcno) {
        this.morregcno = morregcno;
    }

    /**
     * @return REGORG
     */
    public String getRegorg() {
        return regorg;
    }

    /**
     * @param regorg
     */
    public void setRegorg(String regorg) {
        this.regorg = regorg;
    }

    /**
     * @return TYPE
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return REGIDATE
     */
    public String getRegidate() {
        return regidate;
    }

    /**
     * @param regidate
     */
    public void setRegidate(String regidate) {
        this.regidate = regidate;
    }

    /**
     * @return MORCANREA
     */
    public String getMorcanrea() {
        return morcanrea;
    }

    /**
     * @param morcanrea
     */
    public void setMorcanrea(String morcanrea) {
        this.morcanrea = morcanrea;
    }

    /**
     * @return CANDATE
     */
    public String getCandate() {
        return candate;
    }

    /**
     * @param candate
     */
    public void setCandate(String candate) {
        this.candate = candate;
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
     * @return MORTGAGOR
     */
    public String getMortgagor() {
        return mortgagor;
    }

    /**
     * @param mortgagor
     */
    public void setMortgagor(String mortgagor) {
        this.mortgagor = mortgagor;
    }

    /**
     * @return MORT_DOCTYPE
     */
    public String getMortDoctype() {
        return mortDoctype;
    }

    /**
     * @param mortDoctype
     */
    public void setMortDoctype(String mortDoctype) {
        this.mortDoctype = mortDoctype;
    }

    /**
     * @return MORT_DOCID
     */
    public String getMortDocid() {
        return mortDocid;
    }

    /**
     * @param mortDocid
     */
    public void setMortDocid(String mortDocid) {
        this.mortDocid = mortDocid;
    }

    /**
     * @return MORT_LOC
     */
    public String getMortLoc() {
        return mortLoc;
    }

    /**
     * @param mortLoc
     */
    public void setMortLoc(String mortLoc) {
        this.mortLoc = mortLoc;
    }

    /**
     * @return MORE_TYPE
     */
    public String getMoreType() {
        return moreType;
    }

    /**
     * @param moreType
     */
    public void setMoreType(String moreType) {
        this.moreType = moreType;
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
     * @return ENTTYPE
     */
    public String getEnttype() {
        return enttype;
    }

    /**
     * @param enttype
     */
    public void setEnttype(String enttype) {
        this.enttype = enttype;
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