package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 多次请求一次响应
 * request = org.apache.catalina.connector.RequestFacade@3008334b
 * response = org.apache.catalina.connector.ResponseFacade@4a241c79
 * request -> org.apache.catalina.core.ApplicationHttpRequest@71912cfa
 * response -> org.apache.catalina.connector.ResponseFacade@4a241c79
 */
public class SomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // System.out.println("request = " + request);
        // System.out.println("response = " + response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("SomeServlet forward()before <br>");

        // 请求转发
        request.getRequestDispatcher("other").forward(request, response);

        out.print("SomeServlet forward()after <br>");
    }

}
