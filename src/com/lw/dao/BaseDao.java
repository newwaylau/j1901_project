package com.lw.dao;

import com.lw.entity.Address;
import com.lw.entity.GoodsInfo;

import java.util.List;

public interface BaseDao<T>{
    T getIntroductionByIds(int id,String table);

    List<T> findByAddress(int id, String table);

    T getAddressByPhone(String phone, String table);
}
