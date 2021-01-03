package com.ikuta.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <servlet-mapping>
 * <servlet-name>SomeServlet</servlet-name>
 * <url-pattern>/user/someServlet</url-pattern>
 * </servlet-mapping>
 */
public class SomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("SomeServlet--需要登陆才能访问");
    }

}
