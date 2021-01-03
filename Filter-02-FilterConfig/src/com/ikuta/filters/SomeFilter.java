package com.ikuta.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SomeFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 获取Filter的名称
		String filterName = filterConfig.getFilterName();
		System.out.println("filterName = " + filterName);

		// 获取Filter的所有初始化参数名称的集合
		Enumeration<String> names = filterConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			// 获取Filter的指定初始化参数
			String value = filterConfig.getInitParameter(name);
			System.out.println(name + " = " + value);
		}

		// 获取Filter的全局域对象
		ServletContext servletContext = filterConfig.getServletContext();
		System.out.println("servletContext = " + servletContext);

		// 将请求放行到下一个资源
		chain.doFilter(request, response);
	}

}
