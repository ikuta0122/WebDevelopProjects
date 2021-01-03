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
<br>------- c:set 准备删除数据-------<br>
<c:set var="school" value="pag_school" scope="page"></c:set>
<c:set var="school" value="req_school" scope="request"></c:set>
<c:set var="school" value="ses_school" scope="session"></c:set>
<c:set var="school" value="app_school" scope="application"></c:set>
school = ${pageScope.school }<br>
school = ${requestScope.school }<br>
school = ${sessionScope.school }<br>
school = ${applicationScope.school }<br>
<br>------- c:remove 删除指定域中的属性-------<br>
<c:remove var="school" scope="session"/>
school = ${pageScope.school }<br>
school = ${requestScope.school }<br>
school = ${sessionScope.school }<br>
school = ${applicationScope.school }<br>
<br>------- c:remove 删除所有域中的属性-------<br>
<c:remove var="school"/>
school = ${pageScope.school }<br>
school = ${requestScope.school }<br>
school = ${sessionScope.school }<br>
school = ${applicationScope.school }<br>
</body>
</html>