package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class OtherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取Session对象
        HttpSession session = request.getSession(false);
        System.out.println("OtherServlet session = " + session);

        // 从Session中读取指定属性
        String user = null;
        if (session != null) {
            user = (String) session.getAttribute("user");
        }

        PrintWriter out = response.getWriter();
        out.println("OtherServlet user = " + user);
    }

}
