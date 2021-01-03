<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ikuta.demo.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>------- c:catch 捕捉异常信息-------<br>
	<c:catch var="ex">
		<%
		int i = 3/0;
		%>
	</c:catch>
	ex = ${ex.message }<br>
</body>
</html>