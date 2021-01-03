package com.ikuta;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class SomeServlet implements Servlet {

	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		// System.out.println("config = " + config);
		// config = org.apache.catalina.core.StandardWrapperFacade@d18deaf
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 获取Servlet的名称
		String servletName = config.getServletName();
		System.out.println("servletName = " + servletName);
		// servletName = some-serlvet

		// 获取ServletContext对象
		ServletContext servletContext = config.getServletContext();
		System.out.println("servletContext = " + servletContext);
		// servletContext = org.apache.catalina.core.ApplicationContextFacade@51720c1f

		// 获取初始化参数
		String initParameter1 = config.getInitParameter("username");
		System.out.println("username = " + initParameter1);
		// username = zhangsan
		String initParameter2 = config.getInitParameter("password");
		System.out.println("password = " + initParameter2);
		// password = 123456
		
		// 获取所有的初始化参数
		Enumeration<String> names = config.getInitParameterNames();
		// 遍历枚举
		while (names.hasMoreElements()) {
			// 获取枚举的当前遍历的值
			String name = names.nextElement();
			// 获取指定参数的值
			String value = config.getInitParameter(name);
			System.out.println(name + " = " + value);
		}
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
