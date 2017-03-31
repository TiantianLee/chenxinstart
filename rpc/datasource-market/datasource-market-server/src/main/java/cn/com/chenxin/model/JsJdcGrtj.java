package cn.com.chenxin.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "JS_JDC_GRTJ")
public class JsJdcGrtj {
    @Column(name = "CZ")
    private String cz;

    @Column(name = "GMSFHM")
    private String gmsfhm;

    @Column(name = "SJHM")
    private String sjhm;

    @Column(name = "CNT")
    private BigDecimal cnt;

    @Column(name = "PJ")
    private String pj;

    /**
     * @return CZ
     */
    public String getCz() {
        return cz;
    }

    /**
     * @param cz
     */
    public void setCz(String cz) {
        this.cz = cz;
    }

    /**
     * @return GMSFHM
     */
    public String getGmsfhm() {
        return gmsfhm;
    }

    /**
     * @param gmsfhm
     */
    public void setGmsfhm(String gmsfhm) {
        this.gmsfhm = gmsfhm;
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
     * @return CNT
     */
    public BigDecimal getCnt() {
        return cnt;
    }

    /**
     * @param cnt
     */
    public void setCnt(BigDecimal cnt) {
        this.cnt = cnt;
    }

    /**
     * @return PJ
     */
    public String getPj() {
        return pj;
    }

    /**
     * @param pj
     */
    public void setPj(String pj) {
        this.pj = pj;
    }
}