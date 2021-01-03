package com.ikuta.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
问题:使用GET提交时,如果请求中携带有中文,为什么会产生乱码?
原因:当用户提交了一个包含中文参数的请求时
	1)浏览器首先会将这些中文转化为一个字节序列发送到服务器
	2)服务器接收到这个字节序列后,按照默认字符编码ISO8859-1对该字节序列进行解码	
	3)服务器会将解码过的参数存放到parameterMap中,此时这个Map中的参数已经是乱码了
解决:使用装饰者设计模式
*/
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收请求参数
		String username = request.getParameter("username");
		System.out.println("username = " + username);

		// 将响应写入标准输出流
		PrintWriter out = response.getWriter();
		out.println("username = " + username);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
