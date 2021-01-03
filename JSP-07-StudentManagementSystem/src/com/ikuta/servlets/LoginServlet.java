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
		// 1.�����������
		String num = request.getParameter("num");
		String password = request.getParameter("password");
		// ��ȡSession
		HttpSession session = request.getSession(true);
		// num == null��ֹ�û�ֱ�Ӵӵ�ַ������
		// "".equals(num.trim())��ֹ�û�����дΪ��
		if (num == null || "".equals(num.trim())) {
			session.setAttribute("message", "ѧ����������");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		if (password == null || "".equals(password.trim())) {
			session.setAttribute("message", "������������");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		// 2.����Service����
		IStudentService service = new StudentServiceImpl();

		// 3.����Service�����checkUser()����,���û�������֤
		Student student = service.checkUser(num, password);

		// 4.��֤δͨ��,����ת����¼ҳ�����û��ٴ������¼��Ϣ,��ʱҳ����Ҫ������ʾ��Ϣ
		if (student == null) {
			session.setAttribute("message", "ѧ�Ż���������������");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		// 5.��֤ͨ������ת��ϵͳ��ҳ��index.jsp
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

}
