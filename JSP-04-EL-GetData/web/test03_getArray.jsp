<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    String[] names = {"张三", "李四", "王五"};
    pageContext.setAttribute("names", names);
%>
<%--测试1:访问数组中的元素 --%>
names[0] = ${names[0] }<br>
names[1] = ${names[1] }<br>
names[2] = ${names[2] }<br>

<%--测试2:访问数组元素的下标越界
    如果访问的数组元素小标越界,EL表达式不会抛出下标越界异常,仅仅是不显示而已
--%>
names[5] = ${names[5] }<br>
</body>
</html>