package com.lw.controller;

import com.lw.service.UserService;
import com.lw.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check")
public class AjaxCheckUsernameServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        int i = userService.checkUsername(username);
        System.out.println(i==1);
        if (i == 1) {
            PrintWriter writer = response.getWriter();
            writer.write("0");
            writer.close();
        }

    }
}
