<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
${applicationScope.map.size() }人正在看<br>
<a href="${pageContext.request.contextPath }/logoutServlet">安全退出</a><br>
<c:forEach items="${map }" var="entry">
    ${entry.key } = ${entry.value.size() }<br>
</c:forEach>
</body>
</html>