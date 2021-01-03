<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/loginServlet" method="POST">
		姓名:<input type="text" name="name"/><br>
		年龄:<input type="text" name="age"/><br>
		<input type="submit" value="登录" />
	</form>
</body>
</html>