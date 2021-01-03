package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class SomeServlet extends GenericServlet {
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
        super.init();
        System.out.println("执行子类的init()方法");
    }

}
