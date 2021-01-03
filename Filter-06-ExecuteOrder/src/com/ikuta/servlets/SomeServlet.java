package com.ikuta.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
执行SomeFilter-----before
执行OtherFilter-----before
执行SomeServlet
执行OtherFilter-----after
执行SomeFilter-----after
*/
public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("执行SomeServlet");
	}

}
