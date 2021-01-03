<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.ikuta.com/jsp/tags/custom" prefix="myTag" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    boolean gender = false;
    pageContext.setAttribute("gender", gender);
%>
<myTag:if test="${gender }">男</myTag:if><br>
<myTag:if test="${!gender }">女</myTag:if><br>
</body>
</html>