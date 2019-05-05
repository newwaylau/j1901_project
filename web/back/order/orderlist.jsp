<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/backstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css"/>
<link href="css/personal.css" rel="stylesheet" type="text/css"/>
<link href="css/orstyle.css" rel="stylesheet" type="text/css"/>
<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"/>
<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>
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
                $.post("/orderbatchdel",obj,function (data) {
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
				<li class="click"><span><img src="images/t01.png" /></span><a
					href="back/user/adduser.jsp">添加</a></li>
				<li class="click"><span><img src="images/t02.png" /></span>修改</li>
				<li id="batchDel"><span><img src="images/t03.png" /></span>删除</li>
				<li><span><img src="images/t04.png" /></span>统计</li>
			</ul>

			<ul class="toolbar1">
				<li><span><img src="images/t05.png" /></span>设置</li>
			</ul>
		</div>
		<div class="center">
			<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>
				<div class="am-tabs-bd">
					<div class="am-tab-panel am-fade am-in am-active" id="tab1">
						<div class="order-top">
                            <div class="">
								<th><input name="" type="checkbox" value="" id="idFlag"/></th>
							</div>
							<div class="th th-item">
								<td class="td-inner">商品</td>
							</div>
							<div class="th th-price">
								<td class="td-inner">单价</td>
							</div>
							<div class="th th-number">
								<td class="td-inner">数量</td>
							</div>
							<div class="th th-operation">
								<td class="td-inner">商品操作</td>
							</div>
							<div class="th th-amount">
								<td class="td-inner">合计</td>
							</div>
							<div class="th th-status">
								<td class="td-inner">交易状态</td>
							</div>
							<div class="th th-change">
								<td class="td-inner">交易操作</td>
							</div>
						</div>

						<div class="order-main">
							<div class="order-list">
									<!--交易成功。-->
								<c:forEach items="${page.list}" var="order">
									<div class="order-status5">
										<div class="order-title">
											<div class="dd-num">
												订单编号：<a href="javascript:;">${order.o_orderid}</a>
											</div>
											<span>成交时间：</span>${order.goods_date}
										</div>
											<div class="order-content">
												<div class="order-left">
													<td><input name="" type="checkbox" value="${order.id}" class="ids"/></td>
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint">
																 <img src="/images/${order.goodspic}" class="itempic J_ItemImg"></img>
																 </a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>${order.goods_description}</p>
																	</a>
																</div>
															</div>
														</li>
														<li class="td td-price">
															<div class="item-price">${order.goodsprice}</div>
														</li>
														<li class="td td-number">
															<div class="item-number">
																<span>×</span>
																${order.goodsnum}
															</div>
														</li>
														<li class="td td-operation">
															<div class="item-operation"></div>
														</li>
													</ul>
												</div>
												<div class="order-right">
													<li class="td td-amount">
														<div class="item-amount">
															合计：${order.goods_total_price}</div>
													</li>
													<div class="move-right">
														<li class="td td-status">
															<div class="item-status">
																<p class="Mystatus">交易成功</p>
																<p class="order-info">
																	<a href="/goodsinfo">订单详情</a>
																</p>
															</div>
														</li>
														<li class="td td-change">
															<div class="am-btn am-btn-danger anniu"><a href="/orderdelete?id=${order.id}">删除订单</a></div>
														</li>
													</div>
												</div>
											</div>
									</div>
                                    </c:forEach>
								<a href="${page.url}?currentPage=1">首页</a>
								<c:if test="${page.currentPage >1}">
									<a href="${page.url}?currentPage=${page.currentPage-1}">上一页</a>
								</c:if>
								<c:if test="${page.currentPage < page.totalPage}">
									<a href="${page.url}?currentPage=${page.currentPage+1}">下一页</a>
								</c:if>
								<a href="${page.url}?currentPage=${page.totalPage}">尾页</a>
							</div>

						</div>

					</div>

					<div class="tip">
						<div class="tiptop">
							<span>提示信息</span><a></a>
						</div>

						<div class="tipinfo">
							<span><img src="images/ticon.png" /></span>
							<div class="tipright">
								<p>是否确认对信息的修改 ？</p>
								<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
							</div>
						</div>

						<div class="tipbtn">
							<input name="" type="button" class="sure" value="确定" />&nbsp; <input
								name="" type="button" class="cancel" value="取消" />
						</div>

					</div>
				</div>

				<script type="text/javascript">
					$('.tablelist tbody tr:odd').addClass('odd');
				</script>
</body>
</html>
