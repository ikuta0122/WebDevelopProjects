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
<%--需求:将源字符串中的字符转换为大写形式 --%>
<%
    String username = "zhangsan";
    pageContext.setAttribute("username", username);
%>
<myTag:LowerToUpper>zhangsan</myTag:LowerToUpper>
<br>
<myTag:LowerToUpper>${username }</myTag:LowerToUpper>
<br>
</body>
</html>