package cn.com.chenxin.model;

import javax.persistence.*;

@Table(name = "DM_XZQH2013_WYDQ")
public class DmXzqh2013Wydq {
    @Column(name = "SF")
    private String sf;

    @Column(name = "DQ")
    private String dq;

    @Column(name = "JB")
    private String jb;

    /**
     * @return SF
     */
    public String getSf() {
        return sf;
    }

    /**
     * @param sf
     */
    public void setSf(String sf) {
        this.sf = sf;
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
     * @return JB
     */
    public String getJb() {
        return jb;
    }

    /**
     * @param jb
     */
    public void setJb(String jb) {
        this.jb = jb;
    }
}