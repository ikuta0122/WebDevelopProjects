<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*,com.ikuta.beans.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    Map<String, Object> map = new HashMap<>();
    map.put("school", new School("北京大学", "中国北京"));
    map.put("name", "小明");
    map.put("age", 21);
    pageContext.setAttribute("map", map);
%>
<%--测试:访问Map集合中的元素 --%>
map.schoolName = ${map.school.schoolName }<br>
map.schoolAddress = ${map.school.address }<br>
map.name = ${map.name }<br>
map.age = ${map.age }<br>
</body>
</html>