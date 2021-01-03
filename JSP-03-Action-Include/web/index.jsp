<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index page before<br> 
	<%--使用include动作 --%>
	<jsp:include page="/next.jsp"></jsp:include>	
	index page after<br>
</body>
</html>