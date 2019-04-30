<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/backstyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function () {
            //获取商品信息的大类id
            var goods_parentid = ${goodsInfo.goods_parentid};
            //获取商品信息的小类id
            var goods_fatherid = ${goodsInfo.goods_fatherid};

            //大类下拉框对象
            var parent_id=$("#goods_parentid");
            //小类下拉框对象
            var father_id = $("#goods_fatherid");

            //InitGoodsType("所属大类id","需要改变的下拉框对象","商品的大小类id");

            //大类下拉框初始化
            InitGoodsType(0,parent_id,goods_parentid);
            //小类下拉框初始化
            InitGoodsType(goods_parentid,father_id,goods_fatherid);

            //给大类的下拉框添加改变事件
            parent_id.change(function () {
                //清空小类下拉框的所有option对象
                father_id.find("option").remove();
                //获取大类下拉框option的value值
                var newParentId =  $(this).val();
                InitGoodsType(newParentId,father_id);
            })

            //图片的改变事件--改变展示的图片
            $("#uploadFile").change(function () {
                //获取用户上传的图片
                var fileObj = this.files[0];
                //把图片对象转换成url
                var fileUrl = window.URL.createObjectURL(fileObj);
                //改变图片的src属性
                $("#goods_pic").attr("src",fileUrl);
            })

            /*$.post("GoodsTypeServlet?action=getGoodsTypeListByParentId&parent_id=0",function (data) {
                    for (var i = 0;i <data.length;i++) {
                        //1.创建option对象
                        var option =document.createElement("option");
                        //给option对象赋value值和内容
                        option.value = data[i].id;
                        option.text = data[i].name;
                        //把option添加到select标签中(大类下拉框的对象)
                        $("#goods_parentid").append(option);
                    }
                    //通过商品信息的大类id选中对应的下拉框
                    $("#goods_parentid").val(goods_parentid);

            },"JSON")

            $.post("GoodsTypeServlet?action=getGoodsTypeListByParentId&parent_id="+goods_parentid,function (data) {
                for (var i = 0;i <data.length;i++) {
                    //1.创建option对象
                    var option =document.createElement("option");
                    //给option对象赋value值和内容
                    option.value = data[i].id;
                    option.text = data[i].name;
                    //把option添加到select标签中(小类下拉框的对象)
                    $("#goods_fatherid").append(option);
                }
                //通过商品信息的小类id选中对应的下拉框
                $("#goods_fatherid").val(goods_fatherid);

            },"JSON")*/
        })
        //所属大类id","需要改变的下拉框对象","商品的大小类id"
        function InitGoodsType(parent_id,selectObj,TypeId) {
            $.post("/ajaxgoodstypeparentid?parent_id="+parent_id,function (data) {
                for (var i = 0;i <data.length;i++) {
                    //1.创建option对象
                    var option =document.createElement("option");
                    //给option对象赋value值和内容
                    option.value = data[i].id;
                    option.text = data[i].name;
                    //把option添加到select标签中(大类下拉框的对象)
                    selectObj.append(option);
                }
                //通过商品信息的大类id选中对应的下拉框
                selectObj.val(TypeId);

            },"JSON")
        }


    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">表单</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>添加商品信息</span></div>
    <form method="post" action="/goodsinfoadd" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${goodsInfo.id}"/>
        <input type="hidden" name="goods_pic" value="${goodsInfo.goods_pic}"/>
        <ul class="forminfo">
            <li><label>商品名称</label><input name="goods_name" value=""  type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
            <li><label>所属大类</label>
                <select name="goods_parentid" id="goods_parentid" selected>
                </select>

            </li>
            <li><label>所属小类</label>
                <select name="goods_fatherid" id="goods_fatherid" >
                </select>
            </li>
            <li><label>商品原价</label><input name="goods_price" type="text" class="dfinput" value=""/><i>标题不能超过30个字符</i></li>
            <li><label>商品折扣价</label><input name="goods_price_off" type="text" class="dfinput" value=""/><i>标题不能超过30个字符</i></li>
            <li><label>商品图片</label><input name="goods_pic" type="file" id="uploadFile" /><i>标题不能超过30个字符</i></li>
            <<img src="images/" id="goods_pic"/><br/>
            <li><label>商品描述</label><textarea rows="8" cols="40" name="goods_description"  ></textarea><i>标题不能超过30个字符</i></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
        </ul>

    </form>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>


