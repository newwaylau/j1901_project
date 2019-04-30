package com.lw.controller;

import com.alibaba.fastjson.JSON;
import com.lw.entity.GoodsInfo;
import com.lw.service.GoodsInfoService;
import com.lw.service.impl.GoodsInfoServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/goodsinfoadd")
public class GoodsInfoAddServlet extends HttpServlet {
    private GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String goods_name = request.getParameter("goods_name");
//        String ggoods_parentid = request.getParameter("goods_parentid");
//        int goods_parentid=ggoods_parentid==null?0:Integer.parseInt(ggoods_parentid);
//        System.out.println(goods_parentid);
//        String ggoods_fatherid = request.getParameter("goods_fatherid");
//        int goods_fatherid=ggoods_fatherid==null?0:Integer.parseInt(ggoods_fatherid);
//        String ggoods_price = request.getParameter("goods_price");
//        int goods_price = ggoods_price == null ? 0 : Integer.parseInt(ggoods_price);
//        String ggoods_price_off = request.getParameter("goods_price_off");
//        int goods_price_off=ggoods_price_off==null?0:Integer.parseInt(ggoods_price_off);
//        String goods_pic = request.getParameter("goods_pic");
//        String goods_description = request.getParameter("goods_description");
//        if (i != 0) {
//            response.sendRedirect("/goodsinfo");
//        }
        //1.调用方法获取goodsinfo对象
        FileItemFactory itemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
        // 转成int
        String id1 = "";
        String goods_name1 = "";
        String price = "";
        // 转成 int
        double goods_price1 = 0;
        String goods_price_off1 = "";
        String goods_description1 = "";
        // 旧图片名称
        String goods_pic1 = "";
        try {
            List<FileItem> list = fileUpload.parseRequest(request);

            for (FileItem fi : list) {

                if (fi.isFormField()) {

                    if ("id".equals(fi.getFieldName())){
                        id1 = fi.getString("utf-8");
                    }

                    if ("goods_name".equals(fi.getFieldName())) {
                        goods_name1 = fi.getString("utf-8");
                    }

                    if ("goods_price".equals(fi.getFieldName())) {
                        goods_price1 = Double.parseDouble(fi.getString("utf-8"));
                    }
                    if ("goods_price_off".equals(fi.getFieldName())) {
                        goods_price_off1 = fi.getString("utf-8");
                    }
                    if ("goods_description".equals(fi.getFieldName())) {
                        goods_description1 = fi.getString("utf-8");
                    }
                } else {
                    /*
                     如何去修改图片
                        首先删除原有的
                        在修改
                      */
                    // 获取文件类型
//                    String contentType = fi.getContentType();
//                    System.out.println("contentType = "+ contentType);
                    // 写入 本地磁盘
                    // 文件名 唯一
                    // 获取文件名
                    goods_pic1 = fi.getName();
                    if (goods_pic1 != null && !goods_pic1.equals("")){
                        fi.write(new File("D:\\repeatdays\\j1901_project\\web\\images\\"+goods_pic1));
                        }
                }
            }

            int id =  Integer.parseInt(id1);
            int i = 0;
            if (goods_pic1 != null && !goods_pic1.equals("")) {
                i = goodsInfoService.addGoodsInfo1(goods_name1, String.valueOf(goods_price1),goods_price_off1,goods_description1,goods_pic1);
            } /*else {
                i = goodsInfoService.addGoodsInfo1(goods_name1,goods_price1,goods_price_off1,goods_description1);
            }*/
            if (i != 0) {
                // session.setAttribute("updMenu","yes");
                response.sendRedirect("/goodsinfo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsInfo goodsInfo = goodsInfoService.getShowByNone();
        System.out.println(goodsInfo);
        request.setAttribute("goodsInfo",goodsInfo);
        request.getRequestDispatcher("back/goods/goodsadd.jsp").forward(request,response);



    }
}
