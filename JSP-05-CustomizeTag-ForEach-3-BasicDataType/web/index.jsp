<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://www.ikuta.com/jsp/tags/custom" prefix="myTag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>-------------遍历int[]-------------------<br>
	<%
	int[] ages = {20,22,24,26};
	pageContext.setAttribute("ages", ages);
	%>
	<myTag:forEach items="${ages }" var="age">
		${age }<br>
	</myTag:forEach>
</body>
</html>