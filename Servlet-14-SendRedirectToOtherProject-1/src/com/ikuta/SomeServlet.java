package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("执行SomeServlet");
        System.out.println("");
        // 重定向到其他应用(例如:Servlet-14-SendRedirectToOtherProject-2)
        response.sendRedirect("/Servlet_14_SendRedirectToOtherProject_2/other");
        //IDEA自动将-转换为_
    }

}
