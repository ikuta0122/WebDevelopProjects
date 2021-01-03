<%@ page pageEncoding="UTF-8" %>
<%@ page import="com.ikuta.beans.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
show page<br>
<%
    Student student = new Student("张三", 21);
    session.setAttribute("stu", student);
%>
</body>
</html>