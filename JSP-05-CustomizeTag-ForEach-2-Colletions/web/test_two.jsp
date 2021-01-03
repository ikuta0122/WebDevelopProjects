<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://www.ikuta.com/jsp/tags/custom" prefix="myTag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>-------------遍历List-------------------<br>
	<%
	List<String> names = new ArrayList<>();
	names.add("张三");
	names.add("李四");
	names.add("王五");
	pageContext.setAttribute("names", names);
	%>
	<myTag:forEach_two items="${names }" var="name">
		${name }<br>
	</myTag:forEach_two>
	
	<br>-------------遍历Set-------------------<br>
	<%
	Set<String> schools = new HashSet<>();
	schools.add("清华大学");
	schools.add("北京大学");
	schools.add("东京大学");
	pageContext.setAttribute("schools", schools);
	%>
	<myTag:forEach_two items="${schools }" var="school">
		${school }<br>
	</myTag:forEach_two>
	
	<br>-------------遍历Map-------------------<br>
	<%
	Map<String,Object> infos = new HashMap<>();
	infos.put("name", "赵六");
	infos.put("age", 26);
	infos.put("score",95.5);
	pageContext.setAttribute("infos", infos);
	%>
	<myTag:forEach_two items="${infos }" var="info">
		${info }<br>
	</myTag:forEach_two>

	<br>-------------遍历Object[]-------------------<br>
	<%
	Object[] citys = {"北京","上海","广州"};
	pageContext.setAttribute("citys", citys);
	%>
	<myTag:forEach_two items="${citys }" var="city">
		${city }<br>
	</myTag:forEach_two>
</body>
</html>