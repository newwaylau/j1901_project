package com.lw.controller;

import com.lw.entity.GoodsInfo;
import com.lw.service.GoodsInfoService;
import com.lw.service.impl.GoodsInfoServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
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

@WebServlet("/goodsinfoupdate")
public class GoodsInfoUpdateServlet extends HttpServlet {
    private GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用方法获取goodsinfo对象
        GoodsInfo goodsInfo = getGoodsInfoEntity(request);
        System.out.println(goodsInfo);
        //2.调用service层进行对象修改并获得影响行数
        int i = goodsInfoService.updateObject(goodsInfo);
        System.out.println(i);

        //3.响应
        if (i != 0) {
            response.sendRedirect("/goodsinfo");
        }

    }

    private GoodsInfo getGoodsInfoEntity(HttpServletRequest request) {
        //获取imges的绝对路径
        String imagesPath = getServletContext().getRealPath("images");

        //1.创建工厂磁盘对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.通过工厂创建上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> list = null;
        Map<String, String> map = new HashMap<>();
        String fileName = null;
        String value = null;
        String name =null;
        FileOutputStream fos = null;
        InputStream is = null;
        GoodsInfo goodsInfo = null;
        try {
            //3.解析请求
            list = upload.parseRequest(request);
            //4.遍历集合
            for (FileItem fileItem: list) {
                //判断是否为文本信息
                if(fileItem.isFormField()){
                    //获取表单的name属性
                    fileName = fileItem.getFieldName();
                    //获取表单的value值
                    value = fileItem.getString("utf-8");
                    map.put(fileName,value);
                }else{
                    //获取图片名字
                    name = fileItem.getName();
                    //获取文件的name属性
                    fileName = fileItem.getFieldName();
                    //判断是否有图片上传
                    if(name != null && !"".equals(name)){
                        //存储图片到集合中
                        map.put(fileName,name);
                        //把图片上传到服务器中-File.separator等于"/"
                        fos = new FileOutputStream(imagesPath+ File.separator+name);
                        //获取图片输入流
                        is = fileItem.getInputStream();
                        try{
                            IOUtils.copy(is,fos);
                        }finally {
                            IOUtils.closeQuietly(fos);
                        }
                    }
                }
            }
            //把map集合中的数据存放到对象中
            goodsInfo = new GoodsInfo();
            BeanUtils.populate(goodsInfo,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsInfo;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mid = request.getParameter("id");
        int id = mid==null?0:Integer.parseInt(mid);
        GoodsInfo goodsInfo = goodsInfoService.getShowById(id);
        request.setAttribute("goodsInfo",goodsInfo);
        request.getRequestDispatcher("back/goods/goodupdate.jsp").forward(request,response);

    }
}
