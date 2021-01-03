package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OtherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取请求中的Cookie
        Cookie[] cookies = request.getCookies();
        // 遍历Cookie
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "=" + cookie.getValue());
            // 可以根据遍历获取的Cookie进行更多操作
            if (cookie.getName().equals("idol") && cookie.getValue().equals("ikuta")) {
                // ...
            } else {
                // ...
            }
        }
    }

}
