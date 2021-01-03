package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取Session对象
		HttpSession session = request.getSession(true);
		// 获取用户提交参数
		String username = request.getParameter("username");

		// 将参数放入request域属性空间
		request.setAttribute("username_request", username);
		response.getWriter().println("SomeServlet:" + username);

		// 将参数放入session域属性空间
		session.setAttribute("username_session", username);
		response.getWriter().println("SomeServlet:" + username);
		// 使Session失效
		// session.invalidate();
	}
}
