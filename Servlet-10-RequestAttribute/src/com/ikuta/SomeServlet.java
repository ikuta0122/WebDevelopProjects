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
		// 向请求中放入属性
		request.setAttribute("country", "China");
		request.setAttribute("address", "FuJian");

		// 从请求中删除指定的域属性
		request.removeAttribute("address");

		// 将请求转发给otherServlet
		request.getRequestDispatcher("/otherServlet").forward(request, response);
	}
}
