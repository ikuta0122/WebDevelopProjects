<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--测试substring()方法
    浏览器显示结果:cde
--%>
${fn:substring("abcdefg",2,5) }
<br><br><br>
<%--测试substringBefore()方法
    浏览器显示结果:ab
--%>
${fn:substringBefore("abcdefg","cd") }
<br><br><br>
<%--测试substringAfter()方法
    浏览器显示结果:efg
--%>
${fn:substringAfter("abcdefg","cd") }
<br><br><br>
</body>
</html>