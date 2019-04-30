package com.lw.controller;

import com.lw.entity.Page;
import com.lw.service.UserService;
import com.lw.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlets extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=uft-8");
        String currentPage = request.getParameter("currentPage");
        //2.调用service层获得page对象
        Page page = userService.getPage(currentPage);
        System.out.println(page);
        //3.响应前端
        request.setAttribute("page",page);
        request.getRequestDispatcher("back/user/userinfo.jsp").forward(request,response);

    }
}
