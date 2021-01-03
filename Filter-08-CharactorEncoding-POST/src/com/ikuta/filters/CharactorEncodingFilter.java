package com.ikuta.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharactorEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 修改请求的字符集编码
		request.setCharacterEncoding("UTF-8");
		// 修改响应的字符集编码
		response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(request, response);
	}

}
