<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://www.ikuta.com/jsp/tags/custom" prefix="myTag" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    List<String> names = new ArrayList<>();
    names.add("张三");
    names.add("李四");
    names.add("王五");
    pageContext.setAttribute("names", names);
%>
<myTag:forEachList items="${names }" var="name">
    ${name }<br>
</myTag:forEachList>
</body>
</html>