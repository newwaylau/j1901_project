package com.lw.controller;

import com.lw.entity.GoodsInfo;
import com.lw.entity.GoodsType;
import com.lw.service.GoodsInfoService;
import com.lw.service.GoodsTypeService;
import com.lw.service.impl.GoodsInfoServiceImpl;
import com.lw.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
    private GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
    private GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GoodsInfo> goodsInfoList = goodsInfoService.getGoodsInfoList();
        List<GoodsType> goodsTypeList = goodsTypeService.getGoodsTypeList();
        System.out.println(goodsInfoList);
        System.out.println(goodsTypeList);
        HttpSession session = request.getSession();
        session.setAttribute("giList",goodsInfoList);
        session.setAttribute("gtList",goodsTypeList);
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);

    }
}
