package com.lw.entity;

import java.io.Serializable;

public class Address implements Serializable {

    /*

Create Table

CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shouhuoren` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `isdefault` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8

     */

    private int id;
    private String shouHuoRen;
    private String phone;
    private String address;
    private int userid;
    private int isdefault;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShouHuoRen() {
        return shouHuoRen;
    }

    public void setShouHuoRen(String shouHuoRen) {
        this.shouHuoRen = shouHuoRen;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(int isdefault) {
        this.isdefault = isdefault;
    }

    public Address(int id, String shouHuoRen, String phone, String address, int userid, int isdefault) {
        this.id = id;
        this.shouHuoRen = shouHuoRen;
        this.phone = phone;
        this.address = address;
        this.userid = userid;
        this.isdefault = isdefault;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", shouHuoRen='" + shouHuoRen + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userid=" + userid +
                ", isdefault=" + isdefault +
                '}';
    }
}

