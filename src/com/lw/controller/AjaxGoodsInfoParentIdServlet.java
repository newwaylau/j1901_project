package com.lw.controller;

import com.alibaba.fastjson.JSON;
import com.lw.entity.GoodsInfo;
import com.lw.entity.GoodsType;
import com.lw.service.GoodsInfoService;
import com.lw.service.impl.GoodsInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajaxgoodsinfoparent")
public class AjaxGoodsInfoParentIdServlet extends HttpServlet {

    private GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GoodsInfo> goodsInfos = goodsInfoService.getGoodsInfoParent();
        System.out.println(goodsInfos);
        //2.使用json格式传输数据
        String json = JSON.toJSONString(goodsInfos);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
