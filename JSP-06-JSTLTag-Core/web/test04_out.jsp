<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ikuta.demo.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>------- c:out 若EL中的变量没有定义，则使用default指定的值-------<br>
	<c:set var="department" value="英文系" />
	department = <c:out value="${department }" default="计算机系"/><br>
	department = ${empty department ? '计算机系' : department }<br>
	<br>------- c:out escapeXml属性true表示忽略xml代码,false表示不忽略xml代码-------<br>
	<c:set var="topic" value="<h1>人民日报网</h1>" />
	topic = <c:out value="${topic }"></c:out><br>
	topic = <c:out value="${topic }" escapeXml="false"></c:out><br>
	topic = ${topic }<br>
</body>
</html>