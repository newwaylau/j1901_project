package com.lw.controller;

import com.lw.entity.Page;
import com.lw.service.GoodsTypeService;
import com.lw.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goodstype")
public class GoodsTypeServlet extends HttpServlet {
    private GoodsTypeService goodsTypeService =new GoodsTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse reseonse) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        //2.调用service层获得page对象
        Page page = goodsTypeService.getPage(currentPage);
        //3.响应前端
        request.setAttribute("page",page);
        request.getRequestDispatcher("back/goodstype/goodstype.jsp").forward(request,reseonse);


//        // 获取当前页
//
//        String currentPages = request.getParameter("currentPage");
//        System.out.println(currentPages);
//        int currentPage = currentPages == null ? 1 : Integer.parseInt(currentPages);
//        // 查询所有
//        int count = goodsTypeService.getCount();
//
//        FindByPage findByPage = new FindByPage(count, currentPage);
//
//        // 分页查询
//        List<GoodsType> goodsTypePage =  goodsTypeService.getGoodsTypePage(findByPage.getStart(),FindByPage.PAGE_SIZE);
//        System.out.println(goodsTypePage);
//        /*
//          记录数
//          每页显示的数量
//          总页数
//          分页查询的起始位置
//          当前页
//         */
//        if (goodsTypePage != null) {
//            HttpSession session = request.getSession();
//            // 存数据
//            session.setAttribute("goodsTypePage",goodsTypePage);
//            // 当前页
//            session.setAttribute("currentPage",findByPage.getCurrentPage());
//            // 总页数
//            session.setAttribute("totalPage",findByPage.getTotalPage());
//
//            request.getRequestDispatcher("/back/goodstype/goodstype.jsp").forward(request,reseonse);
//        } else {
//            reseonse.sendRedirect("error.jsp");
//        }

    }
}
