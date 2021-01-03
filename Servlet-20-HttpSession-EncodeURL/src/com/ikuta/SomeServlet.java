package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * encodeURL(String url)针对非重定向的Session跟踪问题
 */
public class SomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取Session对象
        HttpSession session = request.getSession();
        System.out.println("SomeServlet session = " + session);

        // 向Session中设置指定属性
        session.setAttribute("user", "zhangsan");

        // 解决Cookie禁用后,非重定向跳转时的Session跟踪问题
        response.setContentType("text/html;charset=UTF-8");
        String uri = "otherServlet";
        uri = response.encodeURL(uri);
        PrintWriter out = response.getWriter();
        out.println("<a href='" + uri + "'>跳转</a>到OtherServlet");
    }

}
