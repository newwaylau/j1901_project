package com.lw.service.impl;

import com.lw.dao.OrderDao;
import com.lw.dao.impl.OrderDaoImpl;
import com.lw.entity.Page;
import com.lw.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public Page getPage(String currentPage) {
        //1.创建page对象
        Page page = new Page();
        //设置当前页
        if(currentPage != null){
            page.setCurrentPage(Integer.parseInt(currentPage));
        }
        //设置总条数
        page.setTotalCount(orderDao.getUserTotalCount());
        page.setUrl("/order");
        page.setList(orderDao.getUserList((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize()));
        return page;
    }

    @Override
    public int deleteOrderById(int id, String table) {
        return orderDao.deleteOrderById(id,table);
    }

    @Override
    public void batchDel(String[] ids) {
        orderDao.batchDel(ids);

    }
}
