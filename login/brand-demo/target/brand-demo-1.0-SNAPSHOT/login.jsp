<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>login</title>
  <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
  <form action="/brand-demo/loginServlet" id="form" method="post">
    <h1 id="loginMsg">LOGIN</h1>
    <div id="errorMsg">${login_msg}${register_msg}</div>
    <p>Username:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>
    <p>Password:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
    <p>Remember:<input id="remember" name="remember"  value="1" type="checkbox"></p>
    <div id="subDiv">
      <input type="submit" class="button" value="login up">
      <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
      <a href="register.jsp">没有账号？</a>
    </div>
  </form>
</div>

</body>
</html>