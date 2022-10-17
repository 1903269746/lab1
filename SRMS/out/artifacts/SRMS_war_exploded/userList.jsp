<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="cn.wolfcode.entity.T_User" %>
<%@ page import="cn.wolfcode.entity.T_priviage" %>
<%@ page import="java.util.List" %>
<%
     //获取session中的用户
    T_User userInfo = (T_User)session.getAttribute("userInfo");
    //获取用户的权限
    List<T_priviage> priList = userInfo.getPriList();
    //判定用户权限中是否包含用户管理模块权限

    for(T_priviage pri:priList){
        if(pri.getPname().equals("用户管理")){
            //获取这个模块权限对应的按钮级的权限
            List<T_priviage> son = pri.getPriList();
            //有了这个按钮级别的权限-做个标志
            //遍历
            for(T_priviage sonPri:son){
                //判定是否存在该按钮级别权限
                if(sonPri.getPname().equals("用户管理_查询")){
                    //设置
                    pageContext.setAttribute("user_select",true);
                    pageContext.setAttribute("user_select_url",sonPri.getPurl());
                }
                if(sonPri.getPname().equals("用户管理_编辑")){
                    //设置
                    pageContext.setAttribute("user_edit",true);
                }
                if(sonPri.getPname().equals("用户管理_新增")){
                    //设置
                    pageContext.setAttribute("user_add",true);
                }
                if(sonPri.getPname().equals("用户管理_详情")){
                    //设置
                    pageContext.setAttribute("user_details",true);
                }
                if(sonPri.getPname().equals("用户管理_删除")){
                    //设置
                    pageContext.setAttribute("user_delete",true);
                }
            }
            //结束
            continue ;
        }
    }
%>
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
                <span>用户管理页面</span>
            </div>
            <c:if test="${user_select}">
            <div class="search">
                <span>查询条件：</span>
                    <form method="post" action="selectBySingle">
                        <input type="text" name="str" placeholder="请输入关键字(编号，用户名，电话号码）"/>
                        <input type="submit" value="查询"/>
                    </form>
                </c:if>

                <c:if test="${user_add}">
                    <a href="userAdd.jsp">新增用户</a>
                </c:if>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编号</th>
                    <th width="15%">用户名称</th>
                    <th width="4%">头像</th>
                    <th width="10%">性别</th>
                    <th width="12%">电话</th>
                    <th width="10%">类型</th>
                    <th width="8%">状态</th>
                    <th width="15%">操作</th>
                </tr>
                <c:forEach items="${userList}" var="user" varStatus="status">
                    <tr align="center">
                            <%--<td>${brand.id}</td>--%>
                        <td>${user.ucode}</td>
                        <td>${user.uname}</td>
                                <td>
                                    <div style="width: 46px;height: 46px;border-radius: 50%;overflow: hidden;float: left;">
                                        <img style="width: 100%" src="img/head_img.jpeg" alt="头像" >
                                    </div>
                                </td>
                       <c:if test="${user.usex == 0}">
                           <td>女</td>
                       </c:if>
                        <c:if test="${user.usex == 1}">
                            <td>男</td>
                        </c:if>
                        <td>${user.uphone}</td>
                                <c:if test="${user.rid == 2}">
                                    <td>普通管理员</td>
                                </c:if>
                                <c:if test="${user.rid == 1}">
                                    <td>超级管理员</td>
                                </c:if>
                        <c:if test="${user.ustatus == 1}">
                            <td>启用</td>
                        </c:if>
                        <c:if test="${user.ustatus != 1}">
                            <td>禁用</td>
                        </c:if>

                                <td>
                                    <c:if test="${user_details}">
                                        <a href="/SRMS_war_exploded/selectByUcode2?ucode=${user.ucode}"><img src="img/read.png" alt="查看" title="查看"/></a>
                                    </c:if>
                                    <c:if test="${user_edit}">
                                        <a href="/SRMS_war_exploded/selectByUcode?ucode=${user.ucode}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                                    </c:if>
                                    <c:if test="${user_delete}">
                                        <a href="/SRMS_war_exploded/selectByUcode3?ucode=${user.ucode}" class="removeUser"><img src="img/schu.png" alt="删除" title="删除"/></a>
                                    </c:if>
                                </td>
                    </tr>

                </c:forEach>

                </tr>
            </table>
        </div>
    </section>



    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<!--<script src="js/js.js"></script>-->
<!--<script src="js/time.js"></script>-->
<script>

</script>
<script>
    $(function () {
        $(".left").load("common_pri.jsp");
    }) ;
</script>
</body>
</html>