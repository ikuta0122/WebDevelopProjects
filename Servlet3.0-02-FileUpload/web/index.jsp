<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/uploadServlet"
      method="POST"
      enctype="multipart/form-data">
    文件:<input type="file" name="photo"/><br>
    <input type="submit" value="上传"/>
</form>
</body>
</html>