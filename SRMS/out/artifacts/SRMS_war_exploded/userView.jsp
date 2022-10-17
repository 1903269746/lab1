<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${user.ucode}</span></p>
            <p><strong>用户名称：</strong><span>${user.uname}</span></p>

            <p><strong>性别：</strong><span>
                <c:if test="${user.usex==1}">男</c:if>
                <c:if test="${user.usex==0}">女</c:if>
            </span></p>

            <p><strong>出生日期：</strong><span>${user.ubirthday}</span></p>
            <p><strong>用户电话：</strong><span>${user.uphone}	</span></p>
            <p><strong>用户地址：</strong><span>${user.uaddress}</span></p>

            <p><strong>用户类别：</strong><span>
                <c:if test="${user.rid==1}">超级管理员</c:if>
                <c:if test="${user.rid==2}">普通管理员</c:if>
            </span></p>

            <p><strong>用户状态：</strong><span>
                <c:if test="${user.ustatus==1}">启用</c:if>
                <c:if test="${user.ustatus==0}">禁用</c:if>
            </span></p>


        </div>
        <a href="selectAll" >返回</a>
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

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head lang="en">--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title> 静态资源后台管理系统</title>--%>
<%--    <link rel="stylesheet" href="css/public.css"/>--%>
<%--    <link rel="stylesheet" href="css/style.css"/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<!--头部-->--%>
<%--<header class="publicHeader">--%>
<%--    <h1> 静态资源后台管理系统</h1>--%>
<%--    <div class="publicHeaderR">--%>
<%--        <div style="width: 46px;height: 46px;border-radius: 50%;overflow: hidden;margin-left: -100px;float: left">--%>
<%--            <img style="width: 100%" src="img/head_img.jpeg" alt="头像">--%>
<%--        </div>--%>
<%--        <span style="float: left" ><a href="login.html">退出</a></span>--%>
<%--    </div>--%>
<%--</header>--%>
<%--<!--时间-->--%>
<%--<section class="publicTime">--%>
<%--    <span id="time">2019年1月1日 11:11  星期一</span>--%>
<%--    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>--%>
<%--</section>--%>
<%--<!--主体内容-->--%>
<%--<section class="publicMian ">--%>
<%--    <div class="left"></div>--%>
<%--    <div class="right">--%>
<%--        <div class="location">--%>
<%--            <strong>你现在所在的位置是:</strong>--%>
<%--            <span>用户管理页面 >> 用户信息查看页面</span>--%>
<%--        </div>--%>
<%--        <div class="providerView">--%>
<%--            <p><strong>用户编号：</strong><span>W10000001</span></p>--%>
<%--            <p><strong>用户名称：</strong><span>火影忍者</span></p>--%>
<%--            <p><strong>用户性别：</strong><span>男</span></p>--%>
<%--            <p><strong>出生日期：</strong><span>2004/2/1</span></p>--%>
<%--            <p><strong>用户电话：</strong><span>159XXXX9999	</span></p>--%>
<%--            <p><strong>用户地址：</strong><span>北京丰台区</span></p>--%>
<%--            <p><strong>用户类别：</strong><span>VIP玩家</span></p>--%>
<%--            <p><strong>用户状态：</strong><span>启动</span></p>--%>
<%--            <a href="userList.html">返回</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<%--<footer class="footer">--%>
<%--</footer>--%>
<%--<script src="js/time.js"></script>--%>
<%--<script src="js/jquery.js"></script>--%>
<%--<script>--%>
<%--    $(function () {--%>
<%--        $(".left").load("common_pri.html");--%>
<%--    }) ;--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>