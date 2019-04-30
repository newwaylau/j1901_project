<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <% String path = request.getContextPath();
    	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function () {
            //统计用户勾选个数
            var count = 0;
            //全选的点击事件
            $("#idFlag").click(function () {
                //获取全选按钮的状态
                var flag = $(this).prop("checked");
                //判断是否选中全选按钮
                if(flag){
                    //选中,计数器则为展示数的长度
                    count = $(".ids").length;
                }else{
                    count = 0;
                }
                //获取每个用户选中框对象并且进行选中
                $(".ids").each(function () {
                    $(this).prop("checked",flag);
                })
            })

            //用户选中状态
            $(".ids").each(function () {
                $(this).click(function () {
                    //判断每个用户是否勾选
                    if($(this).prop("checked")){
                        //次数+1
                        count++;
                        //如果勾选次数为用户数量,则选中全选按钮
                        if(count == $(".ids").length){
                            $("#idFlag").prop("checked",true);
                        }
                    }else{
                        count--;
                        $("#idFlag").prop("checked",false);
                    }
                })
            })

            $("#batchDel").click(function () {
                //1.创建存放id的数组
                var idList = new Array();
                //2.获取选中状态的用户id
                $(".ids:checked").each(function () {
                    //获取id值(value属性值)存放到数组中
                    var id = $(this).val();
                    idList.push(id);
                })
                //3.创建对象,用来存储数组
                var obj = new Object();
                obj.ids = idList;
                //使用Ajax进行数据交换
                $.post("/batchdel",obj,function (data) {
                    //页面刷新
                    location.reload();
                })

            })
        })
    </script>
</head>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span><a href="/useradd">添加</a></li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li id="batchDel"><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
      <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" id="idFlag"/></th>
        <th>用户编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        
<%--            <tr>
         	 <td><input name="" type="checkbox" value=""/></td>
		        <td></td>
		        <td></td>
		        <td></td>
		        <td></td>
		        <td></td>
		        <td> </td>
	        </tr> --%>

<c:forEach items="${page.list}" var="user">
    <tr>
        <td><input name="" type="checkbox" value="${user.id}" class="ids"/></td>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.phone}</td>
        <td>${user.email}</td>
        <td>${user.is_role eq "1" ? "是" : "否" }</td>
        <td>
            <a href="/userupdate?updateid=${user.id}">编辑</a>
            <a href="/userdelete?delid=${user.id}">删除</a>
        </td>
    </tr>
</c:forEach>

        </tbody>
    </table>

        <a href="${page.url}?currentPage=1">首页</a>
        <c:if test="${page.currentPage >1}">
            <a href="${page.url}?currentPage=${page.currentPage-1}">上一页</a>
        </c:if>
        <c:if test="${page.currentPage < page.totalPage}">
            <a href="${page.url}?currentPage=${page.currentPage+1}">下一页</a>
        </c:if>
        <a href="${page.url}?currentPage=${page.totalPage}">尾页</a>
        <%--<%@include file="../page.jsp"%>--%>

    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
