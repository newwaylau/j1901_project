package com.lw.controller;

import com.lw.service.OrderService;
import com.lw.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderdelete")
public class OrderDeleteServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delid = request.getParameter("id");
        int id = delid==null?0:Integer.parseInt(delid);
        System.out.println(id);
        int i = orderService.deleteOrderById(id, "t_order_detail");
        System.out.println(i);
        if (i != 0) {
            response.sendRedirect("/order");
        }


    }
}
