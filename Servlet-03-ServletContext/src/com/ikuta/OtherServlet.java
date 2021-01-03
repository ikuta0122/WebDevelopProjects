package com.ikuta;

import javax.servlet.*;
import java.io.IOException;

public class OtherServlet implements Servlet {

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

		// 重置域属性的值
		servletContext.setAttribute("email", "934442950@qq.com");
		
		// 删除域属性
		servletContext.removeAttribute("mobile");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
