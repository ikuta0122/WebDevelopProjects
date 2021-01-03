package com.ikuta.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		// 获取请求域中携带的属性名称的集合
		Enumeration<String> names = request.getAttributeNames();
		// 遍历枚举
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = (String) request.getAttribute(name);
			System.out.println(name + " = " + value);
		}

		// 向标准输出流中写入数据
		PrintWriter out = response.getWriter();
		out.println("SomeServlet<br>");
	}

}
