package com.lw.controller;

import com.lw.entity.GoodsType;
import com.lw.service.GoodsTypeService;
import com.lw.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodstypeupdate")
public class GoodsTypeUpdateServlet extends HttpServlet {
    private GoodsTypeService goodsTypeService =new GoodsTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String parent_id = request.getParameter("parent_id");
        //2.调用service层修改对象
        int rSet = goodsTypeService.updateObject(Integer.parseInt(id),name,Integer.parseInt(parent_id));
        System.out.println(rSet);
        //3.响应前端
        if (rSet != 0) {
//            request.getRequestDispatcher("/goodstype").forward(request,response);
            response.sendRedirect("/goodstype");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mid = request.getParameter("id");
        int id = mid==null?0:Integer.parseInt(mid);

        //2.调用service层获取对象
        GoodsType goodsType = goodsTypeService.getObjectById(id);
        //3.响应进行回显
        request.getSession().setAttribute("goodsType",goodsType);
        request.getRequestDispatcher("back/goodstype/goodstypeupdate.jsp").forward(request,response);

    }
}
