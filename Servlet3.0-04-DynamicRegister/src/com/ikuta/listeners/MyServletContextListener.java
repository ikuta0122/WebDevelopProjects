package com.ikuta.listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.EnumSet;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 获取ServletContext
		ServletContext sc = sce.getServletContext();

		/*-----------动态注册Servlet---------------*/
		// 动态注册Servlet(servletName和className一般是从配置文件中读取来的)
		String servletName = "Some-Servlet";
		String servletClassName = "com.ikuta.servlets.SomeServlet";
		ServletRegistration.Dynamic srd = sc.addServlet(servletName, servletClassName);
		// 为Servlet添加动态参数
		srd.setInitParameter("username", "zhangsan");
		srd.setInitParameter("password", "123456");
		// 为Servlet指定url-pattern
		srd.addMapping("/some");

		/*-----------动态注册Filter---------------*/
		String filterName = "Some-Filter";
		String filterClassName = "com.ikuta.filters.SomeFilter";
		FilterRegistration.Dynamic frd = sc.addFilter(filterName, filterClassName);
		// 配置当前Filter的映射信息
		frd.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

		/*-----------动态注册Listener---------------*/
		String listenerClassName = "com.ikuta.listeners.MyRequestListener";
		sc.addListener(listenerClassName);
	}

}
