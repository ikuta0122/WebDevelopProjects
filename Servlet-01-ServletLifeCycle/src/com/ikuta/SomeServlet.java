package com.ikuta;

import javax.servlet.*;
import java.io.IOException;

public class SomeServlet implements Servlet {

    public SomeServlet() {
        System.out.println("创建SomeServlet实例");
    }

    @Override
    public void destroy() {
        System.out.println("销毁SomeServlet实例");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return "Servlet的说明信息(版本,作者,所在应用)";
    }

    @Override
    public void init(ServletConfig arg0) throws ServletException {
        System.out.println("初始化SomeServlet实例");
    }

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        System.out.println("执行SomeServlet实例的service()方法");
    }
}
