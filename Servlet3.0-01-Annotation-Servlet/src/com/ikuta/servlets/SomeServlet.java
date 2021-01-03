package com.ikuta.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = { "/some", "/xxx", "/jjj" }, name = "SomeServlet", initParams = {
		@WebInitParam(name = "username", value = "zhangsan"), @WebInitParam(name = "password", value = "123456") })
//@WebServlet(urlPatterns = { "/some", "/xxx", "/jjj" })
public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SomeServlet() {
		System.out.println("SomeServlet被创建");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应的MIME类型
		response.setContentType("text/html;charset=UTF-8");
		// 获取标准输出流对象
		PrintWriter out = response.getWriter();

		// 获取ServletName
		String servletName = this.getServletName();
		out.println("servletName = " + servletName + "<br>");
		// 获取初始化参数
		Enumeration<String> names = this.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = this.getInitParameter(name);
			out.println(name + " = " + value + "<br>");
		}
	}

}
