package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 多次请求多次响应
 * request = org.apache.catalina.connector.RequestFacade@31340fb4
 * response = org.apache.catalina.connector.ResponseFacade@be5fafe
 * request -> org.apache.catalina.core.ApplicationHttpRequest@e7935db
 * response -> org.apache.catalina.core.ApplicationHttpResponse@6458a378
 */
public class SomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // System.out.println("request = " + request);
        // System.out.println("response = " + response);


        response.setContentType("text/html");// 设置响应体内容的MIME类型
        PrintWriter out = response.getWriter();
        out.print("SomeServlet include()before <br>");

        // 请求转发
        request.getRequestDispatcher("other").include(request, response);

        out.print("SomeServlet include()after <br>");
    }

}
