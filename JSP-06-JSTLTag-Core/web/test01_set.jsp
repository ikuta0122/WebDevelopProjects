<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.ikuta.demo.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<br>------- c:set 将变量存放到指定域中-------<br>
<c:set var="name" value="张三" scope="session"></c:set>
name = ${pageScope.name }<br>
name = ${sessionScope.name }<br>

<br>------- c:set 为Bean的属性赋值-------<br>
<%
    Student student = new Student();
    pageContext.setAttribute("student", student);
%>
<c:set target="${pageScope.student }" property="name" value="李四"></c:set>
<c:set target="${pageScope.student }" property="age" value="20"></c:set>
student = ${student }<br>

<br>------- c:set 为Map的属性赋值-------<br>
<%
    Map<String, Object> map = new HashMap<>();
    pageContext.setAttribute("map", map);
%>
<c:set target="${pageScope.map }" property="name" value="王五"></c:set>
<c:set target="${pageScope.map }" property="address" value="中国"></c:set>
map = ${map }<br>
map.name = ${map.name }<br>
map.address = ${map.address }<br>
</body>
</html>