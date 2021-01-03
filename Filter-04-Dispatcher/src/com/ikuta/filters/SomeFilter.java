package com.ikuta.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SomeFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SomeFilter chian.doFilter()之前 ");
		chain.doFilter(request, response);
		System.out.println("SomeFilter chian.doFilter()之后 ");

	}

}
