package com.ikuta;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
测试web容器启动时创建Servlet的优先级问题
*/
public class SomeServlet2 implements Servlet {

	public SomeServlet2() {
		System.out.println("创建SomeServlet2实例");
	}

	@Override
	public void destroy() {
		System.out.println("销毁SomeServlet2实例");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("初始化SomeServlet2实例");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("执行SomeServlet2实例的service()方法");
	}
}
