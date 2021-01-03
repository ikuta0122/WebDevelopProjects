package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Cookie禁用之前
 * SomeServlet session = org.apache.catalina.session.StandardSessionFacade@32d28c1f
 * OtherServlet session = org.apache.catalina.session.StandardSessionFacade@32d28c1f
 * Cookie禁用之后
 * SomeServlet session = org.apache.catalina.session.StandardSessionFacade@4baa4f78
 * OtherServlet session = null
 * 使用encodeRedirectURL(String url)方法之后
 * SomeServlet session = org.apache.catalina.session.StandardSessionFacade@57ef009b
 * OtherServlet session = org.apache.catalina.session.StandardSessionFacade@57ef009b
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

        //encodeRedirectURL(String url)针对重定向的Session跟踪问题
        String uri = request.getContextPath() + "/otherServlet";
        uri = response.encodeRedirectURL(uri);
        response.sendRedirect(uri);
    }

}
