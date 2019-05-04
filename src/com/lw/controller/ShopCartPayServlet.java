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

@WebServlet("/shopPay.do")
public class ShopCartPayServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object totalPrice = session.getAttribute("totalPrice");
        System.out.println(totalPrice);

        User customer = (User) session.getAttribute("user");
        System.out.println(customer);

        List<Address> address = addressService.findByAddress(customer.getId(),"t_address");
        System.out.println(address);

        session.setAttribute("addressList",address);
        System.out.println(" ...................... 1");

         request.getRequestDispatcher("WEB-INF/views/pay.jsp").forward(request,response);
//        response.sendRedirect("WEB-INF/views/payPrice.jsp");

    }
}
