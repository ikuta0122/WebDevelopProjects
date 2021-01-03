package com.ikuta.threads;

import java.io.PrintWriter;

//定义子线程:进行较耗时的运算
public class ComputeThread implements Runnable {
	private PrintWriter out;

	public ComputeThread(PrintWriter out) {
		super();
		this.out = out;
	}

	@Override
	public void run() {
		out.print("子线程运行开始<br>");
		int sum = 0;
		
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println("i = " + i);
				sum += i;
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		out.print("sum = " + sum + "<br>");
		out.print("子线程运行结束<br>");
	}

}
