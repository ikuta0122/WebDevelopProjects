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
			// 对运算结果进行分析
			String message = "注册失败,请重新注册";
			if (sum == 55) {
				message = "注册成功";
			}
			// 将分析结果存放到session域中
			session.setAttribute("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
