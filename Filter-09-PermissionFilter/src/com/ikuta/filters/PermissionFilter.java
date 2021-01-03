package com.ikuta.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PermissionFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String servletPath = req.getServletPath();
        // 如果ServletPath以"/user"开头,那么这个请求的资源必须登陆以后才可访问
        if (servletPath.startsWith("/user")) {
            HttpSession session = req.getSession(false);
            if (session != null) {// 如果session不为null,则需要判断user
                String user = (String) session.getAttribute("user");
                if (user != null) {// 如果user不为null,则说明已经登陆,此时放行
                    chain.doFilter(request, response);
                } else {// 如果user为null,则说明没有登陆,此时跳转到登录页面
                    req.getRequestDispatcher("/login.jsp").forward(request, response);
                    return;
                }
            } else {// 如果session为null,则说明没有登陆,此时跳转到登录页面
                req.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }
        } else {
            // 如果ServletPath不以"/user"开头,那么这个请求的资源无需登录以后就可访问
            chain.doFilter(request, response);
        }
    }

}
