package com.ikuta.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.ikuta.decorators.CustomRequest;

//Tomcat7.0对于Filter的inti()方法和destroy()方法没有默认实现
public class CharactorEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 创建自定义的请求对象
		request = new CustomRequest((HttpServletRequest) request);

		// 修改响应的字符集编码
		response.setContentType("text/html;charset=UTF-8");

		chain.doFilter(request, response);
	}
}
