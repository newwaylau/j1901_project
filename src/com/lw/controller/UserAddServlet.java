package com.lw.controller;

import com.lw.service.UserService;
import com.lw.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/useradd")
public class UserAddServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String username1 = request.getParameter("username");

        String username = new String(username1.getBytes("ISO8859-1"),"UTF-8");
        System.out.println(username);

        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String is_role = request.getParameter("is_role");
        //2.调用service完成添加用户,获得影响行数
        int i = userService.addUser(username,password,phone,email,is_role);
        System.out.println(i);
        if (i != 0) {
//            request.getRequestDispatcher("/back/user/adduser.jsp").forward(request,response);
            response.sendRedirect("/user");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/back/user/adduser.jsp").forward(request,response);
        //3.响应前端

    }
}
