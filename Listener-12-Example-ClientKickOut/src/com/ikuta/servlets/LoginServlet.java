package com.ikuta.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ikuta.beans.Client;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户提交的请求参数
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		Integer age = Integer.valueOf(ageStr);

		// 创建Client对象
		Client client = new Client(name, age);
		// 获取当前请求对应的session
		HttpSession session = request.getSession();
		// 将Client与Session绑定
		session.setAttribute("client", client);

		response.sendRedirect(request.getContextPath() + "/welcome.jsp");
	}

}
