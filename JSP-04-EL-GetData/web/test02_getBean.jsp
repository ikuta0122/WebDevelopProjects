<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.ikuta.beans.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    School school = new School("北京大学", "北京海淀区");
    Student student = new Student("张三", 20, school);
    pageContext.setAttribute("student", student);
%>
<%-- 测试1:访问student的name和age属性 --%>
name = ${student.name}<br>
age = ${student.age}<br>

<%-- 这种方式不常用 --%>
name = ${student['name']}<br>
age = ${student['age']}<br>

<%-- 测试2:如果访问对象为null的属性,EL是不会抛出空指针异常的,仅仅是不显示而已 --%>
name5 = ${student5.name}<br>

<%-- 测试3:访问学生的学校的名称和地址 --%>
schoolName = ${student.school.schoolName }<br>
schoolAddress = ${student.school.address }<br>
</body>
</html>