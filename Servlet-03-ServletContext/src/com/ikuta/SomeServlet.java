package com.ikuta;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/*执行顺序
SomeServlet--->ThirdServlet--->OtherServlet--->ThirdServlet
*/
public class SomeServlet implements Servlet {

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

        // 获取所有初始化参数
        Enumeration<String> names = servletContext.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = servletContext.getInitParameter(name);
            System.out.println(name + " = " + value);
        }

        // 首次设置域属性
        servletContext.setAttribute("email", "527920879@qq.com");
        servletContext.setAttribute("mobile", "1234657");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

}
