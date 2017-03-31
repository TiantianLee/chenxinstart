package cn.com.chenxin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_SFHC_XM_SJHM")
public class JsSfhcXmSjhm {
    @Column(name = "XM")
    private String xm;

    @Column(name = "SJHM")
    private String sjhm;

    @Column(name = "CJRQ")
    private Date cjrq;

    /**
     * @return XM
     */
    public String getXm() {
        return xm;
    }

    /**
     * @param xm
     */
    public void setXm(String xm) {
        this.xm = xm;
    }

    /**
     * @return SJHM
     */
    public String getSjhm() {
        return sjhm;
    }

    /**
     * @param sjhm
     */
    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
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