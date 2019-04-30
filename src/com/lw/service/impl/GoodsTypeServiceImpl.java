package com.lw.service.impl;

import com.lw.dao.GoodsTypeDao;
import com.lw.dao.impl.GoodsTypeDaoImpl;
import com.lw.entity.GoodsType;
import com.lw.entity.Page;
import com.lw.service.GoodsTypeService;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {

    private GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
    @Override
    public List<GoodsType> getGoodsTypeList() {
        return goodsTypeDao.getGoodsTypeList();
    }


    @Override
    public List<GoodsType> getGoodsTypePage(int start, int pageSize) {
        return goodsTypeDao.getGoodsTypePage(start,pageSize);
    }

    @Override
    public int delGoodsType(int id) {
        return goodsTypeDao.delGoodsType(id);
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
        page.setTotalCount(goodsTypeDao.getUserTotalCount());
        page.setUrl("/goodstype");
        page.setList(goodsTypeDao.getUserList((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize()));
        return page;
    }
    @Override
    public List<GoodsType> getGoodsTypeParentList(String parent_id) {
        return goodsTypeDao.getGoodsTypeParentList(parent_id);
    }

    @Override
    public void batchDel(String[] ids) {
        goodsTypeDao.batchDel(ids);

    }

    @Override
    public List<GoodsType> getGoodsTypeParent() {
        return goodsTypeDao.getGoodsTypeParent();
    }

    @Override
    public GoodsType getObjectById(int parseInt) {
        return goodsTypeDao.getObjectById(parseInt);
    }

    @Override
    public int updateObject(int parseInt, String name, int parseInt1) {
        return goodsTypeDao.updateObject(parseInt,name,parseInt1);
    }

    @Override
    public int addGoodsType(String name, int parseInt) {
        return goodsTypeDao.addGoodsType(name,parseInt);
    }

    @Override
    public GoodsType getShowByNone() {
        return goodsTypeDao.getShowByNone();
    }
}
