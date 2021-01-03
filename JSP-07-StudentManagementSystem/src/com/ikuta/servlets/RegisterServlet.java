package com.ikuta.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ikuta.beans.Student;
import com.ikuta.service.IStudentService;
import com.ikuta.service.StudentServiceImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取表单参数
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		Integer age = Integer.valueOf(ageStr);
		String scoreStr = request.getParameter("score");
		Double score = Double.valueOf(scoreStr);

		// 2.创建Student对象
		Student student = new Student(num, name, age, score);
		student.setPassword(password);

		// 3.创建Service对象
		IStudentService service = new StudentServiceImpl();

		// 4.调用Service对象的saveStudent()方法将对象写入DB
		Integer id = service.saveStudent(student);

		// 5.写入失败则跳转到注册页面,重新注册
		if (id == null) {
			response.sendRedirect(request.getContextPath() + "/register.jsp");
			return;
		}

		// 6.写入成功则跳转到登录页面
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

}
