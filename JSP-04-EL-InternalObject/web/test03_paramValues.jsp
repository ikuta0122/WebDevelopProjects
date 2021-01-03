<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/test03_paramValues_show.jsp" method="POST">
    账号:<input type="text" name="username"/>
    <br>
    密码:<input type="password" name="password"/>
    <br>
    爱好:
    <input type="checkbox" name="hobby" value="swimming"/>游泳
    <input type="checkbox" name="hobby" value="reading"/>阅读
    <input type="checkbox" name="hobby" value="running"/>跑步
    <br>
    <input type="submit" value="注册"/>
</form>
</body>
</html>