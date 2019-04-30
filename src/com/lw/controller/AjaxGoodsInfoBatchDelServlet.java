package com.lw.controller;

import com.lw.service.GoodsInfoService;
import com.lw.service.impl.GoodsInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodsinfobatchdel")
public class AjaxGoodsInfoBatchDelServlet extends HttpServlet {
    private GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids[]");
        //2.把数组传递到service层完成批量删除
        goodsInfoService.batchDel(ids);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
