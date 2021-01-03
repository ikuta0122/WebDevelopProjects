package com.ikuta;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/*
模板方法设计模式
*/
public abstract class GenericServlet implements Servlet, ServletConfig {
	private ServletConfig config;

	/**
	 * 该无参init()方法就是要让子类来重写的
	 */
	public void init() {

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		// 调用无参的init()方法
		this.init();
		System.out.println("执行父类的init()方法");
	}

	/**
	 * 抽象方法专门让子类实现
	 */
	@Override
	public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

	@Override
	public void destroy() {

	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public String getInitParameter(String name) {
		return config.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return config.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		return config.getServletContext();
	}

	@Override
	public String getServletName() {
		return config.getServletName();
	}
}
