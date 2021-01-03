package com.ikuta;

import javax.servlet.*;
import java.io.IOException;

/*
缺省适配器设计模式
*/
public abstract class GenericServlet implements Servlet {

	private ServletConfig config;

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
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	/**
	 * 抽象方法专门让子类实现
	 */
	@Override
	public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

}
