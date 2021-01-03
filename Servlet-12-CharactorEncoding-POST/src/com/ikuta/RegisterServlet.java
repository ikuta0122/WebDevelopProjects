package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // POST提交时中文乱码问题的解决
        // 设置请求正文的字符编码:setCharacterEncoding(String env)
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
