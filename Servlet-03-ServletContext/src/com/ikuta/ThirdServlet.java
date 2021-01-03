package com.ikuta;

import javax.servlet.*;
import java.io.IOException;

public class ThirdServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 获取SerlvetContext对象
        ServletContext servletContext = config.getServletContext();

        // 获取域属性的值
        String email = (String) servletContext.getAttribute("email");
        String mobile = (String) servletContext.getAttribute("mobile");
        System.out.println("email = " + email);
        System.out.println("mobile = " + mobile);

        // 获取应用名称
        String contextPath = servletContext.getContextPath();
        System.out.println("contextPath = " + contextPath);//Servlet_03_ServletContext

        // 获取资源在本地的绝对路径
        String realPath = servletContext.getRealPath("/images");
        System.out.println("realPath = " + realPath);//realPath = E:\IDEAProjects\WebDevelopProjects\out\artifacts\Servlet_03_ServletContext_war_exploded\images
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

}
