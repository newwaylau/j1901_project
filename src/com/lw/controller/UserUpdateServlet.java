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

@WebServlet("/userupdate")
public class UserUpdateServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mid = request.getParameter("id");
        int id=mid==null?0:Integer.parseInt(mid);
        System.out.println(id);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String is_role = request.getParameter("is_role");
        int i = userService.updateUser(id,username,password,phone,email,is_role);
        if (i != 0) {
            response.sendRedirect("/user");
        }
        System.out.println(i);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateid = request.getParameter("updateid");
        int id=updateid==null?0:Integer.parseInt(updateid);
        System.out.println(id);
        User user =  userService.getUserById(id);
        System.out.println(user);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        request.getRequestDispatcher("back/user/updateuser.jsp").forward(request,response);

    }
}
