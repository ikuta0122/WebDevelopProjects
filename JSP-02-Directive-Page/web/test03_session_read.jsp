<%@ page language="java"
		 contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    //使用request的getSession()的原则
    //若向Session域中存放数据,使用getSession(true)/getSession()
    //若从Session域中读取数据,使用getSession(false)
    HttpSession session = request.getSession(false);
    out.println("session = " + session);
    if (session != null) {
        String username = (String) session.getAttribute("username");
        out.println("username = " + username);
    }
%>
</body>
</html>