package com.ikuta.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/someServlet")
public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置相应的MIME类型
		response.setContentType("text/html;charset=UTF-8");
		// 获取标准输出流对象
		PrintWriter out = response.getWriter();
		out.println("执行SomeServlet");
	}
}
