package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
因为Servlet是单例多线程的,而且又存在可修改的成员变量username
所以LoginServlet存在线程安全问题,即这个Servlet是不安全的
*/
/*Servlet线程安全问题的解决
1)将成员变量修改为局部变量
2)使用线程同步机制synchronized,效率较低
*/
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
//	原代码(存在线程安全问题)
//	private String username;
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		username = request.getParameter("username");
//		PrintWriter out = response.getWriter();
//		out.print("username = " + username);
//	}

//	第一种方案:将成员变量修改为局部变量
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String username = request.getParameter("username");
//		PrintWriter out = response.getWriter();
//		out.print("username = " + username);
//	}

    // 第二种方案:使用线程同步机制synchronized,效率较低
    private String username;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        synchronized (this) {
            username = request.getParameter("username");
            PrintWriter out = response.getWriter();
            out.print("username = " + username);
        }
    }
}
