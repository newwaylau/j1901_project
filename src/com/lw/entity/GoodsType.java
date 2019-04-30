package com.lw.entity;

public class GoodsType {
    /**
     *
     Create Table

     CREATE TABLE `t_goods_type` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `name` varchar(30) DEFAULT NULL,
     `parent_id` int(11) DEFAULT NULL,
     `pic` varchar(100) DEFAULT NULL,
     `flag` int(2) DEFAULT '1',
     PRIMARY KEY (`id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8

     */
    private int id;
    private String name;
    private int parent_id;
    private String pic;
    private int flag;
    private GoodsInfo goods_name;

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent_id=" + parent_id +
                ", pic='" + pic + '\'' +
                ", flag=" + flag +
                ", goods_name=" + goods_name +
                '}';
    }

    public GoodsInfo getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(GoodsInfo goods_name) {
        this.goods_name = goods_name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public GoodsType(int id, String name, int parent_id, String pic) {
        this.id = id;
        this.name = name;
        this.parent_id = parent_id;
        this.pic = pic;
    }

    public GoodsType() {
    }
}
