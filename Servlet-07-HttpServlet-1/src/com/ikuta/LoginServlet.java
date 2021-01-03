package com.ikuta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 继承自定义HttpServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("非法登陆");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("下一步进入用户身份验证阶段");
    }
}
