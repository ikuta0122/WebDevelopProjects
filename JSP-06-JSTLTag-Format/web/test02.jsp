<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>------------------格式化数字--------------------<br>
	<fmt:formatNumber value="123456789"></fmt:formatNumber><br>
	<fmt:formatNumber groupingUsed="false" value="123456789"></fmt:formatNumber><br>
	<fmt:formatNumber maxIntegerDigits="8" minIntegerDigits="6" value="12345.6789"></fmt:formatNumber><br>
	<fmt:formatNumber maxFractionDigits="8" minFractionDigits="6" value="12345.6789"></fmt:formatNumber><br>
	
	<br>------------------字符串转变为数字--------------------<br>
	<fmt:parseNumber value="12345.678" integerOnly="true"></fmt:parseNumber><br>
	<fmt:parseNumber var="num" value="12345.678" integerOnly="true"></fmt:parseNumber><br>
	num + 1 = ${num +1 } <br>
</body>
</html>