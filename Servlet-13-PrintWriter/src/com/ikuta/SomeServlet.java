package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");// 设置相应的MIME类型
        response.setCharacterEncoding("UTF-8");// 设置MIME的字符编码
        // setContentType()方法可以指定MIME的字符编码,即响应体的字符编码
        // response.setContentType("text/html;charset=UTF-8");

        // 获取标准输出流
        PrintWriter out = response.getWriter();

        // 向标准输出流中写入数据,客户端浏览器就会直接看到这些数据
        out.write("zhangsan");
        out.write("张三");

        // 对标准输出流的关闭
        // out.close();
    }
}
