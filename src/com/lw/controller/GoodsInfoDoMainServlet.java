package com.lw.controller;

import com.lw.entity.GoodsInfo;
import com.lw.entity.GoodsInfoDoMain;
import com.lw.entity.ShopCart;
import com.lw.service.GoodsInfoService;
import com.lw.service.impl.GoodsInfoServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/goodsInfoDoMain.do")
public class GoodsInfoDoMainServlet extends HttpServlet {

    private GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String infoId = request.getParameter("id");
        int id = infoId == null ? 0 : Integer.parseInt(infoId);
        GoodsInfo t_goods_info = goodsInfoService.getIntroductionById(id, "t_goods_info");
        GoodsInfoDoMain goodsInfoDoMain = new GoodsInfoDoMain();
        try {
            BeanUtils.copyProperties(goodsInfoDoMain,t_goods_info);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String shop_count = request.getParameter("count");

        int count = shop_count == null ? 0 : Integer.parseInt(shop_count);
        goodsInfoDoMain.setCount(count);
        HttpSession session = request.getSession();
        ShopCart shopCart = ShopCart.getShopCartObject(session);
        shopCart.shopAdd(goodsInfoDoMain);
        session.setAttribute("shopCart",shopCart);
        // 累计购物车的数量
        session.setAttribute("shop_count",shopCart.getTotalCount());
        // 获取总价

        session.setAttribute("totalPrice",shopCart.getTotaoPrice());

    }
}
