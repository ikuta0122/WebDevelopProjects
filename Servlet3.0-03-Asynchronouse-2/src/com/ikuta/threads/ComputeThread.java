package com.ikuta.threads;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;

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
            // 通知主线程异步子线程执行完毕
            ac.complete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
