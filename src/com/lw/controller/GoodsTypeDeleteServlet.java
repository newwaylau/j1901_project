package com.lw.controller;

import com.lw.service.GoodsTypeService;
import com.lw.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodstypedelete")
public class GoodsTypeDeleteServlet extends HttpServlet {
    private GoodsTypeService goodsTypeService=new GoodsTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delid = request.getParameter("delid");
        System.out.println(delid);
        int id = delid==null?0:Integer.parseInt(delid);

        int i = goodsTypeService.delGoodsType(id);
        if (i != 0) {
            request.getRequestDispatcher("/goodstype").forward(request,response);
//            response.sendRedirect("/goodstypedelete");
        }


    }
}
