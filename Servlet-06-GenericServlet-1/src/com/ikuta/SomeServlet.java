package com.ikuta;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class SomeServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("执行SomeServlet的service()方法");

		ServletConfig servletConfig = this.getServletConfig();
		
		String username = servletConfig.getInitParameter("username");
		System.out.println(username);
	}
}
