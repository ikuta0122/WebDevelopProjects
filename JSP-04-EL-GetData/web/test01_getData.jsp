<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--
    EL只能从四大域属性空间[pageContext,request,session,application]中获取数据
    以下方式是无法获取到指定数据的,因为这个数据没有存放到四大域属性空间中
--%>
<%
    String test01 = "张三";
%>
test01 = ${test01}
<br>

<%--
    规范1:将数据放入四大域属性空间中,然后通过EL表达式获取
--%>
<%
    String test02 = "张三";
    //pageContext.setAttribute("test02", test02);
    //request.setAttribute("test02", test02);
    //session.setAttribute("test02", test02);
    application.setAttribute("test02", test02);
%>
test02 = ${test02}
<br>

<%--
    规范2:EL表达式按照由小到大的范围从四大域属性空间中获取数据
--%>
<%
    pageContext.setAttribute("test03", "一号");
    request.setAttribute("test03", "二号");
    session.setAttribute("test03", "三号");
    application.setAttribute("test03", "四号");
%>
test03 = ${test03}
<br>

<%--
    规范3:EL表达式从指定域中获取数据
--%>
test03 = ${applicationScope.test03}
<br>
</body>
</html>