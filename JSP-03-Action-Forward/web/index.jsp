<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
index page before<br>
<%--使用forward动作 --%>
<jsp:forward page="/next.jsp"></jsp:forward>
index page after<br>
</body>
</html>