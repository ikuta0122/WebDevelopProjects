<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<caption>已登录用户</caption>
		<tr>
			<th>用户名</th>
			<th>session</th>
			<th>踢出</th>
		</tr>
		<c:forEach items="${map }" var="entry">
			<tr>
				<td>
					${entry.key }
				</td>
				<td>
					${entry.value }
				</td>
				<td>
					<a href="${pageContext.request.contextPath }/kickServlet?name=${entry.key }">踢出</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>