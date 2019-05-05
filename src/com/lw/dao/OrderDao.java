package com.lw.dao;

import com.lw.entity.Order;

import java.util.List;

public interface OrderDao extends BaseDao<Order>{
    Integer getUserTotalCount();

    List<?> getUserList(int i, Integer pageSize);

    int deleteOrderById(int id, String table);

    void batchDel(String[] ids);
}
