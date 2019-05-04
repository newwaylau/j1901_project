package com.lw.entity;

public class GoodsInfoDoMain {

    /**
     * 商品id
     */
    private int id;
    /**
     * 商品名字
     */
    private String goods_name;
    /**
     * 商品描述
     */
    private String goods_description;
    /**
     * 商品图片的名字
     */
    private String goods_pic;
    /**
     * 商品的原价
     */
    private double goods_price;
    /**
     * 商品库存
     */
    private Integer goods_stock;
    /**
     * 商品的折扣价
     */
    private int goods_price_off;
    /**
     * 商品的折扣
     */
    private double goods_discount;
    /**
     * 商品所属的类别(小类)
     */
    private int goods_fatherid;
    /**
     * 商品所属小类的大类别
     */
    private int goods_parentid;
    private int flag;

    //商品的数量
    private int count;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_description() {
        return goods_description;
    }

    public void setGoods_description(String goods_description) {
        this.goods_description = goods_description;
    }

    public String getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(Integer goods_stock) {
        this.goods_stock = goods_stock;
    }

    public int getGoods_price_off() {
        return goods_price_off;
    }

    public void setGoods_price_off(int goods_price_off) {
        this.goods_price_off = goods_price_off;
    }

    public double getGoods_discount() {
        return goods_discount;
    }

    public void setGoods_discount(double goods_discount) {
        this.goods_discount = goods_discount;
    }

    public int getGoods_fatherid() {
        return goods_fatherid;
    }

    public void setGoods_fatherid(int goods_fatherid) {
        this.goods_fatherid = goods_fatherid;
    }

    public int getGoods_parentid() {
        return goods_parentid;
    }

    public void setGoods_parentid(int goods_parentid) {
        this.goods_parentid = goods_parentid;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public GoodsInfoDoMain(int id, String goods_name, String goods_description, String goods_pic, double goods_price, Integer goods_stock, int goods_price_off, double goods_discount, int goods_fatherid, int goods_parentid, int flag, int count) {

        this.id = id;
        this.goods_name = goods_name;
        this.goods_description = goods_description;
        this.goods_pic = goods_pic;
        this.goods_price = goods_price;
        this.goods_stock = goods_stock;
        this.goods_price_off = goods_price_off;
        this.goods_discount = goods_discount;
        this.goods_fatherid = goods_fatherid;
        this.goods_parentid = goods_parentid;
        this.flag = flag;
        this.count = count;
    }

    public GoodsInfoDoMain() {
    }

    @Override
    public String toString() {
        return "GoodsInfoDoMain{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_description='" + goods_description + '\'' +
                ", goods_pic='" + goods_pic + '\'' +
                ", goods_price=" + goods_price +
                ", goods_stock=" + goods_stock +
                ", goods_price_off=" + goods_price_off +
                ", goods_discount=" + goods_discount +
                ", goods_fatherid=" + goods_fatherid +
                ", goods_parentid=" + goods_parentid +
                ", flag=" + flag +
                ", count=" + count +
                '}';
    }
}
