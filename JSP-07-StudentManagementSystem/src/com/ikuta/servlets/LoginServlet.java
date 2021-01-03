package com.ikuta.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ikuta.beans.Student;
import com.ikuta.service.IStudentService;
import com.ikuta.service.StudentServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.接收请求参数
		String num = request.getParameter("num");
		String password = request.getParameter("password");
		// 获取Session
		HttpSession session = request.getSession(true);
		// num == null防止用户直接从地址栏访问
		// "".equals(num.trim())防止用户表单填写为空
		if (num == null || "".equals(num.trim())) {
			session.setAttribute("message", "学号输入有误");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		if (password == null || "".equals(password.trim())) {
			session.setAttribute("message", "密码输入有误");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		// 2.创建Service对象
		IStudentService service = new StudentServiceImpl();

		// 3.调用Service对象的checkUser()方法,对用户进行验证
		Student student = service.checkUser(num, password);

		// 4.验证未通过,则跳转到登录页面让用户再次输入登录信息,此时页面需要给出提示信息
		if (student == null) {
			session.setAttribute("message", "学号或者密码输入有误");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		// 5.验证通过则跳转到系统主页面index.jsp
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

}
