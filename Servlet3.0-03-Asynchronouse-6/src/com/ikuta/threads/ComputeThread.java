package com.ikuta.threads;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
			HttpServletRequest request = (HttpServletRequest) ac.getRequest();
			HttpSession session = request.getSession();

			int sum = 0;
			for (int i = 1; i <= 10; i++) {
				sum += i;
				Thread.sleep(1000);
			}
			session.setAttribute("sum", sum);
			ac.complete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
