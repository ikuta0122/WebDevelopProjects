package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OtherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取Session对象
        HttpSession session = request.getSession(false);

        // 从request域属性空间中读取user属性
        String username_request = request.getParameter("username_request");
        response.getWriter().println("OtherServlet:" + username_request);//null

        // 从request域属性空间中读取user属性
        String username_session = null;
        if (session != null) {
            username_session = (String) session.getAttribute("username_session");
        }
        response.getWriter().println("OtherServlet:" + username_session);
    }
}
