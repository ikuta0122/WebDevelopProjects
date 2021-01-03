package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("name =" + name);
		System.out.println("age =" + age);
		
		// 编码:打散
		name = URLEncoder.encode(name, "UTF-8");
		
		// 重定向时数据的传递
		response.sendRedirect("other?othername=" + name + "&otherage=" + age);
	}
}
