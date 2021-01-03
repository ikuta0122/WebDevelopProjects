<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--测试:获取当前页面的请求路径--%>
<form action="${pageContext.request.contextPath }/registerServlet" method="POST">
    账号:<input type="text" name="username"/><br>
    密码:<input type="password" name="password"/><br>
    <input type="submit" value="注册"/>
</form>
</body>
</html>