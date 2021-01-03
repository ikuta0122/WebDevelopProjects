package com.ikuta;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("执行SomeServlet");
		// Java文件后台路径举例分析
		/*
		 * 这是一个后台路径 后台路径的参照路径是当前web应用的根[http://localhost:8080/16-RelativePath-three]
		 * 服务器将其自动转换为绝对路径:http://localhost:8080/16-RelativePath-three/otherServlet
		 * 后台路径的作用:标识,即客户端想要访问该资源需要提交以上绝对路径
		 */
		request.getRequestDispatcher("/otherServlet").forward(request, response);

		// Java代码中以路径名称开头的相对路径举例分析
		// request.getRequestDispatcher("otherServlet").forward(request, response);
		// 这是一个以路径名称开头的相对路径
		// 其参照路径为:http://localhost:8080/16-RealativePath-three
		// 服务器将其自动转换为绝对路径:http://localhost:8080/16-RealativePath-three/otherServlet
		// 该绝对路径可以访问到OtherServlet
	}

}
