package com.lw.controller;

import com.lw.service.GoodsTypeService;
import com.lw.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodstypebatchdel")
public class AjaxGoodsTypeBatchDelServlet extends HttpServlet {
    private GoodsTypeService goodsTypeService=new GoodsTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids[]");
        System.out.println(ids);
        //2.把数组传递到service层完成批量删除
        goodsTypeService.batchDel(ids);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
