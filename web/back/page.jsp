<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/11 0011
  Time: 下午 3:46
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${page.url}&currentPage=1">首页</a>
    <c:if test="${page.currentPage >1}">
        <a href="${page.url}&currentPage=${page.currentPage-1}">上一页</a>
    </c:if>
    <c:if test="${page.currentPage < page.totalPage}">
        <a href="${page.url}&currentPage=${page.currentPage+1}">下一页</a>
    </c:if>
    <a href="${page.url}&currentPage=${page.totalPage}">尾页</a>
</body>
</html>
