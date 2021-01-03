package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取[请求的URL]
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("requestURL = " + requestURL);
		// requestURL = http://localhost:8080/11-RequestOtherMethod/first/second/*
		// 获取[请求的URI]
		String requestURI = request.getRequestURI();
		System.out.println("requestURI = " + requestURI);
		// requestURI = /11-RequestOtherMethod/first/second/*

		// 获取当前web应用的根路径
		String contextPath = request.getContextPath();
		System.out.println("contextPath = " + contextPath);
		// contextPath = /11-RequestOtherMethod

		// 获取请求路径与匹配路径的精确部分
		String servletPath = request.getServletPath();
		System.out.println("servletPath = " + servletPath);
		// servletPath = /first/second

		// 获取请求路径与匹配路径的非精确部分
		String pathInfo = request.getPathInfo();
		System.out.println("pathInfo = " + pathInfo);
		// pathInfo = /*

		// 获取请求的提交方式
		String method = request.getMethod();
		System.out.println("method = " + method);
		// method = GET

		// 获取客户端IP
		String clientIP = request.getRemoteAddr();
		System.out.println("clientIP = " + clientIP);
		// clientIP = 0:0:0:0:0:0:0:1
	}

}
