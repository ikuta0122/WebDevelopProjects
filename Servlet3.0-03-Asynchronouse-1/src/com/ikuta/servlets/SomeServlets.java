package com.ikuta.servlets;

import com.ikuta.threads.ComputeThread;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/some")
public class SomeServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("主线程运行开始<br>");
        // 启动一个耗时的运算过程(子线程)
        ComputeThread computeThread = new ComputeThread(out);
        Thread subThead = new Thread(computeThread);
        subThead.start();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.print("主线程运行结束<br>");
    }

}
