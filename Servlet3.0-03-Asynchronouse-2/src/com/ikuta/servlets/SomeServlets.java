package com.ikuta.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ikuta.threads.ComputeThread;

//实现异步运行,
@WebServlet(value = "/some", asyncSupported = true)
public class SomeServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("主线程运行开始<br>");
		// 获取异步上下文对象
		AsyncContext ac = request.startAsync();
		// 启动一个耗时的运算过程(子线程)
		ComputeThread ct = new ComputeThread(ac);
		// 开启异步上下文对象
		ac.start(ct);
		out.print("主线程运行结束<br>");
	}

}
