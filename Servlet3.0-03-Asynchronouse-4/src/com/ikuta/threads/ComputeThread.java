package com.ikuta.threads;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;

//定义子线程:进行较耗时的运算
public class ComputeThread implements Runnable {
	private AsyncContext ac;

	public ComputeThread(AsyncContext ac) {
		super();
		this.ac = ac;
	}

	@Override
	public void run() {
		try {
			PrintWriter out = ac.getResponse().getWriter();
			out.print("子线程运行开始<br>");
			int sum = 0;
			for (int i = 1; i <= 10; i++) {
				sum += i;
				Thread.sleep(1000);
			}
			out.print("sum = " + sum + "<br>");
			out.print("子线程运行结束<br>");
			ac.dispatch("/show.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
