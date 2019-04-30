package com.lw.controller;

import com.lw.entity.User;
import com.lw.service.UserService;
import com.lw.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUserByUsernameAndPassword(username, password);
        System.out.println(user);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
//            request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);
            response.sendRedirect("/index.do");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);

    }
}
