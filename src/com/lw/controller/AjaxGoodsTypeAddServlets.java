package com.lw.controller;

import com.alibaba.fastjson.JSON;
import com.lw.entity.GoodsType;
import com.lw.service.GoodsTypeService;
import com.lw.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajaxgoodstypeadd")
public class AjaxGoodsTypeAddServlets extends HttpServlet {
    private GoodsTypeService goodsTypeService=new GoodsTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<GoodsType> goodsTypeList = goodsTypeService.getGoodsTypeParent();
        //2.使用json格式传输数据
        String json = JSON.toJSONString(goodsTypeList);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GoodsType> goodsTypeList = goodsTypeService.getGoodsTypeParent();
        //2.使用json格式传输数据
        String json = JSON.toJSONString(goodsTypeList);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
        request.getRequestDispatcher("back/goods/goodstypeadd.jsp").forward(request,response);

    }
}
