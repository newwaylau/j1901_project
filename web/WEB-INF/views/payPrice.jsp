<%--
  Created by IntelliJ IDEA.
  User: lijunok
  Date: 2019/4/29
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>结算页面</title>

    <link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css"/>

    <link href="basic/css/demo.css" rel="stylesheet" type="text/css"/>
    <link href="css/cartstyle.css" rel="stylesheet" type="text/css"/>

    <link href="css/jsstyle.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <script type="text/javascript">

        $(function () {
            //遍历收货地址
            $("ul[class='addressChoose'] li").each(function () {
                $(this).unbind();
                $(this).click(function () {
                    $("ul[class='addressChoose'] li").removeClass("defaultAddr");
                    $(this).addClass("defaultAddr");
                    var shouhuoren = $("li[class='user-addresslist defaultAddr'] span[class='buy-user']").html();
                    var dianhua = $("li[class='user-addresslist defaultAddr'] span[class='buy-phone']").html();
                    var dizhi = $("li[class='user-addresslist defaultAddr'] span[class='buy--address-detail']").html();
                    $("#buy_user").val(shouhuoren);
                    $("#phone").val(dianhua);
                    $("#address").val(dizhi);

                    //给结算框添加收货信息
                    $("#send").html(dizhi);
                    $("#person").html(shouhuoren);
                    $("#tel").html(dianhua);
                })
            })

            //配送方式
            $("ul[class='op_express_delivery_hot'] li").each(function () {
                $(this).unbind();
                $(this).click(function () {
                    var express = $(this).children("span").attr("id");
                    alert(express);
                    $("#express").val(express);
                    //删除所有的选中状态
                    $("ul[class='op_express_delivery_hot'] li").removeClass("selected");
                    //给点击的对象添加选中状态
                    $(this).addClass("selected");
                })
            })

            //支付方式
            $("ul[class='pay-list'] li").each(function () {
                $(this).unbind();
                $(this).click(function () {
                    var paytype = $(this).children("span").attr("id");
                    alert(paytype);
                    $("#paytype").val(paytype);
                    $("ul[class='pay-list'] li").removeClass("selected");
                    $(this).addClass("selected");
                })
            })


            $("#go").click(function () {
                $("#form").submit();
            })

            $("#def_1").attr("class", "user-addresslist defaultAddr");
            $("#def_1").find(".address-left").append("<ins class='deftip'>默认地址</ins>");


            //-------------------初始化结算框和提交表单的信息
            //获取默认收货人的收货名字
            var shouhuoren = $("li[class='user-addresslist defaultAddr'] span[class='buy-user']").html();
            //获取默认收货人的收货电话
            var dianhua = $("li[class='user-addresslist defaultAddr'] span[class='buy-phone']").html();
            //获取默认收货人的收货地址
            var dizhi = $("li[class='user-addresslist defaultAddr'] span[class='buy--address-detail']").html();
            //给结算框添加收货信息
            $("#send").html(dizhi);
            $("#person").html(shouhuoren);
            $("#tel").html(dianhua);

            //给提交表单添加收货信息
            $("#buy_user").val(shouhuoren);
            $("#phone").val(dianhua);
            $("#address").val(dizhi);
        })


    </script>

</head>
<body>
<%@include file="head.jsp" %>

