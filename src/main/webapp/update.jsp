<%--
  Created by IntelliJ IDEA.
  User: 19776
  Date: 2022/4/7
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <h1>修改品牌</h1>
</head>


<body>
<h3>修改品牌</h3>
<form action="/ServletCRUD/updateServlet" method="post">

    <h2>${username} 你好：请填写您要修改的商品信息</h2>


<%--    隐藏域提交id--%>
    <input type="hidden" name="id" value="${brand.id}">
    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description" >${brand.description}</textarea><br>
    状态：
    <input type="radio" name="status" value="0" checked="checked">禁用
    <input type="radio" name="status" value="0">启用<br>

    <input type="submit" value="提交">
</form>
</body>
</html>
