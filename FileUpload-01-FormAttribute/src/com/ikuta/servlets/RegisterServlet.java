package com.ikuta.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 以输入流的形式获取multipart请求的请求体内容
        ServletInputStream inputStream = request.getInputStream();
        // 获取标准输出流对象
        PrintWriter out = response.getWriter();
        // 将输入流中的数据写入到标准输出流中
        int len;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {
            String string = new String(buffer, 0, len);
            out.println(string);
        }
        // 关闭输入流
        inputStream.close();
    }

}
