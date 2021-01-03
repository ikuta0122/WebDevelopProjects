<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/loginServlet"
		method="POST">
		用户名:<input type="text" name="username" /><br>
		<input type="submit" value="登录" />
	</form>
</body>
</html>