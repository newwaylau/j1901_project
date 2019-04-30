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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/goodstypeadd")
public class GoodsTypeAddServlets extends HttpServlet {
    private GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        String parentId = request.getParameter("parentId");
        int i = goodsTypeService.addGoodsType(name, Integer.parseInt(parentId));
        if (i != 0) {
            response.sendRedirect("/goodstype");

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //2.调用service层获取对象
        GoodsType goodsType = goodsTypeService.getShowByNone();
        //3.响应进行回显
        request.setAttribute("goodsType",goodsType);



        request.getRequestDispatcher("/back/goodstype/goodstypeadd.jsp").forward(request,response);

    }
}
