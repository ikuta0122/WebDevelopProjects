<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/registerServlet"
		method="POST" enctype="multipart/form-data">
		姓名:<input type="text" name="name" /><br> 年龄:<input type="text"
			name="age" /><br> 照片:<input type="file" name="photo" /><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>