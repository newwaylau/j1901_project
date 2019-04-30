package com.lw.service;

import com.lw.entity.GoodsType;
import com.lw.entity.Page;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsType> getGoodsTypeList();


    List<GoodsType> getGoodsTypePage(int start, int pageSize);

    int delGoodsType(int id);

    Page getPage(String currentPage);

    List<GoodsType> getGoodsTypeParentList(String parent_id);

    void batchDel(String[] ids);

    List<GoodsType> getGoodsTypeParent();

    GoodsType getObjectById(int parseInt);

    int updateObject(int parseInt, String name, int parseInt1);

    int addGoodsType(String name, int parseInt);

    GoodsType getShowByNone();
}
