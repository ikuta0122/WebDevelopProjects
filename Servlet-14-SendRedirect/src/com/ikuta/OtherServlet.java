package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

public class OtherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 重定向时的数据传递
		String othername = request.getParameter("othername");
		// 解码:组装
		othername = URLDecoder.decode(othername, "UTF-8");
		
		String otherage = request.getParameter("otherage");
		System.out.println("othername =" + othername);
		System.out.println("otherage =" + otherage);

		PrintWriter out = response.getWriter();
		out.println("This is OtherServlet");
	}
}
