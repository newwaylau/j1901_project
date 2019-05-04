package com.lw.controller;

import com.lw.entity.GoodsInfo;
import com.lw.service.GoodsInfoService;
import com.lw.service.impl.GoodsInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/introduction.do")
public class IntroductionServlet extends HttpServlet {
    private GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("id");
        int id = mid==null?0:Integer.parseInt(mid);
        GoodsInfo goodsInfo =  goodsInfoService.getIntroductionById(id,"t_goods_info");
        System.out.println(goodsInfo);
        request.setAttribute("goodsInfo",goodsInfo);
        request.getRequestDispatcher("WEB-INF/views/introduction.jsp").forward(request,response);


    }
}
