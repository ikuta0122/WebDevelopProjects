package com.ikuta.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(value= {"/*"},dispatcherTypes = DispatcherType.FORWARD)
public class SomeFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SomeFilter-------->Before");
		chain.doFilter(request, response);
		System.out.println("SomeFilter-------->After");
	}
}
