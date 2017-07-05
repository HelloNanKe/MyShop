<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<c:if test="${user!=null}">
    欢迎您：${user.nickname}!!
    <a href="${pageContext.request.contextPath}/logout">注销</a>
</c:if>
<h2>用户注册和登录</h2>
<c:if test="${user==null}">
    <a href="${pageContext.request.contextPath}/register">注册</a>
    <a href="${pageContext.request.contextPath}/login">登录</a>
</c:if>
</body>
</html>
