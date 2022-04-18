<%--
  Created by IntelliJ IDEA.
  User: 19776
  Date: 2022/4/10
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="...">
    <form action="/ServletCRUD/ServletLogin" method="post" id="form">
        <h1 id="loginMsg">LOGIN IN</h1>
<%--        登录错误提示信息，jsp会从域中寻找，如果没有就不会显示错误信息--%>
        <div id="errorMsg">${login_msg}</div>
        <p>Username:<input id="username" name="username" value="${cookie.username.value}" type="text"></p>

        <p>Password:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>

        <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>

        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.html">没有账号？点击注册</a>
        </div>
    </form>
</div>




</body>
</html>
