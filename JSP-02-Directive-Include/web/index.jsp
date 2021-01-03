<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index page before
	<br>
	<%@ include file="/next.jsp"%>
	index page after
	<br>
	<%--include指令静态连编,实现jsp文件间的变量共享--%>
	<%
		out.println("username = " + username);
	%>
</body>
</html>