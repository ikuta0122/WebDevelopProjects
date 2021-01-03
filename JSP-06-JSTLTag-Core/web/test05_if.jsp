<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ikuta.demo*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>------- c:if -------<br>
	<c:set var="user" value="张三" scope="session"></c:set>
	<c:if test="${user == '张三'}">
		<a href="#">进入系统</a>
	</c:if>
</body>
</html>