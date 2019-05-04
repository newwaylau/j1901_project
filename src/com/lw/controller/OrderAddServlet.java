package com.lw.controller;

import com.lw.entity.Address;
import com.lw.entity.User;
import com.lw.service.AddressService;
import com.lw.service.impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/addorder.do")
public class OrderAddServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        Address t_address = addressService.getAddressByPhone(phone, "t_address");
        HttpSession session = request.getSession();
        session.setAttribute("address",t_address);


        request.getRequestDispatcher("WEB-INF/views/success.jsp").forward(request,response);

    }
}
