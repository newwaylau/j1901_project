package com.lw.controller;

import com.lw.entity.Page;
import com.lw.service.OrderService;
import com.lw.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        //2.调用service层获得page对象
        Page page = orderService.getPage(currentPage);
        System.out.println(page);
        //3.响应前端
        request.setAttribute("page",page);
        request.getRequestDispatcher("/back/order/orderlist.jsp").forward(request,response);

    }
}
