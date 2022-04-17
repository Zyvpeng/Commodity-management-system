<%--
  Created by IntelliJ IDEA.
  User: 19776
  Date: 2022/4/7
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>JSTL</title>
</head>

<body>

<%--<%=2+3%>--%>
<td><a href="/ServletCRUD/addBrand.jsp">添加</a></td><br>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>


    <c:forEach items="${brands}" var="brand">
        <tr align="center">
            <td>${brand.id}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status!=1}">
                <td>禁用</td>
            </c:if>

            <c:if test="${brand.status==1}">
                <td>启用</td>
            </c:if>
            <td><a href="/ServletCRUD/deleteBrand?id=${brand.id}">删除</a></a> </td>


        </tr>
    </c:forEach>

</table>


</body>
</html>