<div class="concent">
    <%--地址--%>
    <div class="paycont">
        <div class="address">
            <h3>确认收货地址</h3>
            <div class="control">
                <div class="tc-btn createAddr theme-login am-btn am-btn-danger"><a href="addAddress.jsp"
                                                                                   style="color: white;">使用新地址</a></div>
            </div>


            <div class="clear"></div>

            <ul class="addressChoose">
                <c:forEach items="${addressList}" var="addr">
                    <li class="user-addresslist" id="ref_${addr.isdefault}">
                        <div class="address-left">
                            <div class="user DefaultAddr">
                                <span class="buy-address-detail"></span>
                                <span class="buy-user">${addr.shouHuoRen}</span>
                                <span class="buy-phone">${addr.phone}</span>
                            </div>

                            <div class="default-address DefaultAddr">
                                <span class="buy-line-title">收货地址: </span>
                                <span class="buy-address-detail">${addr.address}</span>
                            </div>
                        </div>

                        <div class="new-addr-btn">
                            <span class="new-addr-bar"> </span>
                            <a href="#"> 编辑 </a>
                            <span class="new-addr-bar"> | </span>
                            <a href="javascript:void(0)" onclick="deleteClick(this)">删除</a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="clear"></div>
    <%--物流--%>
    <div class="logistics">
        <h3>选择物流方式</h3>

        <ul class="op_express_delivery_hot">
            <li data-value="yuantong" class="OP_LOG_BTN "><i class="c-gap-right"
                                                             style="background-position:0px -468px"></i>圆通<span
                    id="圆通"></span></li>
            <li data-value="shentong" class="OP_LOG_BTN "><i class="c-gap-right"
                                                             style="background-position:0px -1008px"></i>申通<span
                    id="申通"></span></li>
            <li data-value="yunda" class="OP_LOG_BTN "><i class="c-gap-right"
                                                          style="background-position:0px -576px"></i>韵达<span
                    id="韵达"></span></li>
            <li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last"><i class="c-gap-right"
                                                                                          style="background-position:0px -324px"></i>中通<span
                    id="中通"></span></li>
            <li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i class="c-gap-right"
                                                                                            style="background-position:0px -180px"></i>顺丰<span
                    id="顺丰"></span></li>
        </ul>
    </div>

    <div class="clear"></div>

    <%--支付--%>
    <div class="logistics">
        <h3>选择支付方式</h3>

        <ul class="pay-list">
            <li class="pay card"><img src="images/wangyin.jpg"/>银联<span id="银联"></span></li>
            <li class="pay qq"><img src="images/weizhifu.jpg"/>微信<span id="微信"></span></li>
            <li class="pay taobao"><img src="images/zhifubao.jpg"/>支付宝<span id="支付宝"></span></li>
        </ul>
    </div>

    <div class="clear"></div>

    <%--订单--%>
    <div class="concent">

        <div id="payTable">

            <h3>确认订单信息</h3>

            <div class="cart-table-th">
                <div class="wp">
                    <div class="th th-item">
                        <div class="td-inner">商品信息</div>
                    </div>
                    <div class="th th-price">
                        <div class="td-inner">单价</div>
                    </div>
                    <div class="th th-amount">
                        <div class="td-inner">数量</div>
                    </div>
                    <div class="th th-sum">
                        <div class="td-inner">金额</div>
                    </div>
                    <div class="th th-oplist">
                        <div class="td-inner">配送方式</div>
                    </div>

                </div>
            </div>

            <div class="clear"></div>

            <%--购物车--%>
            <c:forEach var="goodsInfo" items="${shopCart.goodsInfoDoMains}">
                <tr class="item-list">
                    <div class="bundle bundle-last">


                        <div class="bundle-main">
                            <ul class="item-content clearfix">
                                <div class="pay-phone">
                                    <li class="td td-item">
                                        <div class="item-pic">
                                            <a href="#" class="J_MakePoint">
                                                <img src="images/${goodsInfo.goods_pic}"
                                                     style="width: 80px; height: 80px" class="itempic J_ItemImg"></a>
                                        </div>
                                        <div class="item-info">
                                            <div class="item-basic-info">
                                                <a href="#" class="item-title J_MakePoint"
                                                   data-point="tbcart.8.11">${goodsInfo.goods_description}</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="td td-price">
                                        <div class="item-price price-promo-promo">
                                            <div class="price-content">
                                                <div class="price-line">
                                                    <em class="price-original">${goodsInfo.goods_price}</em>
                                                </div>
                                                <div class="price-line">
                                                    <em class="J_Price price-now" id="priceNow"
                                                        tabindex="0">${goodsInfo.goods_price_off}</em>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </div>
                                <li class="td td-amount">
                                    <div class="amount-wrapper ">
                                        <div class="item-amount ">
                                            <span class="phone-title">购买数量</span>
                                            <div class="sl">
                                                <input class="min am-btn" name="" type="button" value="-" id="jian"/>
                                                <input class="text_box" id="count" type="text"
                                                       value="${goodsInfo.count}"
                                                       style="width: 30px; text-align: center;"/>
                                                <input class="add am-btn" name="" type="button" value="+" id="jia"/>
                                                <input type="hidden" value="goodsId">
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="td td-sum">
                                    <div class="td-inner">
                                        <em tabindex="0" class="J_ItemSum number" id="singlePrice"><fmt:formatNumber
                                                type="number" value="${totalPrice}" pattern="0.00"/></em>
                                    </div>
                                </li>
                                <li class="td td-oplist">
                                    <div class="td-inner">
                                        <span class="phone-title">配送方式</span>
                                        <div class="pay-logis">
                                            快递<b class="sys_item_freprice">10</b>元
                                        </div>
                                    </div>
                                </li>

                            </ul>
                            <div class="clear"></div>

                        </div>

                    </div>
                </tr>
            </c:forEach>
        </div>
    </div>

    <div class="clear"></div>

    <%--信息--%>

    <div class="order-go clearfix">
        <div class="pay-confirm clearfix">
            <div class="box">
                <div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
                    <span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee"><fmt:formatNumber
                            value="${totalPrice + 10}" pattern="0.00"></fmt:formatNumber></em>
											</span>
                </div>

                <div id="holyshit268" class="pay-address">

                    <p class="buy-footer-address">
                        <span class="buy-line-title buy-line-title-type">寄送至：</span>
                        <span class="buy--address-detail" id="send">

												</span>
                    </p>
                    <p class="buy-footer-address">
                        <span class="buy-line-title">收货人：</span>
                        <span class="buy-address-detail">
                                         <span class="buy-user" id="person">艾迪 </span>
												<span class="buy-phone" id="tel">15871145629</span>
												</span>
                    </p>
                </div>
            </div>

            <div id="holyshit269" class="submitOrder">
                <div class="go-btn-wrap">
                    <a id="go" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
                </div>
                <form action="ShopServlet?action=addOrder" method="post" id="form">
                    <input type="hidden" name="shouhuoren" value="" id="buy_user"/>
                    <input type="hidden" name="phone" value="" id="phone"/>
                    <input type="hidden" name="address" value="" id="address"/>
                    <input type="hidden" name="express" value="" id="express"/>
                    <input type="hidden" name="bank" value="" id="paytype"/>
                </form>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>

</body>
</html>
