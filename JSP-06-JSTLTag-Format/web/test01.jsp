<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<br>---------------格式化日期---------------------<br>
<%
    Date nowTime = new Date();
    pageContext.setAttribute("nowTime", nowTime);
%>
nowTime = ${nowTime }<br>
nowTime = <fmt:formatDate value="${nowTime }" pattern="yyyy-MM-dd"/><br>
nowTime = <fmt:formatDate var="birthday" value="${nowTime }" pattern="yyyy-MM-dd"/><br>
birthday = <input type="text" name="birthday" value="${birthday }"><br>

<br>---------------字符串转变为日期---------------------<br>
<fmt:parseDate value="1970-01-01"></fmt:parseDate><br>
<fmt:parseDate pattern="yyyy/MM/dd" value="1970/01/01"></fmt:parseDate><br>
<fmt:parseDate var="initDay" pattern="yyyy/MM/dd" value="1970/01/01"></fmt:parseDate><br>
initDay = ${initDay }<br>
</body>
</html>