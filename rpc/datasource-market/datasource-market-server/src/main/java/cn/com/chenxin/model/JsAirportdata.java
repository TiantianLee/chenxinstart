package cn.com.chenxin.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_AIRPORTDATA")
public class JsAirportdata {
    @Column(name = "MSGTYPE")
    private String msgtype;

    @Column(name = "IP")
    private String ip;

    @Column(name = "MAC")
    private String mac;

    @Column(name = "VLANNO")
    private String vlanno;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "IDTYPE")
    private String idtype;

    @Column(name = "IDNUM")
    private String idnum;

    @Column(name = "USERID")
    private String userid;

    @Column(name = "VISITTIME")
    private Date visittime;

    @Column(name = "IDTYPESTRING")
    private String idtypestring;

    @Column(name = "MSGTYPESTRING")
    private String msgtypestring;

    @Column(name = "ID")
    @SequenceGenerator(name="",sequenceName="Oracle")
    private BigDecimal id;

    @Column(name = "CREATETIME")
    private Date createtime;

    @Column(name = "IPINT")
    private BigDecimal ipint;

    @Column(name = "OFFTIME")
    private Date offtime;

    @Column(name = "REMOTEIP")
    private String remoteip;

    /**
     * @return MSGTYPE
     */
    public String getMsgtype() {
        return msgtype;
    }

    /**
     * @param msgtype
     */
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    /**
     * @return IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return MAC
     */
    public String getMac() {
        return mac;
    }

    /**
     * @param mac
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * @return VLANNO
     */
    public String getVlanno() {
        return vlanno;
    }

    /**
     * @param vlanno
     */
    public void setVlanno(String vlanno) {
        this.vlanno = vlanno;
    }

    /**
     * @return USERNAME
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return IDTYPE
     */
    public String getIdtype() {
        return idtype;
    }

    /**
     * @param idtype
     */
    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    /**
     * @return IDNUM
     */
    public String getIdnum() {
        return idnum;
    }

    /**
     * @param idnum
     */
    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    /**
     * @return USERID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return VISITTIME
     */
    public Date getVisittime() {
        return visittime;
    }

    /**
     * @param visittime
     */
    public void setVisittime(Date visittime) {
        this.visittime = visittime;
    }

    /**
     * @return IDTYPESTRING
     */
    public String getIdtypestring() {
        return idtypestring;
    }

    /**
     * @param idtypestring
     */
    public void setIdtypestring(String idtypestring) {
        this.idtypestring = idtypestring;
    }

    /**
     * @return MSGTYPESTRING
     */
    public String getMsgtypestring() {
        return msgtypestring;
    }

    /**
     * @param msgtypestring
     */
    public void setMsgtypestring(String msgtypestring) {
        this.msgtypestring = msgtypestring;
    }

    /**
     * @return ID
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return CREATETIME
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return IPINT
     */
    public BigDecimal getIpint() {
        return ipint;
    }

    /**
     * @param ipint
     */
    public void setIpint(BigDecimal ipint) {
        this.ipint = ipint;
    }

    /**
     * @return OFFTIME
     */
    public Date getOfftime() {
        return offtime;
    }

    /**
     * @param offtime
     */
    public void setOfftime(Date offtime) {
        this.offtime = offtime;
    }

    /**
     * @return REMOTEIP
     */
    public String getRemoteip() {
        return remoteip;
    }

    /**
     * @param remoteip
     */
    public void setRemoteip(String remoteip) {
        this.remoteip = remoteip;
    }
}