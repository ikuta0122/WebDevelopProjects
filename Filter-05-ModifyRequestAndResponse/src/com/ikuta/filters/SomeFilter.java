package com.ikuta.filters;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SomeFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SomeFilter-------before");
		// 修改请求:向请求域中填加属性
		request.setAttribute("username", "zhangsan");
		request.setAttribute("password", "123456");
		chain.doFilter(request, response);
		System.out.println("SomeFilter-------after");

		// 修改响应:向标准输出流中写入数据
		PrintWriter out = response.getWriter();
		out.println("SomeFilter<br>");
	}
}
