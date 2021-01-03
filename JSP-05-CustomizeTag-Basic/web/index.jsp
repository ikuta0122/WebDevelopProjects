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
    String ip = request.getRemoteAddr();
    out.println("ip = " + ip);
%>
<br>
<br>
<br>
<myTag:clientIp/>
</body>
</html>