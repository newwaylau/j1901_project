package com.lw.entity;

import java.util.Date;

public class Order {
    /**
     *
     Create Table

     CREATE TABLE `t_order` (
     `id` int(11) NOT NULL,
     `o_sendtype` varchar(20) DEFAULT NULL,
     `o_paytype` varchar(20) DEFAULT NULL,
     `o_paycount` double(20,0) DEFAULT NULL,
     `o_orderdate` date DEFAULT NULL,
     `o_checkstate` int(11) DEFAULT NULL,
     `o_checkdate` date DEFAULT NULL,
     `o_checkperson` varchar(20) DEFAULT NULL,
     `userid` int(11) DEFAULT NULL,
     `o_shperson` varchar(20) DEFAULT NULL,
     `o_shphone` varchar(20) DEFAULT NULL,
     `o_shaddress` varchar(100) DEFAULT NULL,
     PRIMARY KEY (`id`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8

     */
    private int id;
    private String o_sendtype;
    private String o_paytype;
    private Date o_orderdate;
    private int o_checkstate;
    private Date o_checkdate;
    private String o_checkperson;
    private int userid;
    private String o_shperson;
    private String o_shphone;
    private String o_shaddress;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", o_sendtype='" + o_sendtype + '\'' +
                ", o_paytype='" + o_paytype + '\'' +
                ", o_orderdate=" + o_orderdate +
                ", o_checkstate=" + o_checkstate +
                ", o_checkdate=" + o_checkdate +
                ", o_checkperson='" + o_checkperson + '\'' +
                ", userid=" + userid +
                ", o_shperson='" + o_shperson + '\'' +
                ", o_shphone='" + o_shphone + '\'' +
                ", o_shaddress='" + o_shaddress + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getO_sendtype() {
        return o_sendtype;
    }

    public void setO_sendtype(String o_sendtype) {
        this.o_sendtype = o_sendtype;
    }

    public String getO_paytype() {
        return o_paytype;
    }

    public void setO_paytype(String o_paytype) {
        this.o_paytype = o_paytype;
    }

    public Date getO_orderdate() {
        return o_orderdate;
    }

    public void setO_orderdate(Date o_orderdate) {
        this.o_orderdate = o_orderdate;
    }

    public int getO_checkstate() {
        return o_checkstate;
    }

    public void setO_checkstate(int o_checkstate) {
        this.o_checkstate = o_checkstate;
    }

    public Date getO_checkdate() {
        return o_checkdate;
    }

    public void setO_checkdate(Date o_checkdate) {
        this.o_checkdate = o_checkdate;
    }

    public String getO_checkperson() {
        return o_checkperson;
    }

    public void setO_checkperson(String o_checkperson) {
        this.o_checkperson = o_checkperson;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getO_shperson() {
        return o_shperson;
    }

    public void setO_shperson(String o_shperson) {
        this.o_shperson = o_shperson;
    }

    public String getO_shphone() {
        return o_shphone;
    }

    public void setO_shphone(String o_shphone) {
        this.o_shphone = o_shphone;
    }

    public String getO_shaddress() {
        return o_shaddress;
    }

    public void setO_shaddress(String o_shaddress) {
        this.o_shaddress = o_shaddress;
    }

    public Order(int id, String o_sendtype, String o_paytype, Date o_orderdate, int o_checkstate, Date o_checkdate, String o_checkperson, int userid, String o_shperson, String o_shphone, String o_shaddress) {
        this.id = id;
        this.o_sendtype = o_sendtype;
        this.o_paytype = o_paytype;
        this.o_orderdate = o_orderdate;
        this.o_checkstate = o_checkstate;
        this.o_checkdate = o_checkdate;
        this.o_checkperson = o_checkperson;
        this.userid = userid;
        this.o_shperson = o_shperson;
        this.o_shphone = o_shphone;
        this.o_shaddress = o_shaddress;
    }

    public Order() {
    }
}
