package com.ikuta.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class KickServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取到全局域
        ServletContext servletContext = request.getSession().getServletContext();
        // 从全局域中获取map
        Map<String, HttpSession> map = (Map<String, HttpSession>) servletContext.getAttribute("map");
        // 获取要踢出的用户名
        String name = request.getParameter("name");
        // 从map中获取当前用户所对应的Session
        HttpSession session = map.get(name);
        // 使session失效
        session.invalidate();
        // 将该用户对应的entry从map中删除
        map.remove(name);
        // 返回index页面
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

}
