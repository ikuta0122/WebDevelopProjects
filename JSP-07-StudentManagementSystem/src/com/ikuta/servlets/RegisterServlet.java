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
		// 1.��ȡ������
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		Integer age = Integer.valueOf(ageStr);
		String scoreStr = request.getParameter("score");
		Double score = Double.valueOf(scoreStr);

		// 2.����Student����
		Student student = new Student(num, name, age, score);
		student.setPassword(password);

		// 3.����Service����
		IStudentService service = new StudentServiceImpl();

		// 4.����Service�����saveStudent()����������д��DB
		Integer id = service.saveStudent(student);

		// 5.д��ʧ������ת��ע��ҳ��,����ע��
		if (id == null) {
			response.sendRedirect(request.getContextPath() + "/register.jsp");
			return;
		}

		// 6.д��ɹ�����ת����¼ҳ��
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

}
