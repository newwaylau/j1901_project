package com.lw.entity;

import java.util.Date;

public class OrderDetail {
    /**
     *
     Create Table

     CREATE TABLE `t_order_detail` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `goods_date` date DEFAULT NULL,
     `o_orderid` int(11) DEFAULT NULL,
     `goodsid` int(11) DEFAULT NULL,
     `goodsname` varchar(20) DEFAULT NULL,
     `goodsprice` double(20,2) DEFAULT NULL,
     `goods_description` varchar(100) DEFAULT NULL,
     `goodsnum` int(20) DEFAULT NULL,
     `goodspic` varchar(100) DEFAULT NULL,
     `goods_total_price` double(20,2) DEFAULT NULL,
     PRIMARY KEY (`id`),
     KEY `FK_ORDER` (`o_orderid`)
     ) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8

     */
    private int id;
    private Date goods_date;
    private int o_orderid;
    private int goodsid;
    private String goodsname;
    private double goodsprice;
    private String goods_description;
    private int goodsnum;
    private String goodspic;
    private double goods_total_price;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", goods_date=" + goods_date +
                ", o_orderid=" + o_orderid +
                ", goodsid=" + goodsid +
                ", goodsname='" + goodsname + '\'' +
                ", goodsprice=" + goodsprice +
                ", goods_description='" + goods_description + '\'' +
                ", goodsnum=" + goodsnum +
                ", goodspic='" + goodspic + '\'' +
                ", goods_total_price=" + goods_total_price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGoods_date() {
        return goods_date;
    }

    public void setGoods_date(Date goods_date) {
        this.goods_date = goods_date;
    }

    public int getO_orderid() {
        return o_orderid;
    }

    public void setO_orderid(int o_orderid) {
        this.o_orderid = o_orderid;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoods_description() {
        return goods_description;
    }

    public void setGoods_description(String goods_description) {
        this.goods_description = goods_description;
    }

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
        this.goodsnum = goodsnum;
    }

    public String getGoodspic() {
        return goodspic;
    }

    public void setGoodspic(String goodspic) {
        this.goodspic = goodspic;
    }

    public double getGoods_total_price() {
        return goods_total_price;
    }

    public void setGoods_total_price(double goods_total_price) {
        this.goods_total_price = goods_total_price;
    }

    public OrderDetail(int id, Date goods_date, int o_orderid, int goodsid, String goodsname, double goodsprice, String goods_description, int goodsnum, String goodspic, double goods_total_price) {
        this.id = id;
        this.goods_date = goods_date;
        this.o_orderid = o_orderid;
        this.goodsid = goodsid;
        this.goodsname = goodsname;
        this.goodsprice = goodsprice;
        this.goods_description = goods_description;
        this.goodsnum = goodsnum;
        this.goodspic = goodspic;
        this.goods_total_price = goods_total_price;
    }

    public OrderDetail() {
    }
}
