﻿<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title> 静态资源后台管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1> 静态资源后台管理系统</h1>

    <div class="publicHeaderR">
        <div style="width: 46px;height: 46px;border-radius: 50%;overflow: hidden;margin-left: -100px;float: left">
            <img style="width: 100%" src="img/head_img.jpeg" alt="头像">
        </div>
        <span style="float: left" ><a href="login.jsp">退出</a></span>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2019年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left"></div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="deleteByUcode" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <!--隐藏域，提交ucode-->
                <input type="hidden" name="ucode" value="${user.ucode}"/>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" placeholder="${user.uname}"/>
                    <span >*</span>
                </div>

                <div>
                    <label >用户性别：</label>
<!-- <select name="userSex">
                        <option value="man">男</option>
                        <option value="woman">女</option>
                    </select>-->
<%--                    <select name="usex">--%>
<%--                        <option value="man" selected>男</option>--%>
<%--                        <option value="woman" >女</option>--%>
<%--                    </select>--%>
                    <input type="text" name="usex"  placeholder="<c:if test='${user.usex==1}'>男</c:if>
                                                                <c:if test='${user.usex==0}'>女</c:if>"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="text" name="data" id="data" placeholder="${user.ubirthday}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="userphone" id="userphone" placeholder="${user.uphone}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress" placeholder="${user.uaddress}"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="userlei" value="super"/>超级管理员
                    <input type="radio" name="userlei" value="normal" checked/>普通管理员
                </div>
                <div>
                    <label >用户状态：</label>
                    <input type="radio" name="ustatus" value="off"/>停用
                    <input type="radio" name="ustatus" value="on" checked/>启用
                </div>

                <div class="providerAddBtn">
                    <input type="submit" value=确认删除 />
                    <a href="selectAll">返回</a>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>
<script src="js/jquery.js"></script>
<script>
    $(function () {
        $(".left").load("common_pri.jsp");
    }) ;
</script>
</body>
</html>