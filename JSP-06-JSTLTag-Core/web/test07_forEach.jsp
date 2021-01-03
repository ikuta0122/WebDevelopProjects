<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.ikuta.demo.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        /* 奇数行颜色 */
        .odd {
            background-color: #eee;
        }

        /* 偶数行颜色 */
        .even {
            background-color: #888;
        }
    </style>
</head>
<body>
<br>------- c:forEach begin属性,end属性,step属性-------<br>
<%
    double[] scores = {50.9, 70.9, 99.9, 100};
    pageContext.setAttribute("scores", scores);
%>
<c:forEach items="${scores }" var="score" begin="0" end="3" step="2">
    ${score }<br>
</c:forEach>

<br>------- c:forEach 应用-------<br>
<%
    List<Student> students = new ArrayList<>();
    students.add(new Student("张三", 20));
    students.add(new Student("李四", 21));
    students.add(new Student("王五", 19));
    pageContext.setAttribute("students", students);
%>
<table border="1">
    <tr>
        <th>序号</th>
        <th>年龄</th>
        <th>姓名</th>
    </tr>
    <c:forEach var="student" items="${students }" varStatus="vs">
        <tr class="${vs.count %2 == 0 ? 'even' : 'odd' }">
            <td>${vs.count }</td>
                <%-- <td>${vs.index }</td> --%>
            <td>${student.name }</td>
            <td>${student.age }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>