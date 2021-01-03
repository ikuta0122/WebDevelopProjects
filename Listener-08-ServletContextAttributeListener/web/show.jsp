<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	show page<br>
	<%
	application.setAttribute("username", "zhangsan");
	application.setAttribute("username", "lisi");
	application.removeAttribute("username");
	%>
</body>
</html>