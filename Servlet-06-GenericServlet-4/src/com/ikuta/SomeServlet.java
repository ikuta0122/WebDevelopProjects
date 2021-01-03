package com.ikuta;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 使用系统写好的GenericServlet
 */
public class SomeServlet extends GenericServlet {
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("执行SomeServlet的service()方法");

        String username = this.getInitParameter("username");
        System.out.println(username);
        String servletName = this.getServletName();
        System.out.println(servletName);
    }

    /**
     * 重写父类的无参init()方法
     */
    @Override
    public void init() {
        System.out.println("执行子类的init()方法");
    }
}
