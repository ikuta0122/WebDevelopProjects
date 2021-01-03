package com.ikuta;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpServlet extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        // JAVA中不支持真正的向下转型,但如果父类对象本身是由子类对象转型而来的,可以通过强转的方式实现向下转型
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        service(request, response);
    }

    public void service(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求的提交方式
        String method = request.getMethod();
        // 根据获取的请求方式对事务进行处理
        if ("POST".equals(method)) {
            doPost(request, response);
        } else if ("GET".equals(method)) {
            doGet(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("GET提交");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("POST提交");
    }
}
