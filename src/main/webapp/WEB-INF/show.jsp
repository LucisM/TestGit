<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2018/11/23
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>
<h1>${341234}</h1>
<c:forEach items="${test }" var="c" varStatus="st">
    <tr>
        <td>${c.name}</td>
        <td>${c.number}</td>
    </tr>
</c:forEach>
</body>
</html>

