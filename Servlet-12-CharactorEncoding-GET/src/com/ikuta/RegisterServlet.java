package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // GET提交的中文乱码问题的解决(适用于TOMCAT8以下的版本)
        // 此处接收到的name,其字符编码为ISO8859-1
        String name = request.getParameter("name");
        // 将name字符串按照原编码进行打散
        byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
        // 将bytes字节数组按照指定字符编码进行组装
        name = new String(bytes, StandardCharsets.UTF_8);
        String age = request.getParameter("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
