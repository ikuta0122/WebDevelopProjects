<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    //变量test01未声明
    //声明变量:String类型变量
    String test02 = "";
    pageContext.setAttribute("test02", test02);
    //声明变量:引用数据类型变量
    Object test03 = null;
    pageContext.setAttribute("test03", test03);
    //声明变量:集合变量
    List<String> test04 = new ArrayList<>();
    pageContext.setAttribute("test04", test04);
%>
<%--测试empty运算符 --%>
test01IsEmpty = ${empty test01 }<br>
test02IsEmpty = ${empty test02 }<br>
test02IsEmpty = ${empty test03 }<br>
test03IsEmpty = ${empty test04 }<br>
</body>
</html>