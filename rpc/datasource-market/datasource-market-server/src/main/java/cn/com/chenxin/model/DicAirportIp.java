package cn.com.chenxin.model;

import javax.persistence.*;

@Table(name = "DIC_AIRPORT_IP")
public class DicAirportIp {
    @Column(name = "PORT_NAME")
    private String portName;

    @Column(name = "IP_ADDR")
    private String ipAddr;

    /**
     * @return PORT_NAME
     */
    public String getPortName() {
        return portName;
    }

    /**
     * @param portName
     */
    public void setPortName(String portName) {
        this.portName = portName;
    }

    /**
     * @return IP_ADDR
     */
    public String getIpAddr() {
        return ipAddr;
    }

    /**
     * @param ipAddr
     */
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
}