package com.ikuta.servlets;

import com.ikuta.threads.ComputeThread;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//实现异步运行,
@WebServlet(value = "/register", asyncSupported = true)
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取异步上下文对象
        AsyncContext ac = request.startAsync();
        // 启动一个耗时的运算过程(子线程)
        ComputeThread ct = new ComputeThread(ac);
        // 设置异步上下文对象的超时时限
        ac.setTimeout(3000);
        // 开启异步上下文对象
        ac.start(ct);

        // 主线程结束后给客户端的信息
        response.getWriter().println("please login your email to check the result");
    }

}
