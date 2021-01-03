<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--测试:获取请求中的指定参数值
    底层实际调用的是request.getParameter()方法
--%>
username = ${param.username }<br>
password = ${param.password }<br>
<%--测试:获取请求中的指定参数的所有值
    底层实际调用的是request.getParameterValues()方法
--%>
hobby[0] = ${paramValues.hobby[0] }<br>
hobby[1] = ${paramValues.hobby[1] }<br>
hobby[2] = ${paramValues.hobby[2] }<br>
</body>
</html>