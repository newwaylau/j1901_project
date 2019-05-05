package com.lw.service;

import com.lw.entity.Page;

public interface OrderService {
    Page getPage(String currentPage);

    int deleteOrderById(int id, String t_order_detail);

    void batchDel(String[] ids);
}
