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

@WebServlet("/backlogin")
public class BackLoginServlets extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUserByUsernameAndPassword(username, password);
        System.out.println(user);
        String role = user==null?"":Integer.toString(user.getIs_role());

        if (user != null) {
            if ("1".equals(role)) {
                HttpSession session = request.getSession();
                session.setAttribute("backUser", user);
                request.getRequestDispatcher("/back/main.jsp").forward(request, response);

            } else {
                response.getWriter().write("<script>alert('你不是管理员,请充值');location.href='backlogin'</script>");
            }

        } else {
            response.getWriter().write("<script>alert('用户名或密码错误');location.href='/backlogin'</script>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/backLogin.jsp").forward(request,response);


    }
}
