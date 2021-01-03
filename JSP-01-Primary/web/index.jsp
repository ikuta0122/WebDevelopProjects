<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--测试1:
    JSP文件是在传统的静态页面HTML文件中插入Java代码块片段和JSP标签后生成的文件
 --%>
Hello JSP World!

<%--测试2
    JSP注释和HTML注释
--%>
<!-- HTML注释 -->
<%-- JSP注释 --%>

<%--测试3
    JSP的java代码块<% %>
--%>
<%
    //	变量在声明时,不能添加访问控制权限符
    //	private double num = 3.0;
    //	不能定义方法
    //	public static void doSome(){};
    //	不能定义静态代码块
    //	static{}
%>

<%--测试4
    JSP的声明语句块<%! %>
--%>
<%!
    //	变量在声明时,可以添加访问控制权限符
    private double num = 3.0;

    //	可以定义方法
    public static void doSome() {
    }

    ;

    //	可以定义静态代码块
    static {
    }
%>
<br>
<%--测试5
    JSP的表达式块<%= %>
--%>
num = <%= num %>
</body>
</html>