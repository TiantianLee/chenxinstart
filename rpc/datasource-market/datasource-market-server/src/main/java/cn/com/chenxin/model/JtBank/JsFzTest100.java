package cn.com.chenxin.model.JtBank;

import java.util.Date;
import javax.persistence.*;

@Table(name = "JS_FZ_TEST100")
public class JsFzTest100 {
    @Column(name = "XM")
    private String xm;

    @Column(name = "SJHM")
    private String sjhm;

    @Column(name = "DQ")
    private String dq;

    @Column(name = "JLX")
    private String jlx;

    @Column(name = "DZ")
    private String dz;

    @Column(name = "OUTDATE")
    private Date outdate;

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
     * @return DQ
     */
    public String getDq() {
        return dq;
    }

    /**
     * @param dq
     */
    public void setDq(String dq) {
        this.dq = dq;
    }

    /**
     * @return JLX
     */
    public String getJlx() {
        return jlx;
    }

    /**
     * @param jlx
     */
    public void setJlx(String jlx) {
        this.jlx = jlx;
    }

    /**
     * @return DZ
     */
    public String getDz() {
        return dz;
    }

    /**
     * @param dz
     */
    public void setDz(String dz) {
        this.dz = dz;
    }

    /**
     * @return OUTDATE
     */
    public Date getOutdate() {
        return outdate;
    }

    /**
     * @param outdate
     */
    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }
}