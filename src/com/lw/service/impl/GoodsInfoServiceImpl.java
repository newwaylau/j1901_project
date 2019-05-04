package com.lw.service.impl;

import com.lw.dao.GoodsInfoDao;
import com.lw.dao.GoodsInfoDaoExtends;
import com.lw.dao.impl.GoodsInfoDaoExtendsImpl;
import com.lw.dao.impl.GoodsInfoDaoImpl;
import com.lw.entity.GoodsInfo;
import com.lw.entity.Page;
import com.lw.service.GoodsInfoService;

import java.util.List;

public class GoodsInfoServiceImpl implements GoodsInfoService {
    private GoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
    private GoodsInfoDaoExtends goodsInfoDaoExtends = new GoodsInfoDaoExtendsImpl();
    @Override
    public List<GoodsInfo> getGoodsInfoList() {
        return goodsInfoDao.getGoodsInfoList();
    }

    @Override
    public Page getPage(String currentPage) {
        //1.创建page对象
        Page page = new Page();
        //设置当前页
        if(currentPage != null){
            page.setCurrentPage(Integer.parseInt(currentPage));
        }
        //设置总条数
        page.setTotalCount(goodsInfoDao.getUserTotalCount());
        page.setUrl("/goodsinfo");
        page.setList(goodsInfoDao.getUserList((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize()));
        return page;
    }

    @Override
    public int updateObject(GoodsInfo goodsInfo) {
        return goodsInfoDao.updateObject(goodsInfo);
    }

    @Override
    public GoodsInfo getShowById(int id) {
        return goodsInfoDao.getShowById(id);
    }

    @Override
    public void batchDel(String[] ids) {
        goodsInfoDao.batchDel(ids);
    }

    @Override
    public int deleteGoodsInfo(int id) {
        return goodsInfoDao.deleteGoodsInfo(id);
    }

    @Override
    public List<GoodsInfo> getGoodsInfoParent() {
        return goodsInfoDao.getGoodsInfoParent();
    }

    @Override
    public int addGoodsInfo(String goods_name, int goods_parentid, int goods_fatherid, int goods_price, int goods_price_off, String goods_pic, String goods_description) {
        return goodsInfoDao.addGoodsInfo(goods_name,goods_parentid,goods_fatherid,goods_price,goods_price_off,goods_pic,goods_description);
    }

    @Override
    public GoodsInfo getShowByNone() {
        return goodsInfoDao.getShowByNone();
    }

    @Override
    public int addGoodsInfo1(String goods_name1, String goods_price1, String goods_price_off1, String goods_description1, String goods_pic1) {
        return goodsInfoDao.addGoodsInfo1(goods_name1,goods_price1,goods_price_off1,goods_description1,goods_pic1);
    }

    @Override
    public GoodsInfo getIntroductionById(int id, String table) {
        return goodsInfoDaoExtends.getIntroductionByIds(id,table);
    }

}
