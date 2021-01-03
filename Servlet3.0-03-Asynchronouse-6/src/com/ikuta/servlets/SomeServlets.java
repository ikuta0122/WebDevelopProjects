package com.ikuta.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
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
		// 设置异步上下文对象的超时时限
		ac.setTimeout(3000);
		// 为异步对象添加异步监听器
		ac.addListener(new AsyncListener() {

			@Override
			public void onTimeout(AsyncEvent event) throws IOException {
				System.out.println("异步操作已超时");
			}

			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {

			}

			@Override
			public void onError(AsyncEvent event) throws IOException {

			}

			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				System.out.println("异步操作已完成");
			}
		});
		// 开启异步上下文对象
		ac.start(ct);
		out.print("主线程运行结束<br>");
		out.print("请到邮箱查看注册情况<br>");
	}

}
