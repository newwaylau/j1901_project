package com.lw.dao;

import com.lw.entity.GoodsInfo;

import java.util.List;

public interface GoodsInfoDao {
    List<GoodsInfo> getGoodsInfoList();

    Integer getUserTotalCount();

    List<GoodsInfo> getUserList(int i, Integer pageSize);

    int updateObject(GoodsInfo goodsInfo);

    GoodsInfo getShowById(int id);

    void batchDel(String[] ids);

    int deleteGoodsInfo(int id);

    List<GoodsInfo> getGoodsInfoParent();

    int addGoodsInfo(String goods_name, int goods_parentid, int goods_fatherid, int goods_price, int goods_price_off, String goods_pic, String goods_description);

    GoodsInfo getShowByNone();

    int addGoodsInfo1(String goods_name1, String goods_price1, String goods_price_off1, String goods_description1, String goods_pic1);
}
