package com.ikuta.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class SomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("SomeServlet已被动态注册<br>");
        Enumeration<String> names = this.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = this.getInitParameter(name);
            out.println(name + " = " + value + "<br>");
        }
    }

}
