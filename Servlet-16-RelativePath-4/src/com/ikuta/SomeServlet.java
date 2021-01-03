package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//结论:如果相对路径无论是否加上斜杠都可以完成跳转的话,那么应当加上斜杠
//原因:不加斜杠的相对路径会改变,而加上斜杠的相对路劲不会改变,肯定是当前web应用的根
public class SomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("执行SomeServlet");
        // 后台路径的特例
        // 使用sendRedirect()重定向+相对路径是以斜杠开头
        // 该参照路径是[web服务器的根路径]
        // 注意:只有这种重定向才属于后台路径的特例

        // 以下写法无法完成跳转
        // response.sendRedirect("/otherServlet");
        // 以下写法可以完成跳转,但这样写死了
        // response.sendRedirect("/16-RelativePath-four/otherServlet");
        // 以下写法可以完成跳转(改进版)
        response.sendRedirect(request.getContextPath() + "/otherServlet");

        // Java代码中以路径名称开头的相对路径举例分析
        // response.sendRedirect("otherServlet");
        // 这是一个以路径名称开头的相对路径
        // 其参照路径为:http://localhost:8080/16-RealativePath-four
        // 服务器将其自动转换为绝对路径:http://localhost:8080/16-RealativePath-four/otherServlet
        // 该绝对路径可以访问到OtherServlet
    }

}
