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
    List<String> names = new ArrayList<>();
    names.add("张三");
    names.add("李四");
    names.add("王五");
    pageContext.setAttribute("names", names);
%>
<%--测试1:访问数组中的元素 --%>
names[0] = ${names[0] }<br>
names[1] = ${names[1] }<br>
names[2] = ${names[2] }<br>
<%--测试2:访问数组元素的下标越界
    EL表达式不会抛出下标越界异常,仅仅不显示而已
--%>
names[5] = ${names[5] }<br>

</body>
</html>