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
	<br>------- c:choose -------<br>
	<c:set var="pageno" value="3"></c:set>
	<c:set var="totalpage" value="5"></c:set>
	<c:choose>
		<c:when test="${totalpage == 1 }">
			首页
			上一页
			下一页
			末页
			当前:${pageno } / ${totalpage } 页
		</c:when>
		<c:when test="${pageno == 1 }">
			首页
			上一页
			<a href="#">下一页</a>
			<a href="#">末页</a>
			当前:${pageno } / ${totalpage } 页
		</c:when>
		<c:when test="${pageno == 5 }">
			<a href="#">首页</a>
			<a href="#">上一页</a>
			下一页
			末页
			当前:${pageno } / ${totalpage } 页
		</c:when>
		<c:otherwise>
			<a href="#">首页</a>
			<a href="#">上一页</a>
			<a href="#">下一页</a>
			<a href="#">末页</a>
			当前:${pageno } / ${totalpage } 页
		</c:otherwise>
	</c:choose>
</body>
</html>