package com.ikuta.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
使用DeBug进行测试
*/
public class SomeFilter implements Filter {

	public SomeFilter() {
		System.out.println("创建SomeFilter");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化SomeFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("执行SomeFilter---before");
		// 将请求放行到下一个资源
		chain.doFilter(request, response);
		System.out.println("执行SomeFilter---after");
	}

	@Override
	public void destroy() {
		System.out.println("销毁SomeFilter");
	}

}
