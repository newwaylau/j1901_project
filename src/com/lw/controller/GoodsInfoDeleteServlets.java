package com.lw.controller;

import com.lw.service.GoodsInfoService;
import com.lw.service.impl.GoodsInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodsinfodelete")
public class GoodsInfoDeleteServlets extends HttpServlet {
    private GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("id");
        int id=mid==null?0:Integer.parseInt(mid);
        System.out.println(id);

        int i = goodsInfoService.deleteGoodsInfo(id);
        if (i != 0) {
            response.sendRedirect("/goodsinfo");
        }

    }
}
